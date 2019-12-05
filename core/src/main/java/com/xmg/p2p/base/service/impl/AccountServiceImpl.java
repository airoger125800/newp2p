package com.xmg.p2p.base.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xmg.p2p.base.domain.Account;
import com.xmg.p2p.base.mapper.AccountMapper;
import com.xmg.p2p.base.service.IAccountService;

@Service("accountService")
public class AccountServiceImpl implements IAccountService {

	@Autowired
	private AccountMapper accountMapper;

	@Override
	//	乐观锁
	//  一旦有乐观锁，要立即重写它的update方法
	public void update(Account account) {
		int ret = this.accountMapper.updateByPrimaryKey(account);
		if (ret == 0) {
			throw new RuntimeException("乐观锁失败,Account:" + account.getId());
		}
	}

	/**
	 * 将account账户插入数据库中存储
	 * @param account
	 */
	@Override
	public void add(Account account) {
		this.accountMapper.insert(account);
	}





}
