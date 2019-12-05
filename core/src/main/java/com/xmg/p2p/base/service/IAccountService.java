package com.xmg.p2p.base.service;

import com.xmg.p2p.base.domain.Account;

/**
 * 账户相关服务
 * 
 * @author Administrator
 * 
 */
public interface IAccountService {

	/**
	 * 记住,写完mapper之后立刻写service,因为这个update是支持乐观锁的
	 * 
	 * @param account
	 */
	void update(Account account);

	void add(Account account);



}
