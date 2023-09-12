package com.RechargeDevlopment.repository;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.RechargeDevlopment.model.RechargePlan;

public interface RechargePlanRepo extends JpaRepository<RechargePlan, Long> {

	RechargePlan findByRechargeAmountAndRechargeVendorVendorId(BigDecimal rechargeAmount,long vendorId);

	RechargePlan findById(long planId);

	RechargePlan findByPlanId(long planId);

	List<RechargePlan> findByRechargeVendorVendorId(long vendorId);

	List<RechargePlan> findByRechargeVendorVendorIdAndConfigRechargeCategoryCategoryId(long vendorId,long categoryId);

	RechargePlan findByPlanId(BigDecimal amount);


}
