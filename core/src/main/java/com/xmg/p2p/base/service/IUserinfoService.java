package com.xmg.p2p.base.service;

import java.util.List;
import java.util.Map;

import com.xmg.p2p.base.domain.Userinfo;

/**
 * 用户相关信息服务
 * 
 * @author Administrator
 * 
 */
public interface IUserinfoService {

	/**
	 * 乐观锁支持
	 *
	 * @param userinfo
	 */
	void update(Userinfo userinfo);

	/**
	 * 添加userinfo
	 *
	 * @param ui
	 */
	void add(Userinfo ui);


}
