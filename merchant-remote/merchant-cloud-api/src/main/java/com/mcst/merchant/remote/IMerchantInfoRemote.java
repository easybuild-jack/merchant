package com.mcst.merchant.remote;

import com.mcst.merchant.api.response.MerchantInfoResp;
import com.mcst.merchant.api.request.MerchantInfoReq;
import com.mcst.easyfk.remote.sc.IBaseRemote;
import org.springframework.cloud.openfeign.FeignClient;

/**
* <p>
* 商户信息 Remote接口类
* </p>
*
* @author liu yijun
* @since 2026-01-19
*/
@FeignClient(value = "${easyfk.config.remote.merchant.service-id:merchant-server}", path = "${easyfk.config.remote.merchant.base-path:/remote}/merchant/merchantInfo")
public interface IMerchantInfoRemote extends IBaseRemote<MerchantInfoResp,String,MerchantInfoReq>{


}