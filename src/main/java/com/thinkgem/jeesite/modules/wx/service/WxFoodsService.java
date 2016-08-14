/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.wx.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.wx.entity.WxFoods;
import com.thinkgem.jeesite.modules.wx.dao.WxFoodsDao;

/**
 * 微信菜式管理Service
 * @author 吴文豪
 * @version 2016-08-13
 */
@Service
@Transactional(readOnly = true)
public class WxFoodsService extends CrudService<WxFoodsDao, WxFoods> {

	public WxFoods get(String id) {
		return super.get(id);
	}
	
	public List<WxFoods> findList(WxFoods wxFoods) {
		return super.findList(wxFoods);
	}
	
	public Page<WxFoods> findPage(Page<WxFoods> page, WxFoods wxFoods) {
		return super.findPage(page, wxFoods);
	}
	
	@Transactional(readOnly = false)
	public void save(WxFoods wxFoods) {
		super.save(wxFoods);
	}
	
	@Transactional(readOnly = false)
	public void delete(WxFoods wxFoods) {
		super.delete(wxFoods);
	}
	
}