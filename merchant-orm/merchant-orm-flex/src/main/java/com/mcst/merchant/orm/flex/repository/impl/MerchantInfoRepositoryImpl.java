package com.mcst.merchant.orm.flex.repository.impl;

import com.mcst.easyfk.service.flex.impl.BaseFlexRepositoryImpl;
import com.mcst.merchant.api.dto.MerchantInfoDto;
import com.mcst.merchant.orm.flex.persistence.mapper.MerchantInfoMapper;
import com.mcst.merchant.orm.flex.persistence.model.MerchantInfo;
import com.mcst.merchant.orm.repository.IMerchantInfoRepository;

public class MerchantInfoRepositoryImpl extends BaseFlexRepositoryImpl<MerchantInfoMapper, MerchantInfoDto, MerchantInfo, String> implements IMerchantInfoRepository {
}
