package com.mcst.merchant.remote.config;


import com.mcst.merchant.api.IMerchantInfoApi;
import com.mcst.merchant.remote.impl.MerchantInfoApiDubboImpl;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

/**
 *
 * @author liu yijun
 */
@AutoConfiguration
public class MerchantApiConfig {
    @Bean
    @ConditionalOnMissingBean
    public IMerchantInfoApi merchantInfoApi() {
        return new MerchantInfoApiDubboImpl();
    }


}
