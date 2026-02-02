-- ============================================================
-- PostgreSQL 建表脚本
-- 生成时间: 2026-01-24
-- 说明: 商户模块相关表结构
-- ============================================================

-- 1. 商户信息表
DROP TABLE IF EXISTS merchant_info CASCADE;
CREATE TABLE merchant_info (
    merchant_id VARCHAR(50) NOT NULL,
    merchant_name VARCHAR(200) DEFAULT NULL,
    merchant_code VARCHAR(50) DEFAULT NULL,
    logo VARCHAR(500) DEFAULT NULL,
    title VARCHAR(200) DEFAULT NULL,
    sub_title VARCHAR(200) DEFAULT NULL,
    province VARCHAR(50) DEFAULT NULL,
    city VARCHAR(50) DEFAULT NULL,
    area VARCHAR(50) DEFAULT NULL,
    address VARCHAR(200) DEFAULT NULL,
    address_info VARCHAR(500) DEFAULT NULL,
    link_man VARCHAR(50) DEFAULT NULL,
    link_phone VARCHAR(20) DEFAULT NULL,
    business_hours VARCHAR(100) DEFAULT NULL,
    longitude VARCHAR(50) DEFAULT NULL,
    latitude VARCHAR(50) DEFAULT NULL,
    forbidden_flag SMALLINT NOT NULL DEFAULT 0,
    agent_id VARCHAR(50) DEFAULT NULL,
    agent_name VARCHAR(200) DEFAULT NULL,
    insert_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    last_update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted SMALLINT NOT NULL DEFAULT 0,
    CONSTRAINT pk_merchant_info PRIMARY KEY (merchant_id),
    CONSTRAINT uk_merchant_info_merchant_code UNIQUE (merchant_code)
);

-- 创建索引
CREATE INDEX idx_merchant_info_agent_id ON merchant_info(agent_id);
CREATE INDEX idx_merchant_info_deleted ON merchant_info(deleted);

-- 创建触发器函数
CREATE OR REPLACE FUNCTION update_merchant_timestamp()
RETURNS TRIGGER AS $$
BEGIN
    NEW.last_update_time = CURRENT_TIMESTAMP;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- 创建触发器
CREATE TRIGGER trigger_update_merchant_info_timestamp
    BEFORE UPDATE ON merchant_info
    FOR EACH ROW
    EXECUTE FUNCTION update_merchant_timestamp();

-- 表注释
COMMENT ON TABLE merchant_info IS '商户信息';
COMMENT ON COLUMN merchant_info.merchant_id IS '商户ID';
COMMENT ON COLUMN merchant_info.merchant_name IS '商户名称';
COMMENT ON COLUMN merchant_info.merchant_code IS '商户代码';
COMMENT ON COLUMN merchant_info.logo IS '商户 logo';
COMMENT ON COLUMN merchant_info.title IS '标题';
COMMENT ON COLUMN merchant_info.sub_title IS '副标题';
COMMENT ON COLUMN merchant_info.province IS '省份';
COMMENT ON COLUMN merchant_info.city IS '城市';
COMMENT ON COLUMN merchant_info.area IS '区域';
COMMENT ON COLUMN merchant_info.address IS '具体地址';
COMMENT ON COLUMN merchant_info.address_info IS '详细地址信息（省市区+具体地址）';
COMMENT ON COLUMN merchant_info.link_man IS '联系人';
COMMENT ON COLUMN merchant_info.link_phone IS '联系电话';
COMMENT ON COLUMN merchant_info.business_hours IS '营业时间';
COMMENT ON COLUMN merchant_info.longitude IS '经度';
COMMENT ON COLUMN merchant_info.latitude IS '纬度';
COMMENT ON COLUMN merchant_info.forbidden_flag IS '禁用状态 0可用，1禁用';
COMMENT ON COLUMN merchant_info.agent_id IS '代理商ID';
COMMENT ON COLUMN merchant_info.agent_name IS '代理商名称';
COMMENT ON COLUMN merchant_info.insert_time IS '插入时间';
COMMENT ON COLUMN merchant_info.last_update_time IS '最后更新时间';
COMMENT ON COLUMN merchant_info.deleted IS '删除标记，0否 1是';
