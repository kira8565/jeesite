package com.thinkgem.jeesite.modules.wx.web.front;

import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.wx.entity.WxPublicmanager;
import com.thinkgem.jeesite.modules.wx.service.WxPublicmanagerService;
import com.thinkgem.jeesite.modules.wx.service.font.WxAuthService;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpMessageRouter;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutMessage;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by kira on 16/8/10.
 */
@Controller
@RequestMapping(value = "${frontPath}/wx/wxauth")
public class WXAuthController extends BaseController {

    Logger logger=Logger.getLogger(String.valueOf(WXAuthController.this));

    @Autowired
    WxAuthService wxAuthService;

    /**
     * 微信认证
     *
     * @param request
     * @param response
     * @param id
     * @throws IOException
     */
    @RequestMapping("index")
    public void index(HttpServletRequest request, HttpServletResponse response, String id) throws IOException {
        WxMpService wxMpService = wxAuthService.loadWxMpService(id);
        WxMpMessageRouter wxMpMessageRouter = new WxMpMessageRouter(wxMpService);

        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);

        String signature = request.getParameter("signature");
        String nonce = request.getParameter("nonce");
        String timestamp = request.getParameter("timestamp");
        if (!wxMpService.checkSignature(timestamp, nonce, signature)) {
            // 消息签名不正确，说明不是公众平台发过来的消息
            response.getWriter().println("非法请求");
            logger.info("非法请求");
            return;
        }
        String echostr = request.getParameter("echostr");
        if (StringUtils.isNotBlank(echostr)) {
            // 说明是一个仅仅用来验证的请求，回显echostr
            response.getWriter().println(echostr);
            logger.info("认证通过");
            return;
        }
        String encryptType = StringUtils.isBlank(request.getParameter("encrypt_type")) ? "raw"
                : request.getParameter("encrypt_type");

        if ("raw".equals(encryptType)) {
            // 明文传输的消息
            WxMpXmlMessage inMessage = WxMpXmlMessage.fromXml(request.getInputStream());
            WxMpXmlOutMessage outMessage = wxMpMessageRouter.route(inMessage);
            response.getWriter().write(outMessage.toXml());
            return;
        }

        response.getWriter().println("不可识别的加密类型");
        logger.info("不可识别的加密类型");
        return;
    }
}
