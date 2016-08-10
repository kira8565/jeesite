/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.wx.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.wx.entity.WxPublicmanager;
import com.thinkgem.jeesite.modules.wx.dao.WxPublicmanagerDao;

/**
 * 微信公众号管理Service
 * @author 吴文豪
 * @version 2016-08-10
 */
@Service
@Transactional(readOnly = true)
public class WxPublicmanagerService extends CrudService<WxPublicmanagerDao, WxPublicmanager> {

	public WxPublicmanager get(String id) {
		return super.get(id);
	}
	
	public List<WxPublicmanager> findList(WxPublicmanager wxPublicmanager) {
		return super.findList(wxPublicmanager);
	}
	
	public Page<WxPublicmanager> findPage(Page<WxPublicmanager> page, WxPublicmanager wxPublicmanager) {
		return super.findPage(page, wxPublicmanager);
	}
	
	@Transactional(readOnly = false)
	public void save(WxPublicmanager wxPublicmanager) {
		super.save(wxPublicmanager);
	}
	
	@Transactional(readOnly = false)
	public void delete(WxPublicmanager wxPublicmanager) {
		super.delete(wxPublicmanager);
	}
	
}