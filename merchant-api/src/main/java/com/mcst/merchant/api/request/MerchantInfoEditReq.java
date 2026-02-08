package com.mcst.merchant.api.request;

import com.mcst.merchant.api.dto.MerchantInfoDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

/**
 * <p>
 * 商户信息数据编辑对象
 * </p>
 *
 * @author liu yijun
 * @since 2026-01-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Schema(description = "商户信息数据编辑对象")
@SuperBuilder
@NoArgsConstructor
public class MerchantInfoEditReq extends MerchantInfoDto {


}
