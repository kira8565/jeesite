package com.thinkgem.jeesite.modules.wx.service.font;

import com.thinkgem.jeesite.modules.wx.entity.WxPublicmanager;
import com.thinkgem.jeesite.modules.wx.service.WxPublicmanagerService;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by kira on 16/8/10.
 */
@Service
@Transactional(readOnly = true)
public class WxAuthService {
    @Autowired
    WxPublicmanagerService wxPublicmanagerService;

    public WxMpService loadWxMpService(String id) {
        WxPublicmanager entity = wxPublicmanagerService.get(id);

        WxMpInMemoryConfigStorage config = new WxMpInMemoryConfigStorage();
        config.setAppId(entity.getAppid());
        config.setSecret(entity.getAppsecret());
        config.setToken(entity.getToken());
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(config);
        return wxMpService;
    }
}
