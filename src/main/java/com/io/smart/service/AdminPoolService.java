package com.io.smart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.io.smart.model.Contract;
import com.io.smart.model.Viewpooladminrequest;

/**
 * 
 * @author x
 * I want this to automatically calculate the entire pool into an array
 * and then insert that array into my contract
 * 
 * @param string token address
 */
@Service
public class AdminPoolService {

	@Autowired
	private ViewPoolService viewPoolService;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Contract createContract(String tokenAddress, String password, String poolName) {
		Contract contract = new Contract();
		
		
		Viewpooladminrequest request = new Viewpooladminrequest();
		request.setPassword(password);
		request.setPoolName(poolName);
		viewPoolService.viewpooladmin(request);
		
		
		return contract;
	}
}
