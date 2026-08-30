# Merchant 商户管理模块

> 基于 `easyfk` 基础框架的**商户基础信息**管理模块，提供商户档案、联系信息、地理位置、品牌展示等能力的统一管理，同时支持 **Spring Cloud（Feign）** 与 **Apache Dubbo** 两种远程调用方式，方便单体或微服务架构集成。

- **项目版本**：`<latest>`（请以实际发布的最新版本为准）
- **Maven Group**：`com.mcst`
- **构建工具**：Gradle（版本以根 `gradle/wrapper/gradle-wrapper.properties` 为准）
- **JDK**：Java 21+
- **框架**：Spring Boot 3.x、Spring Cloud OpenFeign、Apache Dubbo 3.x
- **辅助工具**：Lombok、MapStruct Plus、Hutool

---

## 一、项目主要功能

1. **商户档案**
   - 名称、编码、Logo、标题、副标题等品牌展示信息。
   - 联系信息：联系人、联系电话、营业时间。

2. **地理信息**
   - 省市区、详细地址、经纬度。
   - 内置经纬度字段，可直接用于距离计算与地图展示（支持"附近商家"等位置服务）。

3. **状态管理**
   - 启用 / 禁用控制。

4. **双端接口分离**
   - C 端提供商户详情、列表、下拉选择。
   - BMS 端支持完整增删改查。

5. **多租户与数据隔离**
   - 内置 `agentId` 字段，自动按代理商维度过滤数据。

6. **国际化与可配置**
   - 多语言错误码（基于 `i18n/merchantMessage_*.properties`）。

---

## 二、项目架构设计

### 2.1 模块划分

```
merchant
├── merchant-api          接口契约层：DTO / Req / Resp / Param / VO / Service API
├── merchant-server       服务实现层：Service + ApiServer 实现 + 工具类 + 配置 + 单测
├── merchant-prd          Web 表现层：Spring Boot Controller
│   ├── merchant-prd-client     C 端接口
│   └── merchant-prd-bms        后台管理接口
├── merchant-orm          持久化层
│   ├── merchant-orm-api         仓储接口定义（IRepository）
│   ├── merchant-orm-plus        MyBatis-Plus 实现
│   ├── merchant-orm-flex        MyBatis-Flex 实现
│   └── merchant-orm-hibernate   Hibernate/JPA 实现
├── merchant-remote       远程调用层（可选接入）
│   ├── merchant-cloud-api         Spring Cloud 客户端：Feign 接口 + Api 适配
│   ├── merchant-cloud-provider    Spring Cloud 服务端：暴露 /remote/merchant/** 的 Controller
│   ├── merchant-dubbo-api         Dubbo 接口 + Api 适配
│   └── merchant-dubbo-provider    Dubbo 服务端实现
└── doc               数据库脚本与映射规范说明
    ├── sql/merchant_mysql.sql
    └── sql/merchant_postgresql.sql
```

### 2.2 层次与调用关系

```
┌──────────────────────────────────────────────────────────────────────┐
│  客户端 / 调用方                                                       │
└──────────────────────────────────────────────────────────────────────┘
            │                           │                        │
            ▼                           ▼                        ▼
     ┌────────────┐               ┌────────────┐           ┌────────────┐
     │ merchant-  │               │ merchant-  │           │ merchant-  │
     │ prd        │               │ cloud-api  │           │ dubbo-api  │
     │ -client/-  │               │ (Feign 客  │           │ (Dubbo 消  │
     │  bms       │               │ 户端+Api)  │           │ 费端+Api)  │
     │(Controller │               │            │           │            │
     └────────────┘               └────────────┘           └────────────┘
            │                           │                        │
            │                           │ HTTP                   │ Dubbo RPC
            ▼                           ▼                        ▼
                          ┌──────────────────────────────────────┐
                          │ merchant-cloud-provider /            │
                          │ merchant-dubbo-provider              │
                          │ （统一委托给 merchant-server）         │
                          └──────────────────────────────────────┘
                                              │
                                              ▼
                              ┌──────────────────────────────┐
                              │        merchant-server        │
                              │   Service + ApiServer 实现   │
                              └──────────────────────────────┘
                                              │
                                              ▼
                              ┌──────────────────────────────┐
                              │ merchant-orm-*（Plus/Flex/Hib）│
                              │   仓储接口 + 持久化实现        │
                              └──────────────────────────────┘
                                              │
                                              ▼
                                          数据库
```

### 2.3 关键设计点

