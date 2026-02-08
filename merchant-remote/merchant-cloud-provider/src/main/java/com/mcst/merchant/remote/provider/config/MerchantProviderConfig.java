package com.mcst.merchant.remote.provider.config;

import com.mcst.merchant.remote.IMerchantInfoRemote;
import com.mcst.merchant.remote.provider.impl.MerchantInfoRemoteImpl;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

/**
 *
 * @author liu yijun
 */
@AutoConfiguration
public class MerchantProviderConfig {

    @Bean
    @ConditionalOnMissingBean
    public IMerchantInfoRemote merchantInfoRemote() {
        return new MerchantInfoRemoteImpl();
    }


}
