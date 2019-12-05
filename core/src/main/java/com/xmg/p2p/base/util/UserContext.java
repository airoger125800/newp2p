package com.xmg.p2p.base.util;

import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.xmg.p2p.base.domain.LoginInfo;

/**
 * 用于存放当前用户的上下文
 * 
 * @author Administrator
 * 
 */
public class UserContext {

	public static final String USER_IN_SESSION = "logininfo";
	public static final String VERIFYCODE_IN_SESSION = "verifycode_in_session";

	/**
	 * 反向获取request的方法,请查看RequestContextListener.requestInitialized打包过程
	 * 
	 * @return
	 */
	private static HttpSession getSession() {
		return ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest().getSession();
	}

	public static void putCurrent(LoginInfo current) {
		// 得到session,并把current放到session中
		getSession().setAttribute(USER_IN_SESSION, current);
	}

	public static LoginInfo getCurrent() {
		return (LoginInfo) getSession().getAttribute(USER_IN_SESSION);
	}




}
