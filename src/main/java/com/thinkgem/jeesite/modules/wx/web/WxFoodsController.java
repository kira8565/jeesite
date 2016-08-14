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
import com.thinkgem.jeesite.modules.wx.entity.WxFoods;
import com.thinkgem.jeesite.modules.wx.service.WxFoodsService;

/**
 * 微信菜式管理Controller
 * @author 吴文豪
 * @version 2016-08-13
 */
@Controller
@RequestMapping(value = "${adminPath}/wx/wxFoods")
public class WxFoodsController extends BaseController {

	@Autowired
	private WxFoodsService wxFoodsService;
	
	@ModelAttribute
	public WxFoods get(@RequestParam(required=false) String id) {
		WxFoods entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = wxFoodsService.get(id);
		}
		if (entity == null){
			entity = new WxFoods();
		}
		return entity;
	}
	
	@RequiresPermissions("wx:wxFoods:view")
	@RequestMapping(value = {"list", ""})
	public String list(WxFoods wxFoods, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<WxFoods> page = wxFoodsService.findPage(new Page<WxFoods>(request, response), wxFoods); 
		model.addAttribute("page", page);
		return "modules/wx/wxFoodsList";
	}

	@RequiresPermissions("wx:wxFoods:view")
	@RequestMapping(value = "form")
	public String form(WxFoods wxFoods, Model model) {
		model.addAttribute("wxFoods", wxFoods);
		return "modules/wx/wxFoodsForm";
	}

	@RequiresPermissions("wx:wxFoods:edit")
	@RequestMapping(value = "save")
	public String save(WxFoods wxFoods, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, wxFoods)){
			return form(wxFoods, model);
		}
		wxFoodsService.save(wxFoods);
		addMessage(redirectAttributes, "保存菜式成功");
		return "redirect:"+Global.getAdminPath()+"/wx/wxFoods/?repage";
	}
	
	@RequiresPermissions("wx:wxFoods:edit")
	@RequestMapping(value = "delete")
	public String delete(WxFoods wxFoods, RedirectAttributes redirectAttributes) {
		wxFoodsService.delete(wxFoods);
		addMessage(redirectAttributes, "删除菜式成功");
		return "redirect:"+Global.getAdminPath()+"/wx/wxFoods/?repage";
	}

}