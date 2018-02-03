package com.io.smart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.io.smart.model.Status;
import com.io.smart.model.Userinfo;

@Service
public class JoinPoolService {
	@Autowired
	JdbcTemplate jdbcTemplate;

	public Status joinpool(Userinfo request) {
		Status status = new Status();
		String sqlInsert = "INSERT INTO userinfo(amount, amountusd, expectedbonus, expectedbonuspercent, note, numofparticipants, percentageofpool, txid, userwallet, username, poolname, timestamputc, expecteddiscount) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		int success = 0;
		success = jdbcTemplate.update(sqlInsert, request.getAmount(), request.getAmountusd(), request.getExpectedbonus(),
				request.getExpectedbonuspercent(), request.getNote(), request.getNumofparticipants(),
				request.getPercentageofpool(), request.getTxid(), request.getUserwallet(), request.getUsername(),
				request.getPoolname(), request.getTimestamputc(), request.getExpecteddiscount());
		if(success > 0) {
			status.setStatus("Success");
		} else {
			status.setStatus("Failure");
		}
		return status;
	}
}
