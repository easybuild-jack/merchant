package com.mcst.merchant.remote.provider.config;

import com.mcst.merchant.remote.IMerchantInfoRemote;
import com.mcst.merchant.remote.provider.impl.MerchantInfoRemoteImpl;
import org.apache.dubbo.config.ServiceConfig;
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
    public ServiceConfig<IMerchantInfoRemote> merchantInfoRemoteServiceConfig(MerchantInfoRemoteImpl merchantInfoRemoteImpl) {
        ServiceConfig<IMerchantInfoRemote> serviceConfig = new ServiceConfig<>();
        serviceConfig.setInterface(IMerchantInfoRemote.class);
        serviceConfig.setRef(merchantInfoRemoteImpl);
        serviceConfig.export();
        return serviceConfig;
    }


}
