package com.mcst.merchant.controller;

import com.mcst.easyfk.authority.annotation.AuthResource;
import com.mcst.easyfk.authority.annotation.ResourceController;
import com.mcst.easyfk.authority.enums.ResourceCategory;
import com.mcst.easyfk.core.builders.MRPBuilder;
import com.mcst.easyfk.core.builders.RRBuilder;
import com.mcst.easyfk.core.builders.SRPBuilder;
import com.mcst.easyfk.core.dto.request.BatchBasicReq;
import com.mcst.easyfk.core.dto.request.DisableActionParam;
import com.mcst.easyfk.core.dto.request.DisableFieldReq;
import com.mcst.easyfk.core.dto.request.ModifyRequest;
import com.mcst.easyfk.core.dto.response.ResponseResult;
import com.mcst.easyfk.core.utils.common.DisableUtil;
import com.mcst.easyfk.core.utils.common.EmptyUtil;
import com.mcst.easyfk.core.utils.common.SplitUtil;
import com.mcst.merchant.api.IMerchantInfoApi;
import com.mcst.merchant.api.request.MerchantInfoEditReq;
import com.mcst.merchant.api.request.MerchantInfoReq;
import com.mcst.merchant.api.response.MerchantInfoResp;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 商户信息相关接口
 *
 * @author liu yijun
 * @since 2026-01-19
 */
@Tag(name = "商户信息相关接口", description = "商户信息相关接口")
@RestController
@RequestMapping("/api/bms/businesses/merchant")
@ResourceController(group = "businessesManage", id = "businessesManage", name = "商超管理", sort = 71000, path = "businesses")
public class MerchantInfoBmsController {
    @Resource
    private IMerchantInfoApi merchantInfoApi;

    @Operation(summary = "详情")
    @GetMapping("/detail")
    public ResponseResult<MerchantInfoResp> detail(String id) {
        return RRBuilder.buildSuccessBody(this.merchantInfoApi.queryById(id));
    }

    @Operation(summary = "分页查询", description = "分页查询")
    @GetMapping("/queryPage")
    @AuthResource(id = "merchantManage", name = "商户管理", pId = "businessesManage", pName = "商超管理", sort = 71200, path = "businesses/merchant",
            category = ResourceCategory.menu)
    public ResponseResult<List<MerchantInfoResp>> queryPage(@Validated MerchantInfoReq merchantInfoReq) {
        SRPBuilder<MerchantInfoReq> builder = SRPBuilder.<MerchantInfoReq>builder().example(merchantInfoReq);
        return RRBuilder.buildBodyByPageResult(this.merchantInfoApi.queryByPage(builder.build()));
    }

    @Operation(summary = "新增/编辑", description = "新增/编辑")
    @PostMapping("/addOrEdit")
    @AuthResource(id = "merchantAddOrEdit", name = "新增/编辑", title = "新增/编辑", pId = "merchantManage", pName = "商户管理", sort = 71201, category = ResourceCategory.action,
            actionCode = "addOrEdit")
    public ResponseResult<?> addOrEdit(@RequestBody MerchantInfoEditReq merchantInfoEditReq) {
        ModifyRequest<MerchantInfoReq> requestParam = MRPBuilder.buildRequest(merchantInfoEditReq, MerchantInfoReq.class);
        return RRBuilder.buildBodyByBaseResult(this.merchantInfoApi.save(requestParam));
    }

    @Operation(summary = "批量删除", description = "批量删除")
    @PostMapping("/delete")
    @AuthResource(id = "merchantDelete", name = "删除", title = "删除", pId = "merchantManage", pName = "商户管理", sort = 71202, category = ResourceCategory.action,
            actionCode = "delete")
    public ResponseResult<?> delete(@Validated @RequestBody BatchBasicReq<String> batchBase) {
        List<String> idArray = SplitUtil.split(batchBase.getIds());
        ModifyRequest<MerchantInfoReq> requestParam = MRPBuilder.<MerchantInfoReq>builder().ids(idArray).build();
        return RRBuilder.buildBodyByBaseResult(this.merchantInfoApi.delete(requestParam));
    }


    @Operation(summary = "启用/禁用")
    @PostMapping("/disable")
    @AuthResource(id = "merchantDisable", name = "启用/禁用", title = "启用/禁用", pId = "merchantManage", pName = "商户管理", sort = 71203, category = ResourceCategory.action,
            actionCode = "disable")
    public ResponseResult<?> disable(@RequestBody @Validated DisableFieldReq disableFieldVO) {
        DisableActionParam<MerchantInfoReq> disableActionParam =
                new DisableActionParam<MerchantInfoReq>(disableFieldVO).setIdField(MerchantInfoReq::getMerchantInfoId).setValueField(MerchantInfoReq::getForbiddenFlag).setTClass(MerchantInfoReq.class);
        List<MerchantInfoReq> list = DisableUtil.createObjListByDisableAction(disableActionParam);
        if (EmptyUtil.isEmpty(list)) {
            return RRBuilder.buildFailedBody("参数错误");
        }
        ModifyRequest<MerchantInfoReq> requestParam = MRPBuilder.<MerchantInfoReq>builder().paramList(list).build();
        return RRBuilder.buildBodyByBaseResult(this.merchantInfoApi.save(requestParam));
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
