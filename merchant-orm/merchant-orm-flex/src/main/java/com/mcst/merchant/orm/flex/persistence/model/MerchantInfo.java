package com.mcst.merchant.orm.flex.persistence.model;

import com.mcst.easyfk.core.annotation.ForbiddenField;
import com.mcst.easyfk.core.annotation.PrimaryKey;
import com.mcst.easyfk.service.flex.persistence.BaseFlexEntity;
import com.mcst.merchant.api.dto.MerchantInfoDto;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 作者: liu yijun
 * 日期: 2026-01-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Table("merchant_info")
@AutoMapper(target = MerchantInfoDto.class)
public class MerchantInfo extends BaseFlexEntity<MerchantInfo> {

    /**
     * 商户ID
     */
    @PrimaryKey
    @Id(keyType = KeyType.Generator, value = "uuid")
    private String merchantId;

    /**
     * 商户名称
     */
    private String merchantName;

    /**
     * 商户代码
     */
    private String merchantCode;

    /**
     * 商户logo
     */
    private String logo;

    /**
     * 标题
     */
    private String title;

    /**
     * 副标题
     */
    private String subTitle;

    /**
     * 省份
     */
    private String province;

    /**
     * 城市
     */
    private String city;

    /**
     * 区域
     */
    private String area;

    /**
     * 具体地址
     */
    private String address;

    /**
     * 详细地址信息（省市区+具体地址）
     */
    private String addressInfo;

    /**
     * 联系人
     */
    private String linkMan;

    /**
     * 联系电话
     */
    private String linkPhone;

    /**
     * 营业时间
     */
    private String businessHours;

    /**
     * 经度
     */
    private String longitude;

    /**
     * 纬度
     */
    private String latitude;

    /**
     * 禁用状态 0可用，1禁用
     */
    @ForbiddenField(value = "forbiddenFlag")
    private Integer forbiddenFlag;

    /**
     * 代理商ID
     */
    private String agentId;

    /**
     * 代理商名称
     */
    private String agentName;
}
