package com.RechargeDevlopment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RechargeDevlopment.model.RechargeUser;

public interface RechargeUserRepo extends JpaRepository<RechargeUser, Long> {

	RechargeUser findByUserId(long userId);

	RechargeUser findByEmail(String email);

	RechargeUser findByAadhaarNumber(String adhaarNumber);

}
