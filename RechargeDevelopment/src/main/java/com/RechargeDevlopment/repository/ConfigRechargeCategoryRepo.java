package com.RechargeDevlopment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.RechargeDevlopment.model.ConfigRechargeCategory;

public interface ConfigRechargeCategoryRepo extends JpaRepository<ConfigRechargeCategory, Long>{

	ConfigRechargeCategory findByCategoryName(String categoryName);

	ConfigRechargeCategory findById(long categoryId);

	ConfigRechargeCategory findByCategoryId(long categoryId);
}
