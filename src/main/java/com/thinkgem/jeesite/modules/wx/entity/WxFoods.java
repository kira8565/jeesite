/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.wx.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 微信菜式管理Entity
 * @author 吴文豪
 * @version 2016-08-13
 */
public class WxFoods extends DataEntity<WxFoods> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 菜式名称
	private String pic;		// 菜式图片
	
	public WxFoods() {
		super();
	}

	public WxFoods(String id){
		super(id);
	}

	@Length(min=0, max=255, message="菜式名称长度必须介于 0 和 255 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=4000, message="菜式图片长度必须介于 0 和 4000 之间")
	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}
	
}