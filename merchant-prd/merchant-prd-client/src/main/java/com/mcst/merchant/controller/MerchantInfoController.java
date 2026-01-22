package com.mcst.merchant.controller;

import com.mcst.merchant.api.response.MerchantInfoResp;
import com.mcst.merchant.api.request.MerchantInfoReq;
import com.mcst.merchant.api.request.MerchantInfoEditReq;
import com.mcst.merchant.api.IMerchantInfoApi;
import com.mcst.easyfk.core.dto.request.ModifyRequest;
import com.mcst.easyfk.core.builders.MRPBuilder;
import com.mcst.easyfk.core.dto.request.SearchRequest;
import com.mcst.easyfk.core.builders.SRPBuilder;
import com.mcst.easyfk.core.dto.response.ResponseResult;
import com.mcst.easyfk.core.builders.RRBuilder;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.mcst.easyfk.core.dto.request.BatchBasicReq;
import com.mcst.easyfk.core.utils.common.SplitUtil;
import jakarta.annotation.Resource;
import java.util.List;

/**
* 商户信息相关接口
* @author liu yijun
* @since 2026-01-19
*/
@Tag(name = "商户信息相关接口", description = "商户信息相关接口")
@RestController
@RequestMapping("/api/merchant/merchantInfo")
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
        SearchRequest<MerchantInfoReq> requestParam = SRPBuilder.buildRequest(merchantInfoReq);
        return RRBuilder.buildBodyByPageResult(this.merchantInfoApi.queryByPage(requestParam));
    }

    @Operation(summary = "新增/编辑", description = "新增/编辑")
    @PostMapping("/addOrEdit")
    public ResponseResult<?> addOrEdit(@RequestBody MerchantInfoEditReq merchantInfoEditReq) {
        ModifyRequest<MerchantInfoReq> requestParam = MRPBuilder.buildRequest(merchantInfoEditReq,MerchantInfoReq.class);
        return RRBuilder.buildBodyByBaseResult(this.merchantInfoApi.save(requestParam));
    }

    @Operation(summary = "批量删除", description = "批量删除")
    @PostMapping("/delete")
    public ResponseResult<?> delete(@Validated @RequestBody BatchBasicReq<String> batchBase) {
        List<String> idArray = SplitUtil.split(batchBase.getIds());
        ModifyRequest<MerchantInfoReq> requestParam = MRPBuilder.<MerchantInfoReq>builder().ids(idArray).build();
        return RRBuilder.buildBodyByBaseResult(this.merchantInfoApi.delete(requestParam));
    }

}
