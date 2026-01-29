package com.mcst.merchant.remote.config;


import com.mcst.merchant.api.*;
import com.mcst.merchant.remote.impl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Configuration;

/**
*
* @author liu yijun
*/
@Configuration
public class MerchantApiConfig {
    @Bean
    @ConditionalOnMissingBean
    public IMerchantInfoApi merchantInfoApi() {
         return new MerchantInfoApiDubboImpl();
    }


}
