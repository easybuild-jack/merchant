package com.mcst.merchant.orm.plus.repository.impl;

import com.mcst.easyfk.service.mybatisplus.impl.BaseMyBatisRepositoryImpl;
import com.mcst.merchant.api.dto.MerchantInfoDto;
import com.mcst.merchant.orm.plus.persistence.mapper.MerchantInfoMapper;
import com.mcst.merchant.orm.plus.persistence.model.MerchantInfo;
import com.mcst.merchant.orm.repository.IMerchantInfoRepository;

/**
 * <p>
 * 商户信息 Repository实现类
 * </p>
 *
 * @author liu yijun
 * @since 2026-01-19
 */
public class MerchantInfoRepositoryImpl extends BaseMyBatisRepositoryImpl<MerchantInfoMapper, MerchantInfoDto, MerchantInfo, String> implements IMerchantInfoRepository {


}
