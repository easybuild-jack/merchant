package com.mcst.merchant.remote.impl;

import com.mcst.merchant.api.response.MerchantInfoResp;
import com.mcst.merchant.api.request.MerchantInfoReq;
import com.mcst.merchant.api.IMerchantInfoApi;
import com.mcst.easyfk.remote.dubbo.DubboBaseApiRemoteImpl;
import com.mcst.merchant.remote.IMerchantInfoRemote;
import jakarta.annotation.Resource;
/**
* <p>
* 商户信息 Api接口Dubbo层实现
* </p>
*
* @author liu yijun
* @since 2026-01-19
*/
public class MerchantInfoApiDubboImpl extends DubboBaseApiRemoteImpl<IMerchantInfoRemote, MerchantInfoResp,String,MerchantInfoReq> implements IMerchantInfoApi {

}
