package com.mcst.merchant.remote.provider.config;

import com.mcst.merchant.remote.*;
import com.mcst.merchant.remote.provider.impl.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;

/**
*
* @author liu yijun
*/
@Configuration
public class MerchantProviderConfig {

    @Bean
    @ConditionalOnMissingBean
    public IMerchantInfoRemote merchantInfoRemote() {
         return new MerchantInfoRemoteImpl();
    }


}
