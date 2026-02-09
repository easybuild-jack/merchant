package com.mcst.merchant.remote.provider.impl;

import com.mcst.easyfk.remote.dubbo.DubboBaseRemoteImpl;
import com.mcst.merchant.api.request.MerchantInfoReq;
import com.mcst.merchant.api.response.MerchantInfoResp;
import com.mcst.merchant.remote.IMerchantInfoRemote;
import com.mcst.merchant.server.service.IMerchantInfoService;

/**
 * <p>
 * 商户信息 RemoteImpl
 * </p>
 *
 * @author liu yijun
 */
public class MerchantInfoRemoteImpl extends DubboBaseRemoteImpl<IMerchantInfoService, MerchantInfoResp, String, MerchantInfoReq> implements IMerchantInfoRemote {


}