- **接口与实现分离**：`merchant-api` 只暴露接口与数据模型；`merchant-server` 提供本地默认实现，通过 Spring Boot 自动装配以 `@ConditionalOnMissingBean` 形式暴露为 Bean，便于上层覆盖。
- **多 ORM 适配**：`merchant-orm` 把仓储接口抽到 `merchant-orm-api`，底层分别在 `merchant-orm-plus / merchant-orm-flex / merchant-orm-hibernate` 中提供实现，业务侧按需引入对应依赖即可切换 ORM。
- **远程调用可插拔**：`merchant-remote` 同时提供 Feign 和 Dubbo 两套客户端，每套又拆出 `-api`（消费端）与 `-provider`（服务端）。消费端把 `IMerchantApi` 适配到远程 `Remote`，再通过 `@AutoConfiguration` 注册到容器；服务端把 `merchant-server` 的 `Service` 透出成 HTTP / Dubbo 接口。
- **统一参数模型**：遵循 `doc/实体对象映射关系调整指南.md` 中约定的流向（`Sub → Req → Dto → Entity` / `Entity → Dto → Resp`），结合 MapStruct Plus 的 `@AutoMapper` 自动转换。
- **LBS 支持**：经纬度字段建立组合索引，支持"附近商家"等位置查询。
- **独立部署**：作为独立服务运行，其他模块通过远程调用获取商户数据。
- **声明式权限控制**：BMS 端通过 `@AuthResource` / `@ResourceController` 注解自动注册菜单与按钮权限，与 Auth 模块联动。

### 2.4 数据模型

| 表名 | 说明 |
| --- | --- |
| `merchant` | 商户主表，含名称、编码、Logo、品牌信息、联系信息、地理位置、租户等 |

完整建表脚本见 [doc/sql/merchant_mysql.sql](doc/sql/merchant_mysql.sql)、[doc/sql/merchant_postgresql.sql](doc/sql/merchant_postgresql.sql)。

---

## 三、模块详细说明

### 3.1 `merchant-api`
- 定义业务接口：`IMerchantApi`，并继承 `IBaseApi` 提供通用 CRUD。
- 维护所有数据传输对象：`dto/`、`request/`、`response/`、`param/`、`vo/`。
- 业务接口方法示例：`queryByPage`、`queryById`、`save`、`delete`、`disable`、`selectList`、`queryNearby` 等。

### 3.2 `merchant-server`
- `service/`：业务 Service 接口与实现（`MerchantServiceImpl`）。
- `impl/`：`ApiServer` 实现，继承 `BaseApiServiceImpl`，把 Service 暴露为 `IMerchantApi`。
- `util/`：经纬度计算、地址解析等工具类。
- `config/MerchantServerConfig`：Spring Boot 自动装配入口。
- `src/test/`：基于 JUnit 5 的单元测试。

### 3.3 `merchant-prd`
- 基于 `easyfk-web-prd` 的 Spring Boot Web 控制器层。
- 控制器清单：
  - `MerchantBmsController`：`/api/bms/operation/merchant/**`（详情、分页、新增/编辑、删除、启用/禁用）
  - `MerchantClientController`：`/api/client/merchant/**`（详情、列表、下拉）
- 通过 `@AuthResource` / `@ResourceController` 注解自动注册权限元数据。

### 3.4 `merchant-orm`
- `merchant-orm-api`：仓储接口（`IMerchantRepository`）。
- `merchant-orm-plus`：基于 MyBatis-Plus 的实现 + 自动装配。
- `merchant-orm-flex`：基于 MyBatis-Flex 的实现 + 自动装配。
- `merchant-orm-hibernate`：基于 Hibernate/JPA 的实现 + 自动装配。

> 三个 ORM 实现互斥，按需在业务工程中只引入其中一个，避免冲突。

### 3.5 `merchant-remote`
- `merchant-cloud-api`：`FeignClient` 接口 + 继承 `BaseApiRemoteImpl` 的 `Api` 实现；通过 `MerchantApiProperties`（`easyfk.config.remote.merchant.service-id/base-path`）读取服务地址。
- `merchant-cloud-provider`：`@RestController` 把 `merchant-server` 的 `Service` 暴露为 `/remote/merchant/**`。
- `merchant-dubbo-api`：Dubbo 接口 + `Api` 适配实现。
- `merchant-dubbo-provider`：Dubbo 服务实现。

### 3.6 `doc`
- `实体对象映射关系调整指南.md`：DTO/Entity/Req/Resp/Param/Sub 之间的 `@AutoMapper` 使用规范。
- `sql/`：MySQL、PostgreSQL 建表脚本。

---

## 四、使用方式

### 4.1 构建与发布

```bash
# 清理并编译全部模块
./gradlew clean build

# 发布到本地 Maven 仓库
./gradlew publishToMavenLocal

# 发布到远程 Nexus（在 build.gradle 中已配置 NexusRepository）
./gradlew publish
```

> Windows 环境可直接使用 `gradlew.bat`。模块统一版本：`<latest>`。

### 4.2 单体应用集成（最简方式）

```groovy
dependencies {
    implementation 'com.mcst:merchant-api:<latest>'
    implementation 'com.mcst:merchant-server:<latest>'
    // 选择一种 ORM：
    implementation 'com.mcst:merchant-orm:merchant-orm-plus:<latest>'
    // implementation 'com.mcst:merchant-orm:merchant-orm-flex:<latest>'
    // implementation 'com.mcst:merchant-orm:merchant-orm-hibernate:<latest>'

    // 暴露 HTTP 接口（按端选择）
    implementation 'com.mcst:merchant-prd:merchant-prd-bms:<latest>'
    implementation 'com.mcst:merchant-prd:merchant-prd-client:<latest>'
}
```

`merchant-server` 会通过 Spring Boot 自动装配把 `IMerchantApi` 等 Bean 注册到容器，Controller 可直接 `@Resource` 注入使用。

### 4.3 微服务集成（Spring Cloud）

**消费端：**

```groovy
dependencies {
    implementation 'com.mcst:merchant-api:<latest>'
    implementation 'com.mcst:merchant-remote:merchant-cloud-api:<latest>'
}
```

```yaml
easyfk:
  config:
    remote:
      merchant:
        service-id: merchant-server    # 对应服务在注册中心的服务名
        base-path: /remote              # 可选，默认 /remote
```

**服务端：** 启动 `merchant-server` 并加入 `merchant-remote:merchant-cloud-provider`，即可对外提供 `/remote/merchant/**` 接口。

### 4.4 微服务集成（Apache Dubbo）

```groovy
// 消费端
dependencies {
    implementation 'com.mcst:merchant-api:<latest>'
    implementation 'com.mcst:merchant-remote:merchant-dubbo-api:<latest>'
}

// 服务端
dependencies {
    implementation 'com.mcst:merchant-server:<latest>'
    implementation 'com.mcst:merchant-remote:merchant-dubbo-provider:<latest>'
}
```

### 4.5 关键配置项

| 配置项 | 含义 | 默认值 |
| --- | --- | --- |
| `easyfk.config.remote.merchant.service-id` | 远程调用目标服务名 | `merchant-server` |
| `easyfk.config.remote.merchant.base-path` | 远程调用基础路径 | `/remote` |

### 4.6 初始化数据库

```bash
# MySQL
mysql -u <user> -p <database> < doc/sql/merchant_mysql.sql

# PostgreSQL
psql -U <user> -d <database> -f doc/sql/merchant_postgresql.sql
```

### 4.7 主要 REST 接口一览

| 端 | 路径 | 方法 | 说明 |
| --- | --- | --- | --- |
| BMS | `/api/bms/operation/merchant/detail` | GET | 详情 |
| BMS | `/api/bms/operation/merchant/queryPage` | GET | 分页查询 |
| BMS | `/api/bms/operation/merchant/addOrEdit` | POST | 新增 / 编辑 |
| BMS | `/api/bms/operation/merchant/delete` | POST | 批量删除 |
| BMS | `/api/bms/operation/merchant/disable` | POST | 启用 / 禁用 |
| Client | `/api/client/merchant/queryPage` | GET | C 端分页查询 |
| Client | `/api/client/merchant/detail` | GET | C 端详情 |
| Client | `/api/client/merchant/selectList` | GET | C 端下拉数据 |
| Client | `/api/client/merchant/nearby` | GET | C 端附近商户 |

> 接口均通过 Swagger OpenAPI 注解描述，可在启动后访问 `/swagger-ui.html` 查看完整文档。

---

## 五、扩展指引

- **新增业务字段**：在 `merchant-api` 的 `Dto` 中新增字段 → 在 `Entity` 中同步 → 选择对应 ORM 模块更新映射 → 视情况更新 `Resp`、`Req`、`VO`。
- **新增业务接口**：在 `merchant-api` 暴露方法 → 在 `merchant-server` 的 `Service` 与 `ApiServer` 中实现 → 选择在 `merchant-prd` 增加 Controller 或在 `merchant-remote` 暴露远程能力。
- **切换 ORM**：只保留目标 ORM 模块的依赖（如只想用 MyBatis-Plus，则移除 `merchant-orm-flex`、`merchant-orm-hibernate` 依赖）。
- **国际化**：在 `merchant-server/src/main/resources/i18n/` 下追加语言键值即可。

---

## 六、目录速览

```
merchant
├── build.gradle                根构建脚本（统一版本、Java 21、Lombok、MapStruct Plus）
├── settings.gradle             多模块声明
├── gradle/, gradlew, gradlew.bat
├── merchant-api/               接口契约
├── merchant-server/            服务实现 + 单测
├── merchant-prd/
│   ├── merchant-prd-client/
│   └── merchant-prd-bms/
├── merchant-orm/
│   ├── merchant-orm-api/
│   ├── merchant-orm-plus/
│   ├── merchant-orm-flex/
│   └── merchant-orm-hibernate/
├── merchant-remote/
│   ├── merchant-cloud-api/
│   ├── merchant-cloud-provider/
│   ├── merchant-dubbo-api/
│   └── merchant-dubbo-provider/
└── doc/
    └── sql/
```
