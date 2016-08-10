/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.wx.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.wx.entity.WxPublicmanager;

/**
 * 微信公众号管理DAO接口
 * @author 吴文豪
 * @version 2016-08-10
 */
@MyBatisDao
public interface WxPublicmanagerDao extends CrudDao<WxPublicmanager> {
	
}