/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.wx.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.wx.entity.WxLocation;
import com.thinkgem.jeesite.modules.wx.dao.WxLocationDao;

/**
 * 微信送货地址Service
 * @author 吴文豪
 * @version 2016-08-12
 */
@Service
@Transactional(readOnly = true)
public class WxLocationService extends CrudService<WxLocationDao, WxLocation> {

	public WxLocation get(String id) {
		return super.get(id);
	}
	
	public List<WxLocation> findList(WxLocation wxLocation) {
		return super.findList(wxLocation);
	}
	
	public Page<WxLocation> findPage(Page<WxLocation> page, WxLocation wxLocation) {
		return super.findPage(page, wxLocation);
	}
	
	@Transactional(readOnly = false)
	public void save(WxLocation wxLocation) {
		super.save(wxLocation);
	}
	
	@Transactional(readOnly = false)
	public void delete(WxLocation wxLocation) {
		super.delete(wxLocation);
	}
	
}