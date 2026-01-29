package com.mcst.merchant.server.config;

import com.mcst.merchant.api.*;
import com.mcst.merchant.server.service.*;
import com.mcst.merchant.server.repository.*;
import com.mcst.merchant.server.impl.*;
import com.mcst.merchant.server.service.impl.*;
import com.mcst.merchant.server.repository.impl.*;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
/**
*
* @author liu yijun
*/
@Configuration
@EnableConfigurationProperties
public class MerchantServerConfig {

    @Bean
    @ConditionalOnMissingBean
    public IMerchantInfoApi merchantInfoApi() {
        return new MerchantInfoApiServerImpl();
    }


    @Bean
    @ConditionalOnMissingBean
    public IMerchantInfoService merchantInfoService() {
        return new MerchantInfoServiceImpl();
    }

    @Bean
    @ConditionalOnMissingBean
    public IMerchantInfoRepository merchantInfoRepository() {
        return new MerchantInfoRepositoryImpl();
    }


}
