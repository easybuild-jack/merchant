package com.mcst.merchant.remote.config;


import com.mcst.merchant.api.*;
import com.mcst.merchant.remote.impl.*;
import com.mcst.merchant.remote.properties.MerchantApiProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
*
* @author liu yijun
*/
@Configuration
@EnableConfigurationProperties(MerchantApiProperties.class)
public class MerchantApiConfig {
    @Bean
    @ConditionalOnMissingBean
    public IMerchantInfoApi merchantInfoApi() {
         return new MerchantInfoApiScImpl();
    }


}
