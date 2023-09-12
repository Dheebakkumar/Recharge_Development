package com.RechargeDevlopment.serviceImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RechargeDevlopment.Dao.ConfigRechargeCategoryDto;
import com.RechargeDevlopment.Dao.RechargeOperatorDto;
import com.RechargeDevlopment.Dao.RechargeOrderDto;
import com.RechargeDevlopment.Dao.RechargeUserCategoryDto;
import com.RechargeDevlopment.Dao.RechargeUserDto;
import com.RechargeDevlopment.Dao.RechargeUserPlanVendorDto;
import com.RechargeDevlopment.Dao.UserRechargeAccountDto;
import com.RechargeDevlopment.model.ConfigRechargeCategory;
import com.RechargeDevlopment.model.RechargeOrder;
import com.RechargeDevlopment.model.RechargePlan;
import com.RechargeDevlopment.model.RechargeUser;
import com.RechargeDevlopment.model.RechargeVendor;
import com.RechargeDevlopment.model.UserRechargeAccount;
import com.RechargeDevlopment.repository.ConfigRechargeCategoryRepo;
import com.RechargeDevlopment.repository.RechargeOrderRepo;
import com.RechargeDevlopment.repository.RechargePlanRepo;
import com.RechargeDevlopment.repository.RechargeUserRepo;
import com.RechargeDevlopment.repository.RechargeVendorRepo;
import com.RechargeDevlopment.repository.UserRechargeAccountRepo;
import com.RechargeDevlopment.service.RechargeUserService;


@Service
public class RechargeUserServiceImpl implements RechargeUserService{

	@Autowired
	RechargeUserRepo rechargeUserRepo;
	
	@Autowired
	RechargeVendorRepo rechargeVendorRepo;

	@Autowired
	ConfigRechargeCategoryRepo configRechargeCategoryRepo;
	
	@Autowired
	RechargePlanRepo rechargePlanRepo;
	
	@Autowired
	RechargeOrderRepo rechargeOrderRepo;
	
	@Autowired
	UserRechargeAccountRepo userRechargeAccountRepo;
	
	
	@Override
	public RechargeUserDto addUser(RechargeUserDto rechargeUserDto) {
			
		RechargeUser checkEmail = rechargeUserRepo.findByEmail(rechargeUserDto.getEmail());
		if(checkEmail == null) {
			
			String email = rechargeUserDto.getEmail(); 
	        if (email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
	            
	        	RechargeUser checkAdhaar = rechargeUserRepo.findByAadhaarNumber(rechargeUserDto.getAadhaarNumber());
				if(checkAdhaar == null) {
	        	
					String adhaarNumber = rechargeUserDto.getAadhaarNumber();
		            if (adhaarNumber.matches("\\d{12}")) {
						
						
						RechargeUser rechargeUser = new RechargeUser();
						
						rechargeUser.setFirstName(rechargeUserDto.getFirstName());
						rechargeUser.setLastName(rechargeUserDto.getLastName());
						rechargeUser.setDob(rechargeUserDto.getDob());
						rechargeUser.setEmail(rechargeUserDto.getEmail());
						rechargeUser.setGender(rechargeUserDto.getGender());
						rechargeUser.setMobileNumber(rechargeUserDto.getMobileNumber());
						rechargeUser.setAadhaarNumber(rechargeUserDto.getAadhaarNumber());
						rechargeUser.setBalance(new BigDecimal(1000.00));
						
						RechargeUser user = rechargeUserRepo.save(rechargeUser);
						
					
						
						return userDto(user);
			
					}
		            throw new RuntimeException("Invalid Aadhaar Number format.");
		            
		            
		        }else throw new RuntimeException("Adhaar Number Should be Unique");           
	            
	        }
	        else throw new RuntimeException("Invalid Email format.");
			
		}
		else throw new RuntimeException("Email Id Should be Unique");
			
	}

	public RechargeUserDto userDto(RechargeUser user) {
		
		RechargeUserDto dto = new RechargeUserDto();
		
		dto.setUserId(user.getUserId());
		dto.setFirstName(user.getFirstName());
		dto.setLastName(user.getLastName());
		dto.setDob(user.getDob());
		dto.setEmail(user.getEmail());
		dto.setGender(user.getGender());
		dto.setAadhaarNumber(user.getAadhaarNumber());
		dto.setMobileNumber(user.getMobileNumber());
		dto.setBalance(user.getBalance());
		dto.setCreatedOn(user.getCreatedOn());
		dto.setUpdatedOn(user.getUpdatedOn());
		
		return dto;
	}
	
	
	@Override
	public RechargeUserDto updateUser(RechargeUserDto rechargeUserDto) {
		
		RechargeUser checkUserId = rechargeUserRepo.findByUserId(rechargeUserDto.getUserId());
		if(checkUserId !=null) {
			
			RechargeUser checkEmail = rechargeUserRepo.findByEmail(rechargeUserDto.getEmail());
			if(checkEmail == null) {
				
				String email = rechargeUserDto.getEmail();
		        if (email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
		            
		        	RechargeUser checkAdhaar = rechargeUserRepo.findByAadhaarNumber(rechargeUserDto.getAadhaarNumber());
					if(checkAdhaar == null) {
		        	
						String adhaarNumber = rechargeUserDto.getAadhaarNumber();
			            if (adhaarNumber.matches("\\d{12}")) {
							
			            	checkUserId.setFirstName(rechargeUserDto.getFirstName());
			            	checkUserId.setLastName(rechargeUserDto.getLastName());
			            	checkUserId.setDob(rechargeUserDto.getDob());
			            	checkUserId.setEmail(rechargeUserDto.getEmail());
			            	checkUserId.setGender(rechargeUserDto.getGender());
			            	checkUserId.setMobileNumber(rechargeUserDto.getMobileNumber());
			            	checkUserId.setAadhaarNumber(rechargeUserDto.getAadhaarNumber());
							
							RechargeUser user = rechargeUserRepo.save(checkUserId);
							
							return userDto(user);
				
						}
			            throw new RuntimeException("Invalid Aadhaar Number format.");
			            
			            
			        }else throw new RuntimeException("Adhaar Number Should be Unique");           
		            
		        }
		        else throw new RuntimeException("Invalid Email format.");
				
			}
			else throw new RuntimeException("Email Id Should be Unique");
			
		}
		else throw new RuntimeException("User Id is not present");
		
	}

	@Override
	public RechargeUserDto getByUser(long userId) {
 
		RechargeUser checkUserId = rechargeUserRepo.findByUserId(userId);
		if(checkUserId !=null) {
			
			return userDto(checkUserId);
		}
		else throw new RuntimeException("User Id is not present");
		
	}

	
	@Override
	public List<RechargeOperatorDto> getAllOperators() {

		List<RechargeVendor> vendor = rechargeVendorRepo.findAll();
		
		List<RechargeOperatorDto> newList = new ArrayList<>();
		
		for(RechargeVendor rechargeVendor :vendor) {
			
			RechargeOperatorDto dto = new RechargeOperatorDto();
			dto.setVendorId(rechargeVendor.getVendorId());
			dto.setTelecomOperatorName(rechargeVendor.getTelecomOperatorName());
			
			newList.add(dto);
		}
		
		return newList;
	}

	@Override
	public List<RechargeUserCategoryDto> getAllCategory() {
		
		List<ConfigRechargeCategory> category = configRechargeCategoryRepo.findAll();
		
		List<RechargeUserCategoryDto> newList = new ArrayList<>();
		
		for(ConfigRechargeCategory rechargeCategory : category) {
			
			RechargeUserCategoryDto dto = new RechargeUserCategoryDto();
			
			dto.setCategoryId(rechargeCategory.getCategoryId());
			dto.setCategoryName(rechargeCategory.getCategoryName());
			
			newList.add(dto);
		}
		
		return newList;
		
	}

