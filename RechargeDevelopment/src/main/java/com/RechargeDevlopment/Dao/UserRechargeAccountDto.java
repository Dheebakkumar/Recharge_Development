package com.RechargeDevlopment.Dao;


public class UserRechargeAccountDto {

	
	private long accountId;
	
	private String TelecomOperatorName;
	
	private String mobileNumber;
	
	private String nickName;
	
	private boolean favNumber;
	
	private int status;
	
	private boolean defaultNumber;
	
	private long userId;

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public String getTelecomOperatorName() {
		return TelecomOperatorName;
	}

	public void setTelecomOperatorName(String telecomOperatorName) {
		TelecomOperatorName = telecomOperatorName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public boolean isFavNumber() {
		return favNumber;
	}

	public void setFavNumber(boolean favNumber) {
		this.favNumber = favNumber;
	}

	public boolean isDefaultNumber() {
		return defaultNumber;
	}

	public void setDefaultNumber(boolean defaultNumber) {
		this.defaultNumber = defaultNumber;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
