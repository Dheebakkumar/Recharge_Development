package com.RechargeDevlopment.model;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name = "USER_RECHARGE_ACCOUNT")

public class UserRechargeAccount {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "ACCOUNT_ID")
		private long accountId;
		
		@Column(name="TELECOM_OPERATOR_NAME")
		private String TelecomOperatorName;
		
		@Column(name="MOBILE_NUMBER")
		private String mobileNumber;
		
		@Column(name="NICK_NAME")
		private String nickName;
		
		@Column(name="FAV_NUMBER")
		private boolean favNumber;
		
		@Column(name="DEFAULT_NUMBER")
		private boolean defaultNumber;
		
		@Column(name="STATUS")
		private int status;
		
		@ManyToOne
		@JoinColumn(name="USER_ID")
		private RechargeUser rechargeUser;

		public UserRechargeAccount() {
			super();
			// TODO Auto-generated constructor stub
		}

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

		public boolean getFavNumber() {
			return favNumber;
		}

		public void setFavNumber(boolean favNumber) {
			this.favNumber = favNumber;
		}

		public boolean getDefaultNumber() {
			return defaultNumber;
		}

		public void setDefaultNumber(boolean defaultNumber) {
			this.defaultNumber = defaultNumber;
		}

		public RechargeUser getRechargeUser() {
			return rechargeUser;
		}

		public void setRechargeUser(RechargeUser rechargeUser) {
			this.rechargeUser = rechargeUser;
		}

		public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
		}

		
		
}