	@Override
	public List<RechargeUserPlanVendorDto> getAllPlanVendorAndCategoryId(long vendorId, long categoryId) {
		
		RechargeVendor checkVendor = rechargeVendorRepo.findByVendorId(vendorId);
		if(checkVendor !=null) {
			
			ConfigRechargeCategory checkCategory = configRechargeCategoryRepo.findByCategoryId(categoryId);
			if(checkCategory !=null) {
				
				List<RechargePlan> findPlan = rechargePlanRepo.findByRechargeVendorVendorIdAndConfigRechargeCategoryCategoryId(vendorId ,categoryId);
				
				List<RechargeUserPlanVendorDto> rechargePlan = new ArrayList<>();
				
				for(RechargePlan plan : findPlan) {
					
					RechargeUserPlanVendorDto planDto = rechargeplanDto(plan);
								
					rechargePlan.add(planDto);
				}
				
				return rechargePlan;
				
			}
			else throw new RuntimeException("Category Id is Wrong");
		}
		else throw new RuntimeException("Vendor Id is Wrong");
		
	}

	private RechargeUserPlanVendorDto rechargeplanDto(RechargePlan plan) {

		RechargeUserPlanVendorDto dto = new RechargeUserPlanVendorDto();
		
		dto.setPlanId(plan.getPlanId());
		dto.setVendorId(plan.getRechargeVendor().getVendorId());
		dto.setCategoryId(plan.getConfigRechargeCategory().getCategoryId());
		dto.setRechargeAmount(plan.getRechargeAmount());
		dto.setDescription(plan.getDescription());
		dto.setValidity(plan.getValidity());
		
		return dto;
	}

	@Override
	public List<RechargeUserPlanVendorDto> getAllPlanByVendorId(long vendorId) {
		
			RechargeVendor vendor = rechargeVendorRepo.findByVendorId(vendorId);
			if(vendor !=null) {
				
				List<RechargePlan> checkVendorId = rechargePlanRepo.findByRechargeVendorVendorId(vendorId);
				List<RechargeUserPlanVendorDto> rechargePlan = new ArrayList<>();
				
				for(RechargePlan plan : checkVendorId) {
					
					RechargeUserPlanVendorDto planDto = rechargeplanDto(plan);
					
					rechargePlan.add(planDto);
				}
				
				return rechargePlan;
				
			}
			
			else throw new RuntimeException("This Vendor Id is Not Present");
		
	}

	@Override
	public RechargeUserPlanVendorDto getByPlanId(long planId) {
		

		RechargePlan checkPlanId = rechargePlanRepo.findByPlanId(planId);
		
		if(checkPlanId !=null) {
			
			RechargeUserPlanVendorDto planDto = rechargeplanDto(checkPlanId);
			return planDto;
		}
		
		else throw new RuntimeException("This Plan Id is Not Present");
	
	}

