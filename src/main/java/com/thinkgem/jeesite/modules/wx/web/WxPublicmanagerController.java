/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.wx.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.wx.entity.WxPublicmanager;
import com.thinkgem.jeesite.modules.wx.service.WxPublicmanagerService;

/**
 * 微信公众号管理Controller
 * @author 吴文豪
 * @version 2016-08-10
 */
@Controller
@RequestMapping(value = "${adminPath}/wx/wxPublicmanager")
public class WxPublicmanagerController extends BaseController {

	@Autowired
	private WxPublicmanagerService wxPublicmanagerService;
	
	@ModelAttribute
	public WxPublicmanager get(@RequestParam(required=false) String id) {
		WxPublicmanager entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = wxPublicmanagerService.get(id);
		}
		if (entity == null){
			entity = new WxPublicmanager();
		}
		return entity;
	}
	
	@RequiresPermissions("wx:wxPublicmanager:view")
	@RequestMapping(value = {"list", ""})
	public String list(WxPublicmanager wxPublicmanager, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<WxPublicmanager> page = wxPublicmanagerService.findPage(new Page<WxPublicmanager>(request, response), wxPublicmanager); 
		model.addAttribute("page", page);
		return "modules/wx/wxPublicmanagerList";
	}

	@RequiresPermissions("wx:wxPublicmanager:view")
	@RequestMapping(value = "form")
	public String form(WxPublicmanager wxPublicmanager, Model model) {
		model.addAttribute("wxPublicmanager", wxPublicmanager);
		return "modules/wx/wxPublicmanagerForm";
	}

	@RequiresPermissions("wx:wxPublicmanager:edit")
	@RequestMapping(value = "save")
	public String save(WxPublicmanager wxPublicmanager, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, wxPublicmanager)){
			return form(wxPublicmanager, model);
		}
		wxPublicmanagerService.save(wxPublicmanager);
		addMessage(redirectAttributes, "保存微信公众号成功");
		return "redirect:"+Global.getAdminPath()+"/wx/wxPublicmanager/?repage";
	}
	
	@RequiresPermissions("wx:wxPublicmanager:edit")
	@RequestMapping(value = "delete")
	public String delete(WxPublicmanager wxPublicmanager, RedirectAttributes redirectAttributes) {
		wxPublicmanagerService.delete(wxPublicmanager);
		addMessage(redirectAttributes, "删除微信公众号成功");
		return "redirect:"+Global.getAdminPath()+"/wx/wxPublicmanager/?repage";
	}

}