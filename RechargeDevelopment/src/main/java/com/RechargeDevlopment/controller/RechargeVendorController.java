package com.RechargeDevlopment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RechargeDevlopment.Dao.ConfigRechargeCategoryDto;
import com.RechargeDevlopment.Dao.RechargeBalanceDto;
import com.RechargeDevlopment.Dao.RechargeOrderDto;
import com.RechargeDevlopment.Dao.RechargePlanDto;
import com.RechargeDevlopment.Dao.RechargeVendorDto;
import com.RechargeDevlopment.service.RechargeVendorService;

@RestController
@RequestMapping("/vendor")
public class RechargeVendorController {
	
	@Autowired
	RechargeVendorService rechargeVendorService;
	

	@PostMapping("/add")
	public RechargeVendorDto addVendor(@RequestBody RechargeVendorDto rechargeVendorDto) {
		
		return rechargeVendorService.addVendor(rechargeVendorDto);
		
	}
	
	@GetMapping("/{vendorId}")
	public RechargeVendorDto getIdByVendor(@PathVariable long vendorId) {
		
		return rechargeVendorService.getIdByVendor(vendorId);
		
	}
	
	@PutMapping("/update")
	public RechargeVendorDto updateVendor(@RequestBody RechargeVendorDto rechargeVendorDto) {
		
		return rechargeVendorService.updateVendor(rechargeVendorDto);
	
	}
	
	@GetMapping("/balance/{vendorId}")
	public RechargeBalanceDto getBalanceId(@PathVariable long vendorId) {
		
		return rechargeVendorService.getBalanceId(vendorId);
	}
	
	
	
	@GetMapping("/allCat")
	public List<ConfigRechargeCategoryDto> getAllCategory() {
	
		return rechargeVendorService.getAll();
	}

	@PostMapping("/addCat")
	public ConfigRechargeCategoryDto addCategory(@RequestBody ConfigRechargeCategoryDto configRechargeCategoryDto) {
		
		return rechargeVendorService.addCategory(configRechargeCategoryDto);
	}
	
	@PostMapping("/addPlan")
	public RechargePlanDto addPlan(@RequestBody RechargePlanDto rechargePlanDto) {
		
		return rechargeVendorService.addPlan(rechargePlanDto);
	}
	
	@PutMapping("/updatePlan")
	public RechargePlanDto updatePlan(@RequestBody RechargePlanDto rechargePlanDto) {
		
		return rechargeVendorService.updatePlan(rechargePlanDto);
	}
	
	@GetMapping("/plan/{planId}")
	public RechargePlanDto getIdByPlanId(@PathVariable long planId) {
		
		return rechargeVendorService.getByPlanId(planId);
		
	}
	
	@GetMapping("/plan/vId/{vendorId}")
	public List<RechargePlanDto> getAllPlanByVendorId(@PathVariable long vendorId) {
		
		return rechargeVendorService.getAllPlanByVendorId(vendorId);
		
	}
	
	@GetMapping("/order/history/vendorId/{vendorId}")
	public List<RechargeOrderDto> vendorHistory(@PathVariable long vendorId){
		
		return rechargeVendorService.vendorHistory(vendorId);
	}
	
	@GetMapping("/order/history/plan/{planId}")
	public List<RechargeOrderDto> vendorRechargePlanHistory(@PathVariable long planId){
		
		return rechargeVendorService.vendorRechargePlanHistory(planId);
	}
	
	@GetMapping("/order/history/category/{categoryId}")
	public List<RechargeOrderDto> vendorRechargeCategoryHistory(@PathVariable long categoryId){
		
		return rechargeVendorService.vendorRechargeCategoryHistory(categoryId);
	}
	
	
	@GetMapping("/order/orderId/{orderId}")
	public RechargeOrderDto getVendorOrderId(@PathVariable long orderId) {
		
		return rechargeVendorService.getVendorOrderId(orderId);
	}

}