	@Override
	public RechargeOrderDto addOrder(RechargeOrderDto rechargeOrderDto) {

		
		RechargeUser checkUser = rechargeUserRepo.findByUserId(rechargeOrderDto.getUserId());
		if(checkUser!=null) {
			
			RechargePlan checkPlan = rechargePlanRepo.findByPlanId(rechargeOrderDto.getPlanId());
			if(checkPlan !=null) {
						
				
				BigDecimal totalAmount = checkPlan.getRechargeAmount();
				System.out.println(totalAmount);
						
				BigDecimal balanceAmount = checkUser.getBalance();
				System.out.println(balanceAmount);
						
				int value = balanceAmount.compareTo(totalAmount);
				System.out.println(value);
						
				if(value >=0 ) {
							
					BigDecimal currentBalance = balanceAmount.subtract(totalAmount);
					System.out.println(currentBalance);	
					checkUser.setBalance(currentBalance);
					
					BigDecimal vendorBalance = checkPlan.getRechargeVendor().getBalance().add(totalAmount);
					checkPlan.getRechargeVendor().setBalance(vendorBalance);
					
					
						
					RechargeOrder rechargeOrder = new RechargeOrder();
							
					rechargeOrder.setDescription("Payment Successfully");
					rechargeOrder.setAmount(totalAmount);
					rechargeOrder.setContactNumber(rechargeOrderDto.getContactNumber());
					rechargeOrder.setTransactionId(UUID.randomUUID().toString());
					rechargeOrder.setRechargePlan(checkPlan);
					rechargeOrder.setRechargeUser(checkUser);
							
					RechargeOrder order = rechargeOrderRepo.save(rechargeOrder);
							
					return orderDto(order);
				
				}
				else throw new RuntimeException("Your Balance is LessThan Amount...");	
					
			}
			else throw new RuntimeException("Plan Id Is Not Present");
			
		}
		else throw new RuntimeException("User Id Is Not Present");
		
	}
	
	public RechargeOrderDto orderDto(RechargeOrder order) {
		

		RechargeOrderDto dto = new RechargeOrderDto();
		
		dto.setOrderId(order.getOrderId());
		dto.setAmount(order.getAmount());
		dto.setTransactionId(order.getTransactionId());
		dto.setContactNumber(order.getContactNumber());
		dto.setDescription(order.getDescription());
		dto.setPlanId(order.getRechargePlan().getPlanId());
		dto.setUserId(order.getRechargeUser().getUserId());
		dto.setCreatedOn(order.getCreatedOn());
		dto.setUpdatedOn(order.getUpdatedOn());
		
		return dto;
	}

	@Override
	public List<RechargeOrderDto> userOrderHistory(long userId) {

		RechargeUser checkUser = rechargeUserRepo.findByUserId(userId);
		if(checkUser!=null) { 
			
			List<RechargeOrder> findOrder =  rechargeOrderRepo.findByRechargeUserUserId(userId);
			
			List<RechargeOrderDto> newList = new ArrayList<RechargeOrderDto>();
			
			for(RechargeOrder order : findOrder) {
				
				RechargeOrderDto orderHistory = rechargeOrderHistory(order);
				
				newList.add(orderHistory);
				
			}
 			
			return newList;
		}
		else throw new RuntimeException("User Id is Not Present");
	
	}

	private RechargeOrderDto rechargeOrderHistory(RechargeOrder order) {

		RechargeOrderDto dto = new RechargeOrderDto();
		
		dto.setOrderId(order.getOrderId());
		dto.setAmount(order.getAmount());
		dto.setTransactionId(order.getTransactionId());
		dto.setContactNumber(order.getContactNumber());
		dto.setDescription(order.getDescription());
		dto.setPlanId(order.getRechargePlan().getPlanId());
		dto.setUserId(order.getRechargeUser().getUserId());
		dto.setCreatedOn(order.getCreatedOn());
		dto.setUpdatedOn(order.getUpdatedOn());
		
		return dto;
	}

	@Override
	public RechargeOrderDto getUserOrderById(long orderId) {
		
		RechargeOrder checkOrderId = rechargeOrderRepo.findByOrderId(orderId);
		if(checkOrderId !=null) {
			
			RechargeOrderDto rechargeOrder = rechargeOrderHistory(checkOrderId);
			
			return rechargeOrder;
		}
		else throw new RuntimeException("Order Id is not Present...");
		
	}

	
	
	@Override
	public List<ConfigRechargeCategoryDto> getAll() {

		List<ConfigRechargeCategory> list = configRechargeCategoryRepo.findAll();
		
		List<ConfigRechargeCategoryDto> newList = new ArrayList<>();
		
		for(ConfigRechargeCategory rechargeCategory : list) {
			
			ConfigRechargeCategoryDto category = categoryDto(rechargeCategory);
			
			newList.add(category);
		}
		
		return newList;
	
		
	}
	
