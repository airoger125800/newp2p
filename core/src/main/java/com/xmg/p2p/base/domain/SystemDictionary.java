package com.xmg.p2p.base.domain;

import java.util.HashMap;
import java.util.Map;


import com.alibaba.fastjson.JSONObject;

/**
 * 数据字典分类
 * @author Administrator
 *
 */

public class SystemDictionary extends BaseDomain{
	private String sn;
	private String title;

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 返回当前的json字符串
	 * @return
	 */
	public String getJsonString(){
		Map<String,Object> json=new HashMap<>();
		json.put("id",id);
		json.put("sn", sn);
		json.put("title", title);
		return JSONObject.toJSONString(json);
	}
}
