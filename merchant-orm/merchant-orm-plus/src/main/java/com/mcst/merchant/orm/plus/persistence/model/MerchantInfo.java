package com.mcst.merchant.orm.plus.persistence.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mcst.easyfk.core.annotation.ForbiddenField;
import com.mcst.easyfk.core.annotation.PrimaryKey;
import com.mcst.easyfk.repository.persistence.annotation.EntityColumn;
import com.mcst.easyfk.service.mybatisplus.persistence.BaseMyBatisPlusEntity;
import com.mcst.merchant.api.dto.MerchantInfoDto;
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
@TableName("merchant_info")
@AutoMapper(target = MerchantInfoDto.class)
public class MerchantInfo extends BaseMyBatisPlusEntity<MerchantInfo> {


    @PrimaryKey
    @TableId(type = IdType.ASSIGN_UUID)
    @EntityColumn(comment = "商户ID")
    private String merchantId;

    /**
     * 商户名称
     */
    @EntityColumn(comment = "商户名称")
    private String merchantName;

    /**
     * 商户代码
     */
    @EntityColumn(comment = "商户代码")
    private String merchantCode;

    /**
     * 商户logo
     */
    @EntityColumn(comment = "商户logo")
    private String logo;


    /**
     * 标题
     */
    @EntityColumn(comment = "标题")
    private String title;

    /**
     * 副标题
     */
    @EntityColumn(comment = "副标题")
    private String subTitle;

    /**
     * 省份
     */
    @EntityColumn(comment = "省份")
    private String province;

    /**
     * 城市
     */
    @EntityColumn(comment = "城市")
    private String city;

    /**
     * 区域
     */
    @EntityColumn(comment = "区域")
    private String area;

    /**
     * 具体地址
     */
    @EntityColumn(comment = "具体地址")
    private String address;

    /**
     * 详细地址信息（省市区+具体地址）
     */
    @EntityColumn(comment = "详细地址信息（省市区+具体地址）")
    private String addressInfo;

    /**
     * 联系人
     */
    @EntityColumn(comment = "联系人")
    private String linkMan;
    /**
     * 联系电话
     */
    @EntityColumn(comment = "联系电话")
    private String linkPhone;

    /**
     * 营业时间
     */
    @EntityColumn(comment = "营业时间")
    private String businessHours;

    /**
     * 经度
     */
    @EntityColumn(comment = "经度")
    private String longitude;

    /**
     * 纬度
     */
    @EntityColumn(comment = "纬度")
    private String latitude;

    /**
     * 禁用状态 0可用，1禁用
     */
    @EntityColumn(comment = "禁用状态 0可用，1禁用")
    @ForbiddenField(value = "forbiddenFlag")
    private Integer forbiddenFlag;

    /**
     * 代理商ID
     */
    @EntityColumn(comment = "代理商ID")
    private String agentId;

    /**
     * 代理商名称
     */
    @EntityColumn(comment = "代理商名称")
    private String agentName;
}
