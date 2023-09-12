 package com.RechargeDevlopment.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.RechargeDevlopment.model.RechargeVendor;


public interface RechargeVendorRepo extends JpaRepository<RechargeVendor, Long> {

	RechargeVendor findByEmailId(String emailId);

	RechargeVendor findByVendorId(long vendorId);

	RechargeVendor findByTelecomOperatorName(String telecomOperatorName);

}
