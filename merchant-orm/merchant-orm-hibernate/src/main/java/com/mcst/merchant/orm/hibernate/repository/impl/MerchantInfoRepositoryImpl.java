package com.mcst.merchant.orm.hibernate.repository.impl;

import com.mcst.easyfk.service.hibernate.impl.BaseHibernateRepositoryImpl;
import com.mcst.merchant.api.dto.MerchantInfoDto;
import com.mcst.merchant.orm.hibernate.persistence.model.MerchantInfo;
import com.mcst.merchant.orm.hibernate.persistence.mapper.MerchantInfoMapper;
import com.mcst.merchant.orm.repository.IMerchantInfoRepository;

public class MerchantInfoRepositoryImpl extends BaseHibernateRepositoryImpl<MerchantInfoMapper, MerchantInfoDto, MerchantInfo, String> implements IMerchantInfoRepository {
}
