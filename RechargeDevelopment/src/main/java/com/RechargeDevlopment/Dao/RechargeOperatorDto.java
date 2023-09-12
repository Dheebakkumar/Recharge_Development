package com.RechargeDevlopment.Dao;

public class RechargeOperatorDto {

	private long vendorId;
	
	String telecomOperatorName;
	
	

	public String getTelecomOperatorName() {
		return telecomOperatorName;
	}

	public void setTelecomOperatorName(String telecomOperatorName) {
		this.telecomOperatorName = telecomOperatorName;
	}

	public long getVendorId() {
		return vendorId;
	}

	public void setVendorId(long vendorId) {
		this.vendorId = vendorId;
	}
}
