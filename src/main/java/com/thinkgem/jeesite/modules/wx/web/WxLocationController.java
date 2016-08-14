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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.wx.entity.WxLocation;
import com.thinkgem.jeesite.modules.wx.service.WxLocationService;

/**
 * 微信送货地址Controller
 * @author 吴文豪
 * @version 2016-08-12
 */
@Controller
@RequestMapping(value = "${adminPath}/wx/wxLocation")
public class WxLocationController extends BaseController {

	@Autowired
	private WxLocationService wxLocationService;
	
	@ModelAttribute
	public WxLocation get(@RequestParam(required=false) String id) {
		WxLocation entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = wxLocationService.get(id);
		}
		if (entity == null){
			entity = new WxLocation();
		}
		return entity;
	}
	
	@RequiresPermissions("wx:wxLocation:view")
	@RequestMapping(value = {"list", ""})
	public String list(WxLocation wxLocation, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<WxLocation> page = wxLocationService.findPage(new Page<WxLocation>(request, response), wxLocation); 
		model.addAttribute("page", page);
		return "modules/wx/wxLocationList";
	}

	@RequiresPermissions("wx:wxLocation:view")
	@RequestMapping(value = "form")
	public String form(WxLocation wxLocation, Model model) {
		model.addAttribute("wxLocation", wxLocation);
		return "modules/wx/wxLocationForm";
	}

	@RequiresPermissions("wx:wxLocation:edit")
	@RequestMapping(value = "save")
	public String save(WxLocation wxLocation, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, wxLocation)){
			return form(wxLocation, model);
		}
		wxLocationService.save(wxLocation);
		addMessage(redirectAttributes, "保存送货地址成功");
		return "redirect:"+Global.getAdminPath()+"/wx/wxLocation/?repage";
	}
	
	@RequiresPermissions("wx:wxLocation:edit")
	@RequestMapping(value = "delete")
	public String delete(WxLocation wxLocation, RedirectAttributes redirectAttributes) {
		wxLocationService.delete(wxLocation);
		addMessage(redirectAttributes, "删除送货地址成功");
		return "redirect:"+Global.getAdminPath()+"/wx/wxLocation/?repage";
	}

}