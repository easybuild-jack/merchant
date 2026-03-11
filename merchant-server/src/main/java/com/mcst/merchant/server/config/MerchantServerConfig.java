package com.mcst.merchant.server.config;

import com.mcst.merchant.api.IMerchantInfoApi;
import com.mcst.merchant.server.impl.MerchantInfoApiServerImpl;
import com.mcst.merchant.server.service.IMerchantInfoService;
import com.mcst.merchant.server.service.impl.MerchantInfoServiceImpl;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 *
 * @author liu yijun
 */
@AutoConfiguration
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

}
