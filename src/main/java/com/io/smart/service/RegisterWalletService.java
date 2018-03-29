package com.io.smart.service;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.io.smart.model.WalletModel;

@Service
public class RegisterWalletService {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public WalletModel createpin(String walletAddress) {
		WalletModel wallet = new WalletModel();
		
		String sqlCheck="SELECT * FROM registerwallet WHERE wallet = ?";
		ColumnMapRowMapper crm = new ColumnMapRowMapper();
		List<Map<String, Object>> results = jdbcTemplate.query(sqlCheck, crm, walletAddress.toLowerCase());

		if(results.size() > 0) {
			wallet.setStatus("This wallet has already been register, please register a new wallet.");
			return wallet;
		} 
		
		Random random = new Random();
		int num = random.nextInt(89999999) + 10000000;
		wallet.setPin(num + "");
		wallet.setWalletAddress(walletAddress.toLowerCase());
		
		int success = 0;
		String sqlInsert = "INSERT INTO registerwallet (wallet, pin) " +
				"VALUES (?, ?)";
        success = jdbcTemplate.update(sqlInsert, walletAddress.toLowerCase(), num + "");
         
        if(success == 0) {
        		wallet.setStatus("Failure creating your wallet");
        		return wallet;
        }
		
        wallet.setStatus("You have successfully registered your wallet. Please keep track of your pin. Your pin is: " +
         num);
		return wallet;
	}
		
}
