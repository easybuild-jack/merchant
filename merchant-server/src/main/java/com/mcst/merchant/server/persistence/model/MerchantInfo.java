package com.mcst.merchant.server.persistence.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mcst.easyfk.core.annotation.ForbiddenField;
import com.mcst.easyfk.core.annotation.PrimaryKey;
import com.mcst.easyfk.service.mybatisplus.annotation.Column;
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
    @Column(comment = "商户ID")
    private String merchantId;

    /**
     * 商户名称
     */
    @Column(comment = "商户名称")
    private String merchantName;

    /**
     * 商户代码
     */
    @Column(comment = "商户代码")
    private String merchantCode;

    /**
     * 商户logo
     */
    @Column(comment = "商户logo")
    private String logo;

    /**
     * 省份
     */
    @Column(comment = "省份")
    private String province;

    /**
     * 城市
     */
    @Column(comment = "城市")
    private String city;

    /**
     * 区域
     */
    @Column(comment = "区域")
    private String area;

    /**
     * 具体地址
     */
    @Column(comment = "具体地址")
    private String address;

    /**
     * 详细地址信息（省市区+具体地址）
     */
    @Column(comment = "详细地址信息（省市区+具体地址）")
    private String addressInfo;

    /**
     * 联系人
     */
    @Column(comment = "联系人")
    private String linkMan;
    /**
     * 联系电话
     */
    @Column(comment = "联系电话")
    private String linkPhone;

    /**
     * 营业时间
     */
    @Column(comment = "营业时间")
    private String businessHours;

    /**
     * 经度
     */
    @Column(comment = "经度")
    private String longitude;

    /**
     * 纬度
     */
    @Column(comment = "纬度")
    private String latitude;

    /**
     * 禁用状态 0可用，1禁用
     */
    @Column(comment = "禁用状态 0可用，1禁用")
    @ForbiddenField(value = "forbiddenFlag")
    private Integer forbiddenFlag;

    /**
     * 代理商ID
     */
    @Column(comment = "代理商ID")
    private String agentId;

    /**
     * 代理商名称
     */
    @Column(comment = "代理商名称")
    private String agentName;
}