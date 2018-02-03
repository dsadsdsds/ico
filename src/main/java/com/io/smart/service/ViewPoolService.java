package com.io.smart.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.io.smart.model.Joinpoolgetinfo;
import com.io.smart.model.Userinfo;
import com.io.smart.model.Viewpooladminrequest;
import com.io.smart.model.Viewpooladminresponse;
import com.io.smart.model.Viewpoolsuserrequest;
import com.io.smart.model.Viewpoolsuserresponse;

@Service
public class ViewPoolService {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	public Joinpoolgetinfo getpoolinfo(String poolname) {
		Joinpoolgetinfo info = new Joinpoolgetinfo();
		String sql = "SELECT * FROM poolinfo WHERE poolname = ?";
		ColumnMapRowMapper crm = new ColumnMapRowMapper();
		List<Map<String, Object>> results = jdbcTemplate.query(sql, crm, poolname);

		if (results.size() == 0) {
			return null;
		}
		
		int i = 0;
		info.setAdminWallet((String) results.get(i).get("adminwallet"));
		info.setDeadline((String) results.get(i).get("deadline"));
		info.setTypeOfCoin((String) results.get(i).get("typeofcoin"));
		info.setPercentage((double) results.get(i).get("percentage"));
		info.setExpectedBonus((double) results.get(i).get("expectedbonus"));
		info.setExpectedBonusPercent((double) results.get(i).get("expectedbonuspercent"));
//		info.setExpecteddiscount((double) results.get(i).get("expecteddiscount"));
		info.setExpecteddiscount(0);
		info.setExpectedCoinValue((double) results.get(i).get("expectedcoinprice"));
		info.setMinimum((double) results.get(i).get("minimum"));
		info.setMaximum((double) results.get(i).get("maximum"));
		
		return info;

	}

	public Userinfo getpool(Userinfo request) {

		String sql = "SELECT * FROM poolinfo WHERE poolname = ?";
		ColumnMapRowMapper crm = new ColumnMapRowMapper();
		List<Map<String, Object>> results = jdbcTemplate.query(sql, crm, request.getPoolname());

		if (results.size() == 0) {
			return null;
		}
		int i = 0;

		log.info(" eb " + results.get(0).get("expectedbonus"));
		log.info(" eb " + results.get(0).get("expectedbonuspercent"));
		log.info(" eb " + results.get(0).get("expecteddiscount"));

		request.setExpectedbonus((double) results.get(i).get("expectedbonus"));
		if(results.get(0).get("expectedbonuspercent") == null) {
		request.setExpectedbonuspercent(0);	
		}else {
		request.setExpectedbonuspercent((double) results.get(i).get("expectedbonuspercent"));
		}request.setExpecteddiscount((double) results.get(i).get("expecteddiscount"));


		return request;
	}

	public Viewpooladminresponse viewpooladmin(Viewpooladminrequest request) {

		Viewpooladminresponse response = new Viewpooladminresponse();
		ArrayList<Userinfo> uinfo = new ArrayList<Userinfo>();
		response.setUserinfo(uinfo);
		String sql = "SELECT * FROM userinfo WHERE poolname = ?";
		ColumnMapRowMapper crm = new ColumnMapRowMapper();
		List<Map<String, Object>> results = jdbcTemplate.query(sql, crm, request.getPoolName());

		if (results.size() == 0) {
			return null;
		}

		for (int i = 0; i < results.size(); i++) {
			Userinfo newUser = new Userinfo();
			newUser.setAmount((double) results.get(i).get("amount"));
			newUser.setAmountusd((double) results.get(i).get("amountusd"));
			newUser.setExpectedbonus((double) results.get(i).get("expectedbonuspercent"));
			newUser.setExpectedbonuspercent((double) results.get(i).get("expectedbonuspercent"));
			newUser.setExpectedbonus(0);
		//	newUser.setExpecteddiscount((double) results.get(i).get("expecteddiscount"));
			newUser.setNote((String) results.get(i).get("note"));
			newUser.setNumofparticipants((int) results.get(i).get("numofparticipants"));
			newUser.setPoolname((String) results.get(i).get("poolname"));
			newUser.setTimestamputc((String) results.get(i).get("timestamputc"));
			newUser.setTxid((String) results.get(i).get("txid"));
			newUser.setPercentageofpool((double) results.get(i).get("percentageofpool"));
			newUser.setUserwallet((String) results.get(i).get("userwallet"));
			newUser.setUsername((String) results.get(i).get("username"));
			response.getUserinfo().add(newUser);
		}
		return response;
	}

	public Viewpoolsuserresponse viewpooluser(String txId) {

		Viewpoolsuserresponse response = new Viewpoolsuserresponse();
		String sql = "SELECT * FROM userinfo WHERE txid = ?";
		ColumnMapRowMapper crm = new ColumnMapRowMapper();
		List<Map<String, Object>> results = jdbcTemplate.query(sql, crm, txId);

		if (results.size() == 0) {
			return null;
		}
		Userinfo newUser = new Userinfo();
		int i = 0;
		newUser.setAmount((double) results.get(i).get("amount"));
		newUser.setAmountusd((double) results.get(i).get("amountusd"));
		newUser.setExpectedbonus((double) results.get(i).get("expectedbonuspercent"));
		newUser.setExpectedbonuspercent((double) results.get(i).get("expectedbonuspercent"));
//		newUser.setExpecteddiscount((double) results.get(i).get("expecteddiscount"));
		newUser.setExpecteddiscount(0);
		newUser.setNote((String) results.get(i).get("note"));
		newUser.setNumofparticipants((int) results.get(i).get("numofparticipants"));
		newUser.setPoolname((String) results.get(i).get("poolname"));
		newUser.setTimestamputc((String) results.get(i).get("timestamputc"));
		newUser.setTxid((String) results.get(i).get("txid"));
		newUser.setPercentageofpool((double) results.get(i).get("percentageofpool"));
		newUser.setUserwallet((String) results.get(i).get("userwallet"));
		newUser.setUsername((String) results.get(i).get("username"));
		response.setUserinfo(newUser);
		return response;
	}

}
