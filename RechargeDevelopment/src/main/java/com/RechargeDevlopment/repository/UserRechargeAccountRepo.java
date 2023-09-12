package com.RechargeDevlopment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.RechargeDevlopment.model.UserRechargeAccount;

public interface UserRechargeAccountRepo extends JpaRepository<UserRechargeAccount, Long> {

	UserRechargeAccount findByRechargeUserUserIdAndDefaultNumber(long userId, boolean defaultNumber);

	UserRechargeAccount findByRechargeUserUserIdAndMobileNumber(long userId, String mobileNumber);
	
	UserRechargeAccount findByAccountId(long accountId);

	List<UserRechargeAccount> findByRechargeUserUserId(long userId);

	List<UserRechargeAccount> findByRechargeUserUserIdAndFavNumber(long userId, boolean favNumber);
}