	public ConfigRechargeCategoryDto categoryDto(ConfigRechargeCategory rechargeCategory) {
		
		ConfigRechargeCategoryDto dto = new ConfigRechargeCategoryDto();
		
		dto.setCategoryId(rechargeCategory.getCategoryId());
		dto.setCategoryName(rechargeCategory.getCategoryName());
		dto.setCreatedOn(rechargeCategory.getCreatedOn());
		dto.setLastUpdatedOn(rechargeCategory.getLastUpdatedOn());
		
		return dto;
	}

	
	//UserRechargeAccountServiceImpl
	
	public UserRechargeAccountDto addAccount(UserRechargeAccountDto userRechargeAccountDto) {
		
		RechargeUser findUser = rechargeUserRepo.findByUserId(userRechargeAccountDto.getUserId());
		if(findUser !=null) {
							
			UserRechargeAccount userAccount = new UserRechargeAccount();
				
			userAccount.setNickName(userRechargeAccountDto.getNickName());
			userAccount.setMobileNumber(userRechargeAccountDto.getMobileNumber());
			userAccount.setRechargeUser(findUser);
			userAccount.setStatus(1);
			userAccount.setTelecomOperatorName(userRechargeAccountDto.getTelecomOperatorName());
			userAccount.setDefaultNumber(userRechargeAccountDto.isDefaultNumber());
			userAccount.setFavNumber(userRechargeAccountDto.isFavNumber());
				
				
			if(userRechargeAccountDto.isDefaultNumber() == true) {
					
				UserRechargeAccount change = userRechargeAccountRepo.findByRechargeUserUserIdAndDefaultNumber(userRechargeAccountDto.getUserId(),userRechargeAccountDto.isDefaultNumber());
				if(change == null) {
				
					UserRechargeAccount userRechargeAccount = userRechargeAccountRepo.save(userAccount);
								
					return accountDto(userRechargeAccount);
				}
				else {		
					
					change.setDefaultNumber(false);
					userRechargeAccountRepo.save(change);
								
					UserRechargeAccount userRechargeAccount = userRechargeAccountRepo.save(userAccount);
					
					return accountDto(userRechargeAccount);
					
				}
				
			}	
			else {
					
				UserRechargeAccount userRechargeAccount = userRechargeAccountRepo.save(userAccount);
					
				return accountDto(userRechargeAccount);
			}
						
		}
		else throw new RuntimeException("User Id is Not Present...");

		
	}

	private UserRechargeAccountDto accountDto(UserRechargeAccount userRechargeAccount) {
		
		UserRechargeAccountDto dto = new UserRechargeAccountDto();
		
		dto.setAccountId(userRechargeAccount.getAccountId());
		dto.setUserId(userRechargeAccount.getRechargeUser().getUserId());
		dto.setNickName(userRechargeAccount.getNickName());
		dto.setMobileNumber(userRechargeAccount.getMobileNumber());
		dto.setTelecomOperatorName(userRechargeAccount.getTelecomOperatorName());
		dto.setDefaultNumber(userRechargeAccount.getDefaultNumber());
		dto.setStatus(userRechargeAccount.getStatus());
		dto.setFavNumber(userRechargeAccount.getFavNumber());
			
		return dto;
	}

