package com.mcst.merchant.config;

import com.mcst.merchant.controller.MerchantInfoController;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

/**
 * Merchant Client 控制器自动配置类
 *
 * @author Gemini
 */
@AutoConfiguration
public class MerchantClientAutoConfig {

    @Bean
    @ConditionalOnMissingBean
    public MerchantInfoController merchantInfoController() {
        return new MerchantInfoController();
    }
}