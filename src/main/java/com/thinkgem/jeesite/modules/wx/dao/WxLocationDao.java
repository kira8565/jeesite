/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.wx.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.wx.entity.WxLocation;

/**
 * 微信送货地址DAO接口
 * @author 吴文豪
 * @version 2016-08-12
 */
@MyBatisDao
public interface WxLocationDao extends CrudDao<WxLocation> {
	
}