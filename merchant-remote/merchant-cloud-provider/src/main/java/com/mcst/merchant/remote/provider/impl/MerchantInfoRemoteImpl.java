package com.mcst.merchant.remote.provider.impl;

import com.mcst.merchant.api.response.MerchantInfoResp;
import com.mcst.merchant.api.request.MerchantInfoReq;
import com.mcst.merchant.server.service.IMerchantInfoService;
import com.mcst.merchant.remote.IMerchantInfoRemote;
import com.mcst.easyfk.remote.sc.BaseRemoteImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* <p>
* 商户信息 RemoteImpl
* </p>
*
* @author liu yijun
*/
@RestController
@RequestMapping("${easyfk.config.remote.merchant.base-path:/remote}/businesses/merchant")
public class MerchantInfoRemoteImpl extends BaseRemoteImpl<IMerchantInfoService, MerchantInfoResp,String,MerchantInfoReq> implements IMerchantInfoRemote {


}
