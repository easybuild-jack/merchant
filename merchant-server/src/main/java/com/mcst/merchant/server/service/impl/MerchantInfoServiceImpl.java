package com.mcst.merchant.server.service.impl;

import com.mcst.easyfk.core.dto.page.PageResult;
import com.mcst.easyfk.core.dto.request.ModifyRequest;
import com.mcst.easyfk.core.dto.request.SearchRequest;
import com.mcst.easyfk.core.dto.response.BaseResult;
import com.mcst.easyfk.core.utils.common.TransformUtil;
import com.mcst.easyfk.repository.util.ConditionUtil;
import com.mcst.easyfk.service.util.ServiceUtil;
import com.mcst.merchant.api.dto.MerchantInfoDto;
import com.mcst.merchant.api.request.MerchantInfoReq;
import com.mcst.merchant.api.response.MerchantInfoResp;
import com.mcst.merchant.orm.repository.IMerchantInfoRepository;
import com.mcst.merchant.server.service.IMerchantInfoService;
import jakarta.annotation.Resource;

import java.util.List;

/**
 * <p>
 * 商户信息 服务实现类
 * </p>
 *
 * @author liu yijun
 * @since 2026-01-19
 */

public class MerchantInfoServiceImpl implements IMerchantInfoService {
    @Resource
    private IMerchantInfoRepository merchantInfoRepository;

    @Override
    public MerchantInfoResp queryById(String id, String... selectColumns) {
        return TransformUtil.transformObj(this.merchantInfoRepository.queryById(id, selectColumns), MerchantInfoResp.class);
    }

    @Override
    public MerchantInfoResp queryOneByField(String field, Object value, String... selectColumns) {
        return TransformUtil.transformObj(this.merchantInfoRepository.queryOneByField(field, value, selectColumns), MerchantInfoResp.class);
    }

    @Override
    public List<MerchantInfoResp> queryList(SearchRequest<MerchantInfoReq> param) {
        return TransformUtil.transformList(this.merchantInfoRepository.queryByCondition(ConditionUtil.conditionByRequest(param)), MerchantInfoResp.class);
    }

    @Override
    public MerchantInfoResp queryOne(SearchRequest<MerchantInfoReq> param) {
        return TransformUtil.transformObj(this.merchantInfoRepository.queryOneByCondition(ConditionUtil.conditionByRequest(param)), MerchantInfoResp.class);
    }

    @Override
    public long count(SearchRequest<MerchantInfoReq> param) {
        return this.merchantInfoRepository.countByCondition(ConditionUtil.conditionByRequest(param));
    }

    @Override
    public boolean exists(SearchRequest<MerchantInfoReq> param) {
        return this.merchantInfoRepository.exists(ConditionUtil.conditionByRequest(param));
    }

    @Override
    public PageResult<MerchantInfoResp> queryByPage(SearchRequest<MerchantInfoReq> param) {
        return TransformUtil.transformPageResult(this.merchantInfoRepository.queryByPage(ConditionUtil.conditionByRequest(param)), MerchantInfoResp.class);
    }

    @Override
    public BaseResult<?> save(ModifyRequest<MerchantInfoReq> param) {
        return ServiceUtil.save(param, merchantInfoRepository, MerchantInfoDto.class);
    }

    @Override
    public BaseResult<?> delete(ModifyRequest<MerchantInfoReq> param) {
        return ServiceUtil.delete(param, merchantInfoRepository, MerchantInfoDto.class);
    }

    @Override
    public String insertAndReturnId(MerchantInfoReq param) {
        return ServiceUtil.insertAndReturnId(param, merchantInfoRepository, MerchantInfoDto.class);
    }

}
