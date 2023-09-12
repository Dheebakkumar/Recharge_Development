package com.RechargeDevlopment.serviceImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RechargeDevlopment.Dao.ConfigRechargeCategoryDto;
import com.RechargeDevlopment.Dao.RechargeBalanceDto;
import com.RechargeDevlopment.Dao.RechargeOrderDto;
import com.RechargeDevlopment.Dao.RechargePlanDto;
import com.RechargeDevlopment.Dao.RechargeVendorDto;
import com.RechargeDevlopment.model.ConfigRechargeCategory;
import com.RechargeDevlopment.model.RechargeOrder;
import com.RechargeDevlopment.model.RechargePlan;
import com.RechargeDevlopment.model.RechargeVendor;
import com.RechargeDevlopment.repository.ConfigRechargeCategoryRepo;
import com.RechargeDevlopment.repository.RechargeOrderRepo;
import com.RechargeDevlopment.repository.RechargePlanRepo;
import com.RechargeDevlopment.repository.RechargeVendorRepo;
import com.RechargeDevlopment.service.RechargeVendorService;

@Service
public class RechargeVendorServiceImpl implements RechargeVendorService {

	@Autowired
	RechargeVendorRepo vendorRepo;
	
	@Autowired
	RechargeOrderRepo rechargeOrderRepo;
	
	@Autowired
	RechargePlanRepo rechargePlanRepo;
	
	@Autowired
	ConfigRechargeCategoryRepo configRechargeCategoryRepo;
	
	@Autowired
	RechargeUserServiceImpl rechargeUserServiceImpl;
	
	
	@Override
	public RechargeVendorDto addVendor(RechargeVendorDto rechargeVendorDto) {
		
		RechargeVendor checkMail = vendorRepo.findByEmailId(rechargeVendorDto.getEmailId());		
		if(checkMail ==null) {
			
			RechargeVendor checkOperator = vendorRepo.findByTelecomOperatorName(rechargeVendorDto.getTelecomOperatorName());		
			if(checkOperator ==null) {
				
				String email = rechargeVendorDto.getEmailId();
		        if (email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
		        	
					RechargeVendor vendor = new RechargeVendor();

					vendor.setFirstName(rechargeVendorDto.getFirstName());
					vendor.setLastName(rechargeVendorDto.getLastName());
					vendor.setGender(rechargeVendorDto.getGender());
					vendor.setAddressLine1(rechargeVendorDto.getAddressLine1());
					vendor.setAddressLine2(rechargeVendorDto.getAddressLine2());
					vendor.setDob(rechargeVendorDto.getDob());
					vendor.setEmailId(rechargeVendorDto.getEmailId());
					vendor.setTelecomOperatorName(rechargeVendorDto.getTelecomOperatorName());
					vendor.setBalance(new BigDecimal("00.00"));
				        	
		        	RechargeVendor rechargeVendor = vendorRepo.save(vendor);
					
					return vendorDto(rechargeVendor);
					
		        }
		        else throw new RuntimeException(" Email Id Format is wrong ");
		       
	        }
			 else throw new RuntimeException(" Telecom Operator Should be Unique ");
			
		}
		else throw new RuntimeException(" This Vendor is Already present ");	
	
	}

	private RechargeVendorDto vendorDto(RechargeVendor rechargeVendor) {

		RechargeVendorDto dto = new RechargeVendorDto();
		
		dto.setVendorId(rechargeVendor.getVendorId());
		dto.setFirstName(rechargeVendor.getFirstName());
		dto.setLastName(rechargeVendor.getLastName());
		dto.setGender(rechargeVendor.getGender());
		dto.setAddressLine1(rechargeVendor.getAddressLine1());
		dto.setAddressLine2(rechargeVendor.getAddressLine2());
		dto.setDob(rechargeVendor.getDob());
		dto.setEmailId(rechargeVendor.getEmailId());
		dto.setTelecomOperatorName(rechargeVendor.getTelecomOperatorName());
		dto.setBalance(rechargeVendor.getBalance());
		dto.setCreatedOn(rechargeVendor.getCreatedOn());
		dto.setLastUpdatedOn(rechargeVendor.getLastUpdatedOn());
		
		return dto;
	}

	@Override
	public RechargeVendorDto getIdByVendor(long vendorId) {

		RechargeVendor rechargeVendor = vendorRepo.findByVendorId(vendorId); 
		
		if(rechargeVendor !=null) {
						
			return vendorDto(rechargeVendor);
		}
		else throw new RuntimeException("This Vendor Id is Not Present");
		
	}

