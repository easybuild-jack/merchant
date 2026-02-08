package com.mcst.merchant.server.repository.impl;

import com.mcst.easyfk.service.mybatisplus.impl.BaseMyBatisRepositoryImpl;
import com.mcst.merchant.api.dto.MerchantInfoDto;
import com.mcst.merchant.server.persistence.mapper.MerchantInfoMapper;
import com.mcst.merchant.server.persistence.model.MerchantInfo;
import com.mcst.merchant.server.repository.IMerchantInfoRepository;

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