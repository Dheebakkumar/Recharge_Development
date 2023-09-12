package com.RechargeDevlopment.model;

import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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
@Table(name = "RECHARGE_ORDER")
public class RechargeOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ORDER_ID")
	private long orderId;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "AMOUNT")
	private BigDecimal amount;
	
	@Column(name = "CONTACT_NUMBER")
	private String contactNumber;
	
	@Column(name = "TRANSACTION_ID")
	private String transactionId;
	
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	@JsonManagedReference
	private RechargeUser rechargeUser;
	
	@ManyToOne
	@JoinColumn(name = "RECHARGE_PLAN_ID")
	@JsonManagedReference
	private RechargePlan rechargePlan;
	
	@Column(name = "CREATION_ON" , updatable = false)
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;
	
	@Column(name = "UPDATED_ON")
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedOn;

	public RechargeOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public RechargeUser getRechargeUser() {
		return rechargeUser;
	}

	public void setRechargeUser(RechargeUser rechargeUser) {
		this.rechargeUser = rechargeUser;
	}

	public RechargePlan getRechargePlan() {
		return rechargePlan;
	}

	public void setRechargePlan(RechargePlan rechargePlan) {
		this.rechargePlan = rechargePlan;
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