	@Override
	public UserRechargeAccountDto updateAccount(UserRechargeAccountDto userRechargeAccountDto) {

		UserRechargeAccount userAccount = userRechargeAccountRepo.findByAccountId(userRechargeAccountDto.getAccountId());
		if(userAccount !=null) {
			
			
				userAccount.setAccountId(userRechargeAccountDto.getAccountId());
				userAccount.setNickName(userRechargeAccountDto.getNickName());
				userAccount.setMobileNumber(userRechargeAccountDto.getMobileNumber());
				userAccount.setTelecomOperatorName(userRechargeAccountDto.getTelecomOperatorName());
				userAccount.setDefaultNumber(userRechargeAccountDto.isDefaultNumber());
				userAccount.setFavNumber(userRechargeAccountDto.isFavNumber());
				
				
				if(userRechargeAccountDto.isDefaultNumber() == true) {
					
					UserRechargeAccount change = userRechargeAccountRepo.findByRechargeUserUserIdAndDefaultNumber(userRechargeAccountDto.getUserId(),userRechargeAccountDto.isDefaultNumber());
					if(change == null) {
					
						UserRechargeAccount userRechargeAccount = userRechargeAccountRepo.save(userAccount);
						
						return accountDto(userRechargeAccount);
					}
					else {		
						
						change.setDefaultNumber(false);
						userRechargeAccountRepo.save(change);
									
						UserRechargeAccount userRechargeAccount = userRechargeAccountRepo.save(userAccount);
						
						return accountDto(userRechargeAccount);
						
					}
					
				}	
				else {
						
					UserRechargeAccount userRechargeAccount = userRechargeAccountRepo.save(userAccount);
						
					return accountDto(userRechargeAccount);
				}
							
			}
			else throw new RuntimeException("Account Id is Not Present...");
	}

	@Override
	public Object deleteAccount(long accountId) {

		UserRechargeAccount userAccount = userRechargeAccountRepo.findByAccountId(accountId);
		if(userAccount !=null) {
			
			userAccount.setStatus(0);
			userRechargeAccountRepo.save(userAccount);
			
			Map<String,String> map = new HashMap<String,String>();
			map.put(" Status ", " Deleted Successfully ");
			
			return map;
			
		}
		else {
			
			Map<String,String> map = new HashMap<String,String>();
			map.put(" Message ", " Account Id is Not Present ");
			
			return map;

		}

		
	}

	@Override
	public List<UserRechargeAccountDto> getAllAccountByUser(long userId) {
		
		RechargeUser checkUser = rechargeUserRepo.findByUserId(userId);
		if(checkUser !=null) {
			
			List<UserRechargeAccount> userAccount = userRechargeAccountRepo.findByRechargeUserUserId(userId);
			
			List<UserRechargeAccountDto> newList = new ArrayList<UserRechargeAccountDto>();
			
			for(UserRechargeAccount account : userAccount) {
				
				UserRechargeAccountDto rechargeaccount = accountDto(account);
				newList.add(rechargeaccount);
				
			}
			
			return newList;
			
		}
		else throw new RuntimeException("User Id is Not Present");
	}

	@Override
	public UserRechargeAccountDto getDefaultNumber(long userId) {

		RechargeUser checkUser = rechargeUserRepo.findByUserId(userId);
		if(checkUser !=null) {
			
			UserRechargeAccount checkDefault = userRechargeAccountRepo.findByRechargeUserUserIdAndDefaultNumber(userId, true);
			if(checkDefault !=null) {
					
				return accountDto(checkDefault);
			}
			else throw new RuntimeException("This user No Default Number");
		
		}
		else throw new RuntimeException("User Id is Not Present");
		
	}

	@Override
	public List<UserRechargeAccountDto> getAllFavNumber(long userId) {

		RechargeUser checkUser = rechargeUserRepo.findByUserId(userId);
		if(checkUser !=null) {
			
			List<UserRechargeAccount> findAccount = userRechargeAccountRepo.findByRechargeUserUserIdAndFavNumber(userId, true);
			if(findAccount !=null) {
				
				List<UserRechargeAccountDto> newList = new ArrayList<UserRechargeAccountDto>();
				
				for(UserRechargeAccount favNumber : findAccount) {
					
					UserRechargeAccountDto accountfav = accountDto(favNumber);
						
					newList.add(accountfav);
				}
			
				return newList;
			}
			else throw new RuntimeException("This user No Favorite Number");
			
		}
		else throw new RuntimeException("User Id is Not Present");
		
	}
}
