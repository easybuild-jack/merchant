package com.mcst.merchant.orm.hibernate.config;

import com.mcst.merchant.orm.hibernate.repository.impl.MerchantInfoRepositoryImpl;
import com.mcst.merchant.orm.repository.IMerchantInfoRepository;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
@EnableConfigurationProperties
public class MerchantOrmHibernateConfig {
    @Bean
    @ConditionalOnMissingBean
    public IMerchantInfoRepository merchantInfoRepository() {
        return new MerchantInfoRepositoryImpl();
    }
}
