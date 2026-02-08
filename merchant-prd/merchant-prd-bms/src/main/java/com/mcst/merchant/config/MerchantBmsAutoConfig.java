package com.mcst.merchant.config;

import com.mcst.merchant.controller.MerchantInfoBmsController;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

/**
 * Merchant BMS 控制器自动配置类
 *
 * @author Gemini
 */
@AutoConfiguration
public class MerchantBmsAutoConfig {

    @Bean
    @ConditionalOnMissingBean
    public MerchantInfoBmsController merchantInfoBmsController() {
        return new MerchantInfoBmsController();
    }
}