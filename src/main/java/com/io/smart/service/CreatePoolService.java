package com.io.smart.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.io.smart.model.Createpoolrequest;
import com.io.smart.model.Status;


@Service
public class CreatePoolService {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());


	public Status createpool(Createpoolrequest request) {
		
		Status status = new Status();
		
		String sqlCheck="SELECT * FROM poolinfo WHERE poolname = ?";
		ColumnMapRowMapper crm = new ColumnMapRowMapper();
		List<Map<String, Object>> results = jdbcTemplate.query(sqlCheck, crm, request.getPoolName().toLowerCase());

		if (results.size() > 0) {
			
			status.setStatus("This pool name already exists in our system. Please create another, or view your pool in pool admin");
			return status;
		}
		
		
		
		log.info("poolname " + request.getPoolName().toLowerCase());
		log.info("deadline " + request.getDeadline());
		log.info("adminwallet " + request.getAdminWallet());
		log.info("typeofcoin " + request.getTypeOfCoin());
		log.info("percentage " + request.getPercentage());
		log.info("expectedbonus " + request.getExpectedBonus());
		log.info("expecteddiscount" + request.getExpectedDiscount());
		log.info("expectedcoinprice " + request.getExpectedCoinPrice());
		log.info("minimum " + request.getMinimum());
		log.info("max" + request.getMaximum());

		
		int success = 0;
		String sqlInsert = "INSERT INTO poolinfo (poolname, deadline, adminwallet, typeofcoin, percentage, password, " + 
				"expectedbonus, expecteddiscount, expectedcoinprice, minimum, maximum) " +
				"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        success = jdbcTemplate.update(sqlInsert, request.getPoolName().toLowerCase(), request.getDeadline(), request.getAdminWallet().toLowerCase(), request.getTypeOfCoin(),
        		 request.getPercentage(), request.getPassword(), request.getExpectedBonus(), request.getExpectedDiscount(), 
        		 request.getExpectedCoinPrice(), request.getMinimum(), request.getMaximum());
         
		if(success > 0) {
			status.setStatus("Your pool creation resulted in a Success"); 
		} else {
			status.setStatus("Your pool creation resulted in a Failure");
		}
		return status;
	}

}
