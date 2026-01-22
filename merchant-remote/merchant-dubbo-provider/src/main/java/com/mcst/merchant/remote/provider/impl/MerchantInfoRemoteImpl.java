package com.mcst.merchant.remote.provider.impl;

import com.mcst.merchant.api.response.MerchantInfoResp;
import com.mcst.merchant.api.request.MerchantInfoReq;
import com.mcst.merchant.server.service.IMerchantInfoService;
import com.mcst.merchant.remote.IMerchantInfoRemote;
import com.mcst.easyfk.remote.dubbo.DubboBaseRemoteImpl;
import org.apache.dubbo.config.annotation.DubboService;

/**
* <p>
* 商户信息 RemoteImpl
* </p>
*
* @author liu yijun
*/
@DubboService
public class MerchantInfoRemoteImpl extends DubboBaseRemoteImpl<IMerchantInfoService, MerchantInfoResp,String,MerchantInfoReq> implements IMerchantInfoRemote {


}
