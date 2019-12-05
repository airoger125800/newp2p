package com.xmg.p2p.base.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xmg.p2p.base.domain.Logininfo;
import com.xmg.p2p.base.service.ILogininfoService;
import com.xmg.p2p.base.util.JSONResult;

/**
 * 用于注册/登陆相关
 * 
 * @author Administrator
 * 
 */
@Controller
public class RegisterController {

	@Autowired
	private ILogininfoService logininfoService;

	@RequestMapping("register")
	@ResponseBody
	public JSONResult register(String username, String password) {
		JSONResult json = new JSONResult();
		try {
			logininfoService.register(username, password);
		} catch (RuntimeException re) {
			json.setSuccess(false);
			json.setMsg(re.getMessage());
		}
		return json;
	}



	@RequestMapping("logout")
	public String login(HttpSession session) {
		//清空session即可清空用户登录信息
		session.invalidate();
		return "redirect:login.html";
	}
}
