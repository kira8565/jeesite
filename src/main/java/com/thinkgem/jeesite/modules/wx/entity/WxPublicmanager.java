/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.wx.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 微信公众号管理Entity
 * @author 吴文豪
 * @version 2016-08-10
 */
public class WxPublicmanager extends DataEntity<WxPublicmanager> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 名称
	private String wxname;		// 微信号
	private String rawid;		// 原始ID
	private String appid;		// APPID
	private String appsecret;		// 应用密钥
	private String token;		// Token
	private String aesKey;		// AESKey
	private String wxtypes;		// 公众号类别
	private String wxEncodeWay;		// 消息加密方式
	
	public WxPublicmanager() {
		super();
	}

	public WxPublicmanager(String id){
		super(id);
	}

	@Length(min=0, max=100, message="名称长度必须介于 0 和 100 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=45, message="微信号长度必须介于 0 和 45 之间")
	public String getWxname() {
		return wxname;
	}

	public void setWxname(String wxname) {
		this.wxname = wxname;
	}
	
	@Length(min=0, max=45, message="原始ID长度必须介于 0 和 45 之间")
	public String getRawid() {
		return rawid;
	}

	public void setRawid(String rawid) {
		this.rawid = rawid;
	}
	
	@Length(min=0, max=45, message="APPID长度必须介于 0 和 45 之间")
	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}
	
	@Length(min=0, max=255, message="应用密钥长度必须介于 0 和 255 之间")
	public String getAppsecret() {
		return appsecret;
	}

	public void setAppsecret(String appsecret) {
		this.appsecret = appsecret;
	}
	
	@Length(min=0, max=45, message="Token长度必须介于 0 和 45 之间")
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	@Length(min=0, max=255, message="AESKey长度必须介于 0 和 255 之间")
	public String getAesKey() {
		return aesKey;
	}

	public void setAesKey(String aesKey) {
		this.aesKey = aesKey;
	}
	
	@Length(min=0, max=1, message="公众号类别长度必须介于 0 和 1 之间")
	public String getWxtypes() {
		return wxtypes;
	}

	public void setWxtypes(String wxtypes) {
		this.wxtypes = wxtypes;
	}
	
	@Length(min=0, max=1, message="消息加密方式长度必须介于 0 和 1 之间")
	public String getWxEncodeWay() {
		return wxEncodeWay;
	}

	public void setWxEncodeWay(String wxEncodeWay) {
		this.wxEncodeWay = wxEncodeWay;
	}
	
}