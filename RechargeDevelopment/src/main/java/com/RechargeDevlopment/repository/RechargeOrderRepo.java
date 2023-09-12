package com.RechargeDevlopment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RechargeDevlopment.model.RechargeOrder;
import com.RechargeDevlopment.model.RechargePlan;

public interface RechargeOrderRepo extends JpaRepository<RechargeOrder, Long> {

	List<RechargeOrder> findByRechargeUserUserId(long userId);

	List<RechargeOrder> findByRechargePlanRechargeVendorVendorId(long vendorId);

	List<RechargeOrder> findByRechargePlanPlanId(long planId);

	List<RechargeOrder> findByRechargePlanConfigRechargeCategoryCategoryId(long categoryId);

	RechargeOrder findByOrderId(long orderId);

	
}
