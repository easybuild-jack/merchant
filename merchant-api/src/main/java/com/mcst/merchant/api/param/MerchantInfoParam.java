package com.mcst.merchant.api.param;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import com.mcst.easyfk.core.dto.request.BasicParam;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
* <p>
* 商户信息数据参数对象
* </p>
*
* @author liu yijun
* @since 2026-01-20
*/
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Schema(description="商户信息数据参数对象")
@SuperBuilder
@NoArgsConstructor
public class MerchantInfoParam extends BasicParam {



    /**
    * 商户信息ID
    */
    @Schema(description= "商户信息ID")
    private String merchantInfoId;

    /**
    * 门店名称
    */
    @Schema(description= "门店名称")
    private String merchantName;

    /**
    * 门店代码
    */
    @Schema(description= "门店代码")
    private String merchantCode;

    /**
    * 门店logo
    */
    @Schema(description= "门店logo")
    private String logo;

    /**
    * 省份
    */
    @Schema(description= "省份")
    private String province;

    /**
    * 城市
    */
    @Schema(description= "城市")
    private String city;

    /**
    * 区域
    */
    @Schema(description= "区域")
    private String area;

    /**
    * 具体地址
    */
    @Schema(description= "具体地址")
    private String address;

    /**
    * 详细地址信息（省市区+具体地址）
    */
    @Schema(description= "详细地址信息（省市区+具体地址）")
    private String addressInfo;

    /**
    * 联系人
    */
    @Schema(description= "联系人")
    private String linkMan;

    /**
    * 联系电话
    */
    @Schema(description= "联系电话")
    private String linkPhone;

    /**
    * 营业时间
    */
    @Schema(description= "营业时间")
    private String businessHours;

    /**
    * 经度
    */
    @Schema(description= "经度")
    private String longitude;

    /**
    * 纬度
    */
    @Schema(description= "纬度")
    private String latitude;

    /**
    * 禁用状态 0可用，1禁用
    */
    @Schema(description= "禁用状态 0可用，1禁用")
    private Integer forbiddenFlag;

    /**
    * 代理商ID
    */
    @Schema(description= "代理商ID")
    private String agentId;

    /**
    * 代理商名称
    */
    @Schema(description= "代理商名称")
    private String agentName;



















}
