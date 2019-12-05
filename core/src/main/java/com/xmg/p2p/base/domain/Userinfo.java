package com.xmg.p2p.base.domain;

import com.xmg.p2p.base.util.MaskUtil;

import com.xmg.p2p.base.util.BitStatesUtils;

/**
 * 用户相关信息
 * 
 * @author Administrator
 * 
 */

public class Userinfo extends BaseDomain {
	private int version;// 版本号，主要用于乐观锁

	private long bitState = 0;// 用户状态码，用于表示用户是否完成各类认证
	private String realName;  //对应实名认证中的真实姓名
	private String idNumber;  //对应实名认证中的身份证号码
	private String phoneNumber;
	private String email;
	private int score;// 风控累计分数;
	private Long realAuthId;// 该用户对应的实名认证对象id（实名认证过程也包装成一个对象）

	private SystemDictionaryItem incomeGrade;// 收入
	private SystemDictionaryItem marriage;//婚姻状况
	private SystemDictionaryItem kidCount;//子女状况
	private SystemDictionaryItem educationBackground;//教育背景
	private SystemDictionaryItem houseCondition;//住房情况

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public long getBitState() {
		return bitState;
	}

	public void setBitState(long bitState) {
		this.bitState = bitState;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Long getRealAuthId() {
		return realAuthId;
	}

	public void setRealAuthId(Long realAuthId) {
		this.realAuthId = realAuthId;
	}

	public SystemDictionaryItem getIncomeGrade() {
		return incomeGrade;
	}

	public void setIncomeGrade(SystemDictionaryItem incomeGrade) {
		this.incomeGrade = incomeGrade;
	}

	public SystemDictionaryItem getMarriage() {
		return marriage;
	}

	public void setMarriage(SystemDictionaryItem marriage) {
		this.marriage = marriage;
	}

	public SystemDictionaryItem getKidCount() {
		return kidCount;
	}

	public void setKidCount(SystemDictionaryItem kidCount) {
		this.kidCount = kidCount;
	}

	public SystemDictionaryItem getEducationBackground() {
		return educationBackground;
	}

	public void setEducationBackground(SystemDictionaryItem educationBackground) {
		this.educationBackground = educationBackground;
	}

	public SystemDictionaryItem getHouseCondition() {
		return houseCondition;
	}

	public void setHouseCondition(SystemDictionaryItem houseCondition) {
		this.houseCondition = houseCondition;
	}

	/**
	 * 添加状态码
	 * 
	 * @param state
	 */
	public void addState(long state) {
		this.setBitState(BitStatesUtils.addState(this.bitState, state));
	}

	public void removeState(long state) {
		this.setBitState(BitStatesUtils.removeState(this.bitState, state));
	}

	/**
	 * 返回用户是否已经绑定手机
	 * 
	 * @return
	 */
	public boolean getIsBindPhone() {
		return BitStatesUtils.hasState(this.bitState,
				BitStatesUtils.OP_BIND_PHONE);
	}

	/**
	 * 返回用户是否已经绑定邮箱
	 * 
	 * @return
	 */
	public boolean getIsBindEmail() {
		return BitStatesUtils.hasState(this.bitState,
				BitStatesUtils.OP_BIND_EMAIL);
	}

	/**
	 * 返回用户是否已经填写了基本资料
	 * 
	 * @return
	 */
	public boolean getIsBasicInfo() {
		return BitStatesUtils.hasState(this.bitState,
				BitStatesUtils.OP_BASIC_INFO);
	}

	/**
	 * 返回用户是否已经实名认证
	 * 
	 * @return
	 */
	public boolean getIsRealAuth() {
		return BitStatesUtils.hasState(this.bitState,
				BitStatesUtils.OP_REAL_AUTH);
	}

	/**
	 * 返回用户是否视频认证
	 * 
	 * @return
	 */
	public boolean getIsVedioAuth() {
		return BitStatesUtils.hasState(this.bitState,
				BitStatesUtils.OP_VEDIO_AUTH);
	}

	/**
	 * 返回用户是否绑定银行卡
	 * 
	 * @return
	 */
	public boolean getIsBindBank() {
		return BitStatesUtils.hasState(this.bitState,
				BitStatesUtils.OP_BIND_BANKINFO);
	}

	/**
	 * 返回用户是否有一个借款在处理流程当中
	 * 
	 * @return
	 */
	public boolean getHasBidRequestProcess() {
		return BitStatesUtils.hasState(this.bitState,
				BitStatesUtils.OP_HAS_BIDREQUEST_PROCESS);
	}

	/**
	 * 返回用户是否有一个提现申请在处理流程当中
	 * 
	 * @return
	 */
	public boolean getHasWithdrawProcess() {
		return BitStatesUtils.hasState(this.bitState,
				BitStatesUtils.OP_HAS_MONEYWITHDRAW_PROCESS);
	}


	public String getAnonymousRealName() {
		return MaskUtil.getAnonymousRealName(realName);
	}

	public String getAnonymousIdNumber() {
		return MaskUtil.getAnonymousIdNumber(idNumber);
	}
}
