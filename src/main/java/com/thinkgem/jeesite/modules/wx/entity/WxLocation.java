/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.wx.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 微信送货地址Entity
 * @author 吴文豪
 * @version 2016-08-12
 */
public class WxLocation extends DataEntity<WxLocation> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 地址名称
	private String isenable;		// 是否启用
	
	public WxLocation() {
		super();
	}

	public WxLocation(String id){
		super(id);
	}

	@Length(min=1, max=255, message="地址名称长度必须介于 1 和 255 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=1, max=255, message="是否启用长度必须介于 1 和 255 之间")
	public String getIsenable() {
		return isenable;
	}

	public void setIsenable(String isenable) {
		this.isenable = isenable;
	}
	
}