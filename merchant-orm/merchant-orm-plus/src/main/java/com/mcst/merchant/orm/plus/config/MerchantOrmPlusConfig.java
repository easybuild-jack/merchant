package com.mcst.merchant.orm.plus.config;

import com.mcst.merchant.orm.plus.repository.impl.MerchantInfoRepositoryImpl;
import com.mcst.merchant.orm.repository.IMerchantInfoRepository;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
@EnableConfigurationProperties
public class MerchantOrmPlusConfig {

    @Bean
    @ConditionalOnMissingBean
    public IMerchantInfoRepository merchantInfoRepository() {
        return new MerchantInfoRepositoryImpl();
    }

}
