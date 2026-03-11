package com.mcst.merchant.orm.hibernate.persistence.model;

import com.mcst.easyfk.core.annotation.ForbiddenField;
import com.mcst.easyfk.core.annotation.PrimaryKey;
import com.mcst.easyfk.service.hibernate.persistence.BaseHibernateEntity;
import com.mcst.merchant.api.dto.MerchantInfoDto;
import io.github.linpeilie.annotations.AutoMapper;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.annotations.UuidGenerator;

/**
 * 作者: liu yijun
 * 日期: 2026-01-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Entity
@Table(name = "merchant_info")
@AutoMapper(target = MerchantInfoDto.class)
public class MerchantInfo extends BaseHibernateEntity {

    /**
     * 商户ID
     */
    @PrimaryKey
    @Id
    @UuidGenerator
    @Column(name = "merchant_id")
    private String merchantId;

    /**
     * 商户名称
     */
    @Column(name = "merchant_name")
    private String merchantName;

    /**
     * 商户代码
     */
    @Column(name = "merchant_code")
    private String merchantCode;

    /**
     * 商户logo
     */
    @Column(name = "logo")
    private String logo;

    /**
     * 标题
     */
    @Column(name = "title")
    private String title;

    /**
     * 副标题
     */
    @Column(name = "sub_title")
    private String subTitle;

    /**
     * 省份
     */
    @Column(name = "province")
    private String province;

    /**
     * 城市
     */
    @Column(name = "city")
    private String city;

    /**
     * 区域
     */
    @Column(name = "area")
    private String area;

    /**
     * 具体地址
     */
    @Column(name = "address")
    private String address;

    /**
     * 详细地址信息（省市区+具体地址）
     */
    @Column(name = "address_info")
    private String addressInfo;

    /**
     * 联系人
     */
    @Column(name = "link_man")
    private String linkMan;

    /**
     * 联系电话
     */
    @Column(name = "link_phone")
    private String linkPhone;

    /**
     * 营业时间
     */
    @Column(name = "business_hours")
    private String businessHours;

    /**
     * 经度
     */
    @Column(name = "longitude")
    private String longitude;

    /**
     * 纬度
     */
    @Column(name = "latitude")
    private String latitude;

    /**
     * 禁用状态 0可用，1禁用
     */
    @ForbiddenField(value = "forbiddenFlag")
    @Column(name = "forbidden_flag")
    private Integer forbiddenFlag;

    /**
     * 代理商ID
     */
    @Column(name = "agent_id")
    private String agentId;

    /**
     * 代理商名称
     */
    @Column(name = "agent_name")
    private String agentName;
}
