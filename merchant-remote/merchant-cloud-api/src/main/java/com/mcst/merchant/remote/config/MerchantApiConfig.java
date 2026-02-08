package com.mcst.merchant.remote.config;


import com.mcst.merchant.api.IMerchantInfoApi;
import com.mcst.merchant.remote.impl.MerchantInfoApiScImpl;
import com.mcst.merchant.remote.properties.MerchantApiProperties;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 *
 * @author liu yijun
 */
@AutoConfiguration
@EnableConfigurationProperties(MerchantApiProperties.class)
public class MerchantApiConfig {
    @Bean
    @ConditionalOnMissingBean
    public IMerchantInfoApi merchantInfoApi() {
        return new MerchantInfoApiScImpl();
    }


}
