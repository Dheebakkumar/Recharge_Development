package com.RechargeDevlopment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.RechargeDevlopment.Dao.RechargeOperatorDto;
import com.RechargeDevlopment.Dao.RechargeOrderDto;
import com.RechargeDevlopment.Dao.RechargeUserCategoryDto;
import com.RechargeDevlopment.Dao.RechargeUserDto;
import com.RechargeDevlopment.Dao.RechargeUserPlanVendorDto;
import com.RechargeDevlopment.Dao.UserRechargeAccountDto;
import com.RechargeDevlopment.service.RechargeUserService;

@RestController
@RequestMapping("/user")
public class RechargeUserController {

	@Autowired
	RechargeUserService rechargeUserService;
	
	
	@PostMapping("/add")
	public RechargeUserDto addUser(@RequestBody RechargeUserDto rechargeUserDto) {
	
		return rechargeUserService.addUser(rechargeUserDto);
	}

	@PutMapping("/update")
	public RechargeUserDto updateUser(@RequestBody RechargeUserDto rechargeUserDto) {
		
		return rechargeUserService.updateUser(rechargeUserDto);
	}
	
	@GetMapping("/id/{userId}")
	public RechargeUserDto getByUser(@PathVariable long userId) {
		
		return rechargeUserService.getByUser(userId);
	}
	
	@GetMapping("/operators")
	public List<RechargeOperatorDto> getAllOperators(){
		
		return rechargeUserService.getAllOperators();
	}
	
	
	@GetMapping("/category")
	public List<RechargeUserCategoryDto> getAll(){
		
		return rechargeUserService.getAllCategory();
	}
	
	@GetMapping("/plan/vendorId/{vendorId}/categoryId/{categoryId}")
	public List<RechargeUserPlanVendorDto> getAllPlanVendorAndCategoryId(@PathVariable long vendorId ,@PathVariable long categoryId){
		
		return rechargeUserService.getAllPlanVendorAndCategoryId(vendorId, categoryId);
	}
	
	@GetMapping("/plan/vendorId/{vendorId}")
	public List<RechargeUserPlanVendorDto> getAllPlanByVendorId(@PathVariable long vendorId){
		
		return rechargeUserService.getAllPlanByVendorId(vendorId);
	}
	
	
	@GetMapping("/plan/planId/{planId}")
	public RechargeUserPlanVendorDto getByPlanId(@PathVariable long planId) {
		
		return rechargeUserService.getByPlanId(planId);
	}
	
	@PostMapping("/order/add")
	public RechargeOrderDto addOrder(@RequestBody RechargeOrderDto rechargeOrderDto) {
		
		return rechargeUserService.addOrder(rechargeOrderDto);
	}

	@GetMapping("/order/history/userId/{userId}")
	public List<RechargeOrderDto> userOrderHistory(@PathVariable long userId){
		
		return rechargeUserService.userOrderHistory(userId);
	}

	@GetMapping("/order/orderId/{orderId}")
	public RechargeOrderDto getUserOrderById(@PathVariable long orderId) {
		
		return rechargeUserService.getUserOrderById(orderId);
	}
	
	@PostMapping("/account/add")
	public UserRechargeAccountDto addAccount(@RequestBody UserRechargeAccountDto userRechargeAccountDto) {
		
		return rechargeUserService.addAccount(userRechargeAccountDto);
	}
	
	@PutMapping("/account/update")
	public UserRechargeAccountDto updateAccount(@RequestBody UserRechargeAccountDto userRechargeAccountDto) {
		
		return rechargeUserService.updateAccount(userRechargeAccountDto);
	}

	
	@DeleteMapping("/account/delete/{accountId}")
	public Object deleteAccount(@PathVariable long accountId) {
		
		return rechargeUserService.deleteAccount(accountId);
	}
	
	
	@GetMapping("/account/userId/{userId}")
	public List<UserRechargeAccountDto> getAllAccountByUser(@PathVariable long userId){
		
		return rechargeUserService.getAllAccountByUser(userId);
	}
	
	
	@GetMapping("/account/default/userId/{userId}")
	public UserRechargeAccountDto getDefaultNumber(@PathVariable long userId) {
		
		return rechargeUserService.getDefaultNumber(userId);
	}
	

	@GetMapping("/account/favorite/userId/{userId}")
	public List<UserRechargeAccountDto> getAllFavNumber(@PathVariable long userId){
		
		return rechargeUserService.getAllFavNumber(userId);
	}

}
