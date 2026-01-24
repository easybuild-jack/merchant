package com.mcst.merchant.controller;

import com.mcst.easyfk.core.builders.RRBuilder;
import com.mcst.easyfk.core.builders.SRPBuilder;
import com.mcst.easyfk.core.dto.request.SearchRequest;
import com.mcst.easyfk.core.dto.response.ResponseResult;
import com.mcst.easyfk.core.utils.common.EmptyUtil;
import com.mcst.merchant.api.IMerchantInfoApi;
import com.mcst.merchant.api.request.MerchantInfoReq;
import com.mcst.merchant.api.response.MerchantInfoResp;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 商户信息相关接口
 *
 * @author liu yijun
 * @since 2026-01-19
 */
@Tag(name = "商户信息相关接口", description = "商户信息相关接口")
@RestController
@RequestMapping("/api/businesses/merchant")
public class MerchantInfoController {
    @Resource
    private IMerchantInfoApi merchantInfoApi;


    @Operation(summary = "详情")
    @GetMapping("/detail")
    public ResponseResult<MerchantInfoResp> detail(String id) {
        return RRBuilder.buildSuccessBody(this.merchantInfoApi.queryById(id));
    }

    @Operation(summary = "分页查询", description = "分页查询")
    @GetMapping("/queryPage")
    public ResponseResult<List<MerchantInfoResp>> queryPage(@Validated MerchantInfoReq merchantInfoReq) {
        if (EmptyUtil.isEmpty(merchantInfoReq.getTotalCount())) {
            merchantInfoReq.setTotalCount(false);
        }
        SearchRequest<MerchantInfoReq> requestParam = SRPBuilder.buildRequest(merchantInfoReq);
        return RRBuilder.buildBodyByPageResult(this.merchantInfoApi.queryByPage(requestParam));
    }

    @Operation(summary = "下拉列表接口")
    @GetMapping("/selectList")
    public ResponseResult<List<MerchantInfoResp>> selectList(MerchantInfoReq merchantInfoReq) {
        SRPBuilder<MerchantInfoReq> requestParamBuilder =
                SRPBuilder.<MerchantInfoReq>builder().selectFields(MerchantInfoReq::getMerchantInfoId, MerchantInfoReq::getMerchantName).example(merchantInfoReq);
        if (EmptyUtil.isNotEmpty(merchantInfoReq.getMerchantName())) {
            requestParamBuilder.likeFields(MerchantInfoReq::getMerchantName);
            merchantInfoReq.setTop(20);
        }
        return RRBuilder.buildSuccessBody(this.merchantInfoApi.queryList(requestParamBuilder.build()));
    }

}
