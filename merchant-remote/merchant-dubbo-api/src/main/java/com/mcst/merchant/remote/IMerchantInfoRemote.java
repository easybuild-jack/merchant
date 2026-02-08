package com.mcst.merchant.remote;

import com.mcst.easyfk.remote.dubbo.IDubboBaseRemote;
import com.mcst.merchant.api.request.MerchantInfoReq;
import com.mcst.merchant.api.response.MerchantInfoResp;

/**
 * <p>
 * 商户信息 Remote接口类
 * </p>
 *
 * @author liu yijun
 * @since 2026-01-19
 */
public interface IMerchantInfoRemote extends IDubboBaseRemote<MerchantInfoResp, String, MerchantInfoReq> {


}