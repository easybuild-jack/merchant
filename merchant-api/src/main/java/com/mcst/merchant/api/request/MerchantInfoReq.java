package com.mcst.merchant.api.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import com.mcst.merchant.api.param.MerchantInfoParam;

/**
* <p>
* 商户信息数据请求对象
* </p>
*
* @author liu yijun
* @since 2026-01-19
*/
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Schema(description="商户信息数据请求对象")
@SuperBuilder
@NoArgsConstructor
public class MerchantInfoReq extends MerchantInfoParam {


}