	@Override
	public RechargeVendorDto updateVendor(RechargeVendorDto rechargeVendorDto) {

		RechargeVendor vendor = vendorRepo.findByVendorId(rechargeVendorDto.getVendorId()); 
		if(vendor !=null) {
			
			RechargeVendor checkMail = vendorRepo.findByEmailId(rechargeVendorDto.getEmailId());
			
			if(checkMail ==null) {
				
				String email = rechargeVendorDto.getEmailId();
		        if (email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {

			        	vendor.setVendorId(rechargeVendorDto.getVendorId());
						vendor.setFirstName(rechargeVendorDto.getFirstName());
						vendor.setLastName(rechargeVendorDto.getLastName());
						vendor.setGender(rechargeVendorDto.getGender());
						vendor.setAddressLine1(rechargeVendorDto.getAddressLine1());
						vendor.setAddressLine2(rechargeVendorDto.getAddressLine2());
						vendor.setDob(rechargeVendorDto.getDob());
						vendor.setEmailId(rechargeVendorDto.getEmailId());
						vendor.setTelecomOperatorName(rechargeVendorDto.getTelecomOperatorName());
				
						RechargeVendor rechargeVendor = vendorRepo.save(vendor);
						
						return vendorDto(rechargeVendor);
					
		        }
		        else throw new RuntimeException(" Email Id Format is wrong ");
					
			}
			else throw new RuntimeException("This Email Id is Already Present , change your Email Uniquly");
			
		}
		else throw new RuntimeException("This Vendor Id is not present");
		
	}

	@Override
	public RechargeBalanceDto getBalanceId(long vendorId) {

		RechargeVendor rechargeVendor = vendorRepo.findByVendorId(vendorId);
		
		if(rechargeVendor !=null) {
			
			RechargeBalanceDto dto = new RechargeBalanceDto();
			
			dto.setVendorId(rechargeVendor.getVendorId());
			dto.setFirstName(rechargeVendor.getFirstName());
			dto.setLastName(rechargeVendor.getLastName());
			dto.setEmailId(rechargeVendor.getEmailId());
			dto.setBalance(rechargeVendor.getBalance());
		
			return dto;
		}
		else {
			
			throw new RuntimeException("This Vendor Id is Not Present");
		}
		
	}

	@Override
	public List<RechargeOrderDto> vendorHistory(long vendorId) {

		RechargeVendor checkVendor = vendorRepo.findByVendorId(vendorId);
		if(checkVendor !=null) {
		
			List<RechargeOrder> rechargeOrder = rechargeOrderRepo.findByRechargePlanRechargeVendorVendorId(vendorId);
			List<RechargeOrderDto> newList = new ArrayList<RechargeOrderDto>();
			
			for(RechargeOrder order : rechargeOrder) {
				
				RechargeOrderDto recharge = rechargeUserServiceImpl.orderDto(order);
				
				newList.add(recharge);
				
			}
 			
			return newList;
		}
		else throw new RuntimeException("Vendor Id is Not Present");
	
	}

	@Override
	public List<RechargeOrderDto> vendorRechargePlanHistory(long planId) {

		RechargePlan checkPlan = rechargePlanRepo.findByPlanId(planId);
		if(checkPlan !=null) {
			
			List<RechargeOrder> rechargeOrder = rechargeOrderRepo.findByRechargePlanPlanId(planId);
			
			List<RechargeOrderDto> newList = new ArrayList<RechargeOrderDto>();
			
			for(RechargeOrder order : rechargeOrder) {
				
				RechargeOrderDto recharge = rechargeUserServiceImpl.orderDto(order);
				
				newList.add(recharge);
				
			}
 			
			return newList;
		}
		else throw new RuntimeException("Plan Id is Not Present");
	
	}

	@Override
	public List<RechargeOrderDto> vendorRechargeCategoryHistory(long categoryId) {


		ConfigRechargeCategory checkCategory = configRechargeCategoryRepo.findByCategoryId(categoryId);
		if(checkCategory !=null) {
			
			List<RechargeOrder> rechargeOrder = rechargeOrderRepo.findByRechargePlanConfigRechargeCategoryCategoryId(categoryId);
			
			List<RechargeOrderDto> newList = new ArrayList<RechargeOrderDto>();
			
			for(RechargeOrder order : rechargeOrder) {
				
				RechargeOrderDto recharge = rechargeUserServiceImpl.orderDto(order);
				
				newList.add(recharge);
				
			}
 			return newList;
		}
		else throw new RuntimeException("Category Id is Not Present");
		
	}

	@Override
	public RechargeOrderDto getVendorOrderId(long orderId) {
		
		RechargeOrder checkOrderId = rechargeOrderRepo.findByOrderId(orderId);
		if(checkOrderId !=null) {
					
			return rechargeUserServiceImpl.orderDto(checkOrderId);
		}
		else throw new RuntimeException("Order Id is not Present...");
		
	}
	
	

	@Override
	public ConfigRechargeCategoryDto addCategory(ConfigRechargeCategoryDto configRechargeCategoryDto) {
		
		ConfigRechargeCategory configRechargeCategory = configRechargeCategoryRepo.findByCategoryName(configRechargeCategoryDto.getCategoryName());
		if(configRechargeCategory == null) {
			
			ConfigRechargeCategory category = new ConfigRechargeCategory();
			
			category.setCategoryName(configRechargeCategoryDto.getCategoryName());
			
			ConfigRechargeCategory rechargeCategory = configRechargeCategoryRepo.save(category);
						
			return rechargeUserServiceImpl.categoryDto(rechargeCategory);
			
		}
		else throw new RuntimeException("Category Name should be Unique");
			
	}
	
	@Override
	public List<ConfigRechargeCategoryDto> getAll() {

		List<ConfigRechargeCategory> list = configRechargeCategoryRepo.findAll();
		
		List<ConfigRechargeCategoryDto> newList = new ArrayList<>();
		
		for(ConfigRechargeCategory rechargeCategory : list) {
			
			ConfigRechargeCategoryDto category = rechargeUserServiceImpl.categoryDto(rechargeCategory);
			
			newList.add(category);
		}
		
		return newList;
	
		
	}
	
	//RechargePlanServiceImpl
	
	
	@Override
	public RechargePlanDto addPlan(RechargePlanDto rechargePlanDto) {
		
		
		RechargeVendor checkVendorId = vendorRepo.findByVendorId(rechargePlanDto.getVendorId());
		if(checkVendorId !=null) {
			
			ConfigRechargeCategory checkCategoryId = configRechargeCategoryRepo.findByCategoryId(rechargePlanDto.getCategoryId());
			if(checkCategoryId !=null) {
				
				RechargePlan checkVendorIdAndRechargeAmount = rechargePlanRepo.findByRechargeAmountAndRechargeVendorVendorId(rechargePlanDto.getRechargeAmount(),rechargePlanDto.getVendorId());
				if(checkVendorIdAndRechargeAmount==null) {
			
					RechargePlan plan = new RechargePlan();
					
					plan.setRechargeAmount(rechargePlanDto.getRechargeAmount());
					plan.setDescription(rechargePlanDto.getDescription());
					plan.setValidity(rechargePlanDto.getValidity());
					plan.setConfigRechargeCategory(checkCategoryId);
					plan.setRechargeVendor(checkVendorId);
							
					RechargePlan rechargePlan = rechargePlanRepo.save(plan);
							
					return planDto(rechargePlan);
						
				}
				else throw new RuntimeException("Recharge Amount Already Present in this Vendor Id");
				
			}
			else throw new RuntimeException("Category Id is Not Present");
					
		}
		else throw new RuntimeException("Vendor Id is Not Present");

	}

	
	private RechargePlanDto planDto(RechargePlan rechargePlan) {
	
		RechargePlanDto dto = new RechargePlanDto();
		
		dto.setPlanId(rechargePlan.getPlanId());
		dto.setVendorId(rechargePlan.getRechargeVendor().getVendorId());
		dto.setCategoryId(rechargePlan.getConfigRechargeCategory().getCategoryId());
		dto.setRechargeAmount(rechargePlan.getRechargeAmount());
		dto.setDescription(rechargePlan.getDescription());
		dto.setValidity(rechargePlan.getValidity());
		dto.setCreatedOn(rechargePlan.getCreatedOn());
		dto.setUpdatedOn(rechargePlan.getUpdatedOn());
	
		return dto;
	}
	
	
	@Override
	public RechargePlanDto updatePlan(RechargePlanDto rechargePlanDto) {

		RechargePlan checkPlanId = rechargePlanRepo.findByPlanId(rechargePlanDto.getPlanId());
		if(checkPlanId !=null) {
		
			RechargePlan checkVendorIdAndRechargeAmount = rechargePlanRepo.findByRechargeAmountAndRechargeVendorVendorId(rechargePlanDto.getRechargeAmount(),rechargePlanDto.getVendorId());
			if(checkVendorIdAndRechargeAmount==null) {
				
				checkPlanId.setRechargeAmount(rechargePlanDto.getRechargeAmount());
				checkPlanId.setDescription(rechargePlanDto.getDescription());
				checkPlanId.setValidity(rechargePlanDto.getValidity());
						
				RechargePlan rechargePlan = rechargePlanRepo.save(checkPlanId);
									
					return planDto(rechargePlan);
				}
				else throw new RuntimeException("Recharge Amount Already Present in this Vendor Id");		
		}
		else throw new RuntimeException("Plan Id is Not Present");

	}
	
	@Override
	public RechargePlanDto getByPlanId(long planId) {
	
		RechargePlan checkPlanId = rechargePlanRepo.findByPlanId(planId);
		
		if(checkPlanId !=null) {
					
			return planDto(checkPlanId);
		}
		
		else throw new RuntimeException("This Plan Id is Not Present");
	
	}
	
	@Override
	public List<RechargePlanDto> getAllPlanByVendorId(long vendorId) {

		RechargeVendor vendor = vendorRepo.findByVendorId(vendorId);
		if(vendor !=null) {
			
			List<RechargePlan> checkVendorId = rechargePlanRepo.findByRechargeVendorVendorId(vendorId);
			List<RechargePlanDto> rechargePlan = new ArrayList<>();
			
			for(RechargePlan plan : checkVendorId) {
								
				RechargePlanDto recharge = planDto(plan);
				rechargePlan.add(recharge);
			}
			
			return rechargePlan;
			
		}
		
		else throw new RuntimeException("This Vendor Id is Not Present");
	
		
	}
	

}
