package com.mcst.merchant.orm.hibernate.persistence.mapper;

import com.mcst.merchant.orm.hibernate.persistence.model.MerchantInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MerchantInfoMapper extends JpaRepository<MerchantInfo, String>, JpaSpecificationExecutor<MerchantInfo> {
}
