package com.RechargeDevlopment.model;

import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "RECHARGE_PLAN")
public class RechargePlan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="PLAN_ID")
	private long planId;
	
	@Column(name = "RECHARGE_AMOUNT")
	private BigDecimal rechargeAmount;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "VALIDITY")
	private String validity;
	
	@JoinColumn(name = "CATEGORY_ID")
	@ManyToOne
	private ConfigRechargeCategory configRechargeCategory ;
	
	@JoinColumn(name = "VENDOR_ID")
	@ManyToOne
	private RechargeVendor rechargeVendor;
	
	@Column(name = "CREATION_ON" , updatable = false)
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;
	
	@Column(name = "UPDATED_ON")
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedOn;

	public RechargePlan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getPlanId() {
		return planId;
	}

	public void setPlanId(long planId) {
		this.planId = planId;
	}

	public BigDecimal getRechargeAmount() {
		return rechargeAmount;
	}

	public void setRechargeAmount(BigDecimal rechargeAmount) {
		this.rechargeAmount = rechargeAmount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getValidity() {
		return validity;
	}

	public void setValidity(String validity) {
		this.validity = validity;
	}

	public ConfigRechargeCategory getConfigRechargeCategory() {
		return configRechargeCategory;
	}

	public void setConfigRechargeCategory(ConfigRechargeCategory configRechargeCategory) {
		this.configRechargeCategory = configRechargeCategory;
	}

	public RechargeVendor getRechargeVendor() {
		return rechargeVendor;
	}

	public void setRechargeVendor(RechargeVendor rechargeVendor) {
		this.rechargeVendor = rechargeVendor;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}
	
	
	
}
