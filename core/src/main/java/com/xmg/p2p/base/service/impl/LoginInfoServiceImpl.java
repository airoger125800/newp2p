package com.xmg.p2p.base.service.impl;

import com.xmg.p2p.base.domain.Account;
import com.xmg.p2p.base.domain.LoginInfo;
import com.xmg.p2p.base.domain.Userinfo;
import com.xmg.p2p.base.mapper.LogininfoMapper;
import com.xmg.p2p.base.service.IAccountService;
import com.xmg.p2p.base.service.ILoginInfoService;
import com.xmg.p2p.base.service.IUserinfoService;
import com.xmg.p2p.base.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginInfoServiceImpl implements ILoginInfoService {

    @Autowired
    private LogininfoMapper logininfoMapper;

    @Autowired
    private IAccountService accountService;

    @Autowired
    private IUserinfoService userinfoService;


    //    用户注册
    @Override
    public void register(String username, String password) {
        //首先判断用户名是否存在
        int count = this.logininfoMapper.selectCountByUsername(username);
        if(count <= 0) {
            //创建一个LoginInfo对象
            LoginInfo loginInfo = new LoginInfo();
            loginInfo.setUsername(username);
            loginInfo.setPassword(MD5.encode(password));//用MD5为用户的密码加密
            loginInfo.setState(LoginInfo.STATE_NORMAL); //设置账户状态为正常
            this.logininfoMapper.insert(loginInfo); //将新注册的用户信息保存到数据库中

            //在创建logininfo新账户的同时创建account和userinfo
            //这里初步只设定id，其余未设定的为null
            Account account = new Account();
            account.setId(loginInfo.getId()); //这三个账户都是关联一个id，以logininfo为准
            accountService.add(account);

            Userinfo userinfo = new Userinfo();
            userinfo.setId(loginInfo.getId());
            userinfoService.add(userinfo);

        } else {
            //用户名已经存在，直接抛错
            throw new RuntimeException("用户名已经存在!");
        }
    }
}
