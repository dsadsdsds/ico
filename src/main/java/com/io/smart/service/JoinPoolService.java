package com.io.smart.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.io.smart.model.Status;
import com.io.smart.model.Txcheck;
import com.io.smart.model.Userinfo;

@Service
public class JoinPoolService {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Status joinpool(Userinfo request, String pin) {
		Status status = new Status();
		String adminWallet = "";


		// check if txid already exist
		String sqlCheck = "SELECT * FROM userinfo WHERE txid = ?";
		ColumnMapRowMapper crm = new ColumnMapRowMapper();
		List<Map<String, Object>> results = jdbcTemplate.query(sqlCheck, crm, request.getTxid().toLowerCase());

		if (results.size() > 0) {

			status.setStatus("This transaction id already exists in our system");
			return status;
		}

		// check if poolname is valid can remove once fix html
		String sqlCheck1 = "SELECT * FROM poolinfo WHERE poolname = ?";
		ColumnMapRowMapper crm1 = new ColumnMapRowMapper();
		List<Map<String, Object>> results1 = jdbcTemplate.query(sqlCheck1, crm1, request.getPoolname().toLowerCase());

		if (results1.size() == 0) {
			status.setStatus("This Pool Name is invalid");
			return status;
		} else {
			adminWallet = (String) results1.get(0).get("adminwallet");
		}

		// validate txid is cool

		Txcheck tx = txcheck(request.getTxid().toLowerCase(), request.getUserwallet().toLowerCase(), adminWallet.toLowerCase(), pin);
		if (!tx.isStatus()) {
			status.setStatus("Your transaction id did not pass validation");
			return status;
		}
		if(tx.isInvalidPin()) {
			status.setStatus("Your pin was invalid, please type in the correct 8-digit pin, or register your wallet you SENT funds with.");
			return status;
		}
		request.setAmount(tx.getActualAmount());

		// actual joining of the pool
		String sqlInsert = "INSERT INTO userinfo(amount, amountusd, expectedbonus, expectedbonuspercent, note, numofparticipants, percentageofpool, txid, userwallet, username, poolname, timestamputc, expecteddiscount) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		int success = 0;
		success = jdbcTemplate.update(sqlInsert, request.getAmount(), request.getAmountusd(),
				request.getExpectedbonus(), request.getExpectedbonuspercent(), request.getNote(),
				request.getNumofparticipants(), request.getPercentageofpool(), request.getTxid().toLowerCase(),
				request.getUserwallet().toLowerCase(), request.getUsername(), request.getPoolname().toLowerCase(), request.getTimestamputc(),
				request.getExpecteddiscount());
		if (success > 0) {
			status.setStatus("Your transaction id confirmation resulted in a Success. You have joined the pool.");
		} else {
			status.setStatus("Failure");
		}
		return status;
	}

	public Txcheck txcheck(String txid, String userWallet, String adminWallet, String pin) {
		Txcheck tx = new Txcheck();
		tx.setStatus(false);
		tx.setInvalidPin(false);
		RestTemplate restTemplate = new RestTemplate();
		String fooResourceUrl = "https://api.etherscan.io/api?module=proxy&action=eth_getTransactionByHash&txhash="
				+ txid + "&apikey=Z6NJ6A3NUGDBD22RNRQMHW3B6DARA77624";
		ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl, String.class);

		// verify sender
		String validateSender = "";
		String sender = response.getBody();
		int i = sender.indexOf("from");
		sender = sender.substring(i);
		i = sender.indexOf("0x");
		sender = sender.substring(i);
		i = sender.indexOf('"');
		validateSender = sender.substring(0, i).toLowerCase();
		

		// verify receiver
		String receiver = response.getBody();
		int j = receiver.indexOf("to");
		receiver = receiver.substring(j);
		j = receiver.indexOf("0x");
		receiver = receiver.substring(j);
		j = receiver.indexOf('"');
		receiver = receiver.substring(0, j);
		if (!receiver.equalsIgnoreCase(adminWallet)) {
			tx.setStatus(false);
			return tx;
		}

		// get actual value
		String value = response.getBody();
		int index = value.indexOf("value");
		value = value.substring(index);
		index = value.indexOf("0x");
		value = value.substring(index);
		index = value.indexOf('"');
		value = value.substring(0, index);

		BigInteger bigInt = new BigInteger(value.substring(2), 16);
		BigDecimal bigD = new BigDecimal(bigInt);
		BigDecimal eighteen = new BigDecimal(1e18);
		BigDecimal end = bigD.divide(eighteen, 8, RoundingMode.FLOOR); 
		double amount = end.doubleValue();


		tx.setActualAmount(amount);
		tx.setStatus(true);

		if(!validatePin(validateSender, pin)) {
			tx.setInvalidPin(true);
		}
		
		return tx;
	}

	public boolean validatePin(String wallet, String pin) {
		
		String walletCheck = "SELECT * FROM registerwallet WHERE wallet = ? AND pin = ?";
		ColumnMapRowMapper crmWallet = new ColumnMapRowMapper();
		List<Map<String, Object>> resultsWallet = jdbcTemplate.query(walletCheck, crmWallet,
				wallet.toLowerCase(), pin);

		if (resultsWallet.size() == 0) {
			return false;
		}
		
		return true;
		
	}
	

}
