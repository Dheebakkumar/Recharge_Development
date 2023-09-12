package com.RechargeDevlopment.service;

import java.util.List;

import com.RechargeDevlopment.Dao.ConfigRechargeCategoryDto;
import com.RechargeDevlopment.Dao.RechargeOperatorDto;
import com.RechargeDevlopment.Dao.RechargeOrderDto;
import com.RechargeDevlopment.Dao.RechargeUserCategoryDto;
import com.RechargeDevlopment.Dao.RechargeUserDto;
import com.RechargeDevlopment.Dao.RechargeUserPlanVendorDto;
import com.RechargeDevlopment.Dao.UserRechargeAccountDto;

public interface RechargeUserService {

	//RechargeUser
	
	public RechargeUserDto addUser(RechargeUserDto rechargeUserDto);
	
	public RechargeUserDto updateUser(RechargeUserDto rechargeUserDto);
	
	public RechargeUserDto getByUser(long userId);
	
	//RechargeOperators
	
	public List<RechargeOperatorDto> getAllOperators();
	
	//RechargeCategory
	
	public List<RechargeUserCategoryDto> getAllCategory();
	
	//RechargePlan
	
	public List<RechargeUserPlanVendorDto> getAllPlanVendorAndCategoryId(long vendorId , long categoryId);
	
	public List<RechargeUserPlanVendorDto> getAllPlanByVendorId(long vendorId);
	
	public RechargeUserPlanVendorDto getByPlanId(long planId);
	
	//RechargeOrder
	
	public RechargeOrderDto addOrder(RechargeOrderDto rechargeOrderDto);
	
	public List<RechargeOrderDto> userOrderHistory(long userId);
	
	public RechargeOrderDto getUserOrderById(long orderId);
	
	//ConfigRechargeCategory
	
	public List<ConfigRechargeCategoryDto> getAll();
	
	//UserRechargeAccount
	
	public UserRechargeAccountDto addAccount(UserRechargeAccountDto userRechargeAccountDto);
	
	public UserRechargeAccountDto updateAccount(UserRechargeAccountDto userRechargeAccountDto);

	public Object deleteAccount(long id);
	
	public List<UserRechargeAccountDto> getAllAccountByUser(long userId);
	
	public UserRechargeAccountDto getDefaultNumber(long userId);
	
	public List<UserRechargeAccountDto> getAllFavNumber(long userId);

}
