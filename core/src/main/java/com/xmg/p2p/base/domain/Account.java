package com.xmg.p2p.base.domain;

import java.math.BigDecimal;


import com.xmg.p2p.base.util.BidConst;
import com.xmg.p2p.base.util.MD5;

/**
 * 用户对应的账户信息
 * 既可以借钱，也可以投钱
 * 
 * @author Administrator
 * 
 */

public class Account extends BaseDomain {

	private int version;
	private String tradePassword; //交易密码
	private BigDecimal usableAmount = BidConst.ZERO; //可用余额
	private BigDecimal freezedAmount = BidConst.ZERO; // 冻结金额
	private BigDecimal unReceiveInterest = BidConst.ZERO; //账户待收利息
	private BigDecimal unReceivePrincipal = BidConst.ZERO; //账户待收本金
	private BigDecimal unReturnAmount = BidConst.ZERO;    //账户待还金额
	private BigDecimal remainBorrowLimit = BidConst.INIT_BORROW_LIMIT; //账户剩余授信额度
	private BigDecimal borrowLimit = BidConst.INIT_BORROW_LIMIT;  //授信额度

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getTradePassword() {
		return tradePassword;
	}

	public void setTradePassword(String tradePassword) {
		this.tradePassword = tradePassword;
	}

	public BigDecimal getUsableAmount() {
		return usableAmount;
	}

	public void setUsableAmount(BigDecimal usableAmount) {
		this.usableAmount = usableAmount;
	}

	public BigDecimal getFreezedAmount() {
		return freezedAmount;
	}

	public void setFreezedAmount(BigDecimal freezedAmount) {
		this.freezedAmount = freezedAmount;
	}

	public BigDecimal getUnReceiveInterest() {
		return unReceiveInterest;
	}

	public void setUnReceiveInterest(BigDecimal unReceiveInterest) {
		this.unReceiveInterest = unReceiveInterest;
	}

	public BigDecimal getUnReceivePrincipal() {
		return unReceivePrincipal;
	}

	public void setUnReceivePrincipal(BigDecimal unReceivePrincipal) {
		this.unReceivePrincipal = unReceivePrincipal;
	}

	public BigDecimal getUnReturnAmount() {
		return unReturnAmount;
	}

	public void setUnReturnAmount(BigDecimal unReturnAmount) {
		this.unReturnAmount = unReturnAmount;
	}

	public BigDecimal getRemainBorrowLimit() {
		return remainBorrowLimit;
	}

	public void setRemainBorrowLimit(BigDecimal remainBorrowLimit) {
		this.remainBorrowLimit = remainBorrowLimit;
	}

	public BigDecimal getBorrowLimit() {
		return borrowLimit;
	}

	public void setBorrowLimit(BigDecimal borrowLimit) {
		this.borrowLimit = borrowLimit;
	}

	private String verifyCode;// 做数据校验的

	public String getVerifyCode() {
		return MD5.encode(usableAmount.hashCode() + " "
				+ freezedAmount.hashCode());
	}

	public boolean checkVerifyCode() {
		return MD5.encode(
				usableAmount.hashCode() + " " + freezedAmount.hashCode())
				.equals(verifyCode);
	}

	public BigDecimal getTotalAmount() {
		return usableAmount.add(this.freezedAmount)
				.add(this.unReceivePrincipal);
	}

}
