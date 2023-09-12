package com.RechargeDevlopment.service;

import java.util.List;

import com.RechargeDevlopment.Dao.ConfigRechargeCategoryDto;
import com.RechargeDevlopment.Dao.RechargeBalanceDto;
import com.RechargeDevlopment.Dao.RechargeOrderDto;
import com.RechargeDevlopment.Dao.RechargePlanDto;
import com.RechargeDevlopment.Dao.RechargeVendorDto;

public interface RechargeVendorService {
	
	//RechargeVendor
	
	public RechargeVendorDto addVendor(RechargeVendorDto rechargeVendorDto);
	
	public RechargeVendorDto getIdByVendor(long vendorId);
	
	public RechargeVendorDto updateVendor(RechargeVendorDto rechargeVendorDto);
	
	public RechargeBalanceDto getBalanceId(long vendorId );
	
	//RechargeHistory
	
	public List<RechargeOrderDto> vendorHistory(long vendorId); 
	
	public List<RechargeOrderDto> vendorRechargePlanHistory(long planId);
	
	public List<RechargeOrderDto> vendorRechargeCategoryHistory(long categoryId);
	
	//RechargeOrder
	
	public RechargeOrderDto getVendorOrderId(long orderId);
	
	//RechargeCategory
	public ConfigRechargeCategoryDto addCategory(ConfigRechargeCategoryDto configRechargeCategoryDto);

	List<ConfigRechargeCategoryDto> getAll();
	
	//RechargePlan
	
	public RechargePlanDto addPlan(RechargePlanDto rechargePlanDto);
	
	public RechargePlanDto updatePlan(RechargePlanDto rechargePlanDto);

	public List<RechargePlanDto> getAllPlanByVendorId(long vendorId);

	public RechargePlanDto getByPlanId(long planId);

}
