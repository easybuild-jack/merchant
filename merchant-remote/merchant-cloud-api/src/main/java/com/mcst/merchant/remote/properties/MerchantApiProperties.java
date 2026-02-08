package com.mcst.merchant.remote.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 *
 * @author liu yijun
 * @since 2026-01-19
 */
@ConfigurationProperties(prefix = "easyfk.config.remote.merchant")
@Data
public class MerchantApiProperties {
    /**
     * Merchant模块的ServiceId配置
     */
    private String serviceId;
    /**
     * path 前缀地址，如：/remote 或/api 等，默认/remote
     */
    private String basePath;
}
