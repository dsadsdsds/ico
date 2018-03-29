package com.io.smart.controller;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.io.smart.model.Createpoolrequest;
import com.io.smart.model.Joinpoolgetinfo;
import com.io.smart.model.Joinpoolrequest;
import com.io.smart.model.RegisterWalletModel;
import com.io.smart.model.Status;
import com.io.smart.model.Userinfo;
import com.io.smart.model.Viewpooladminrequest;
import com.io.smart.model.Viewpooladminresponse;
import com.io.smart.model.Viewpoolsuserresponse;
import com.io.smart.model.WalletModel;
import com.io.smart.service.CreatePoolService;
import com.io.smart.service.JoinPoolService;
import com.io.smart.service.RegisterWalletService;
import com.io.smart.service.ViewPoolService;

@RestController
public class Xontroller {

	@Autowired
	private CreatePoolService createPoolService;

	@Autowired
	private JoinPoolService joinPoolService;
	
	@Autowired
	private ViewPoolService viewPoolService;
	
	@Autowired
	private RegisterWalletService registerWalletService;
	
	  private final Logger log = LoggerFactory.getLogger(this.getClass());

	
	/**
	 * POST /items -> Create a new item.
	 */
	@CrossOrigin(origins = "http://ec2-18-218-238-56.us-east-2.compute.amazonaws.com:3000")
	@ResponseBody @RequestMapping(value = "/viewadminpool", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Viewpooladminresponse viewpooladmin(@RequestParam String poolName,
			@RequestParam String password) {
		Viewpooladminrequest request = new Viewpooladminrequest();
		request.setPassword(password);
		request.setPoolName(poolName);
		return viewPoolService.viewpooladmin(request);
	}
	@CrossOrigin(origins = "http://ec2-18-218-238-56.us-east-2.compute.amazonaws.com:3000")
	@ResponseBody @RequestMapping(value = "/viewuserpool", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Viewpoolsuserresponse viewpoolsuser(@RequestParam String txId) {
		return viewPoolService.viewpooluser(txId);
	}
	@CrossOrigin(origins = "http://ec2-18-218-238-56.us-east-2.compute.amazonaws.com:3000")
	@ResponseBody @RequestMapping(value = "/createpool", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Status createpool(@RequestBody Createpoolrequest request) {
		return createPoolService.createpool(request);
	}
	@CrossOrigin(origins = "http://ec2-18-218-238-56.us-east-2.compute.amazonaws.com:3000")
	@ResponseBody @RequestMapping(value = "/joinuserpool", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Status joinpooluser(@RequestBody Joinpoolrequest request) {
		Userinfo uinfo = new Userinfo();
		uinfo.setAmount(request.getAmount());
		uinfo.setNote(request.getNote());
		uinfo.setPoolname(request.getPoolName());
		uinfo.setTxid(request.getTxId());
		uinfo.setUsername(request.getUsername());
		uinfo.setUserwallet(request.getUserWallet());
		log.info("Request: Amount " + request.getAmount() + " Note: " + request.getNote() 
		+ " Poolname " + request.getPoolName() + " Username " + request.getUsername() + " wallet " + request.getUserWallet());
		Userinfo temp = viewPoolService.getpool(uinfo);
		uinfo.setExpectedbonus(temp.getExpectedbonus());
	//	uinfo.setExpectedbonuspercent(temp.getExpectedbonuspercent());
//		uinfo.setExpecteddiscount(temp.getExpecteddiscount());
		
//		uinfo.setAmountusd(33);
		uinfo.setNumofparticipants(5);
		uinfo.setPercentageofpool(10);
		
	    LocalDateTime currentTime = LocalDateTime.now();
		uinfo.setTimestamputc(currentTime + "");
		return joinPoolService.joinpool(uinfo, request.getPin());
	}
	@CrossOrigin(origins = "http://ec2-18-218-238-56.us-east-2.compute.amazonaws.com:3000")
	@RequestMapping(value = "/test", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String test() {
		return "Hello";
	}
	@CrossOrigin(origins = "http://ec2-18-218-238-56.us-east-2.compute.amazonaws.com:3000")
	@ResponseBody @RequestMapping(value = "/viewpoolinfo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Joinpoolgetinfo poolinfo(@RequestParam String poolname, @RequestParam String adminwallet) {
		return viewPoolService.getpoolinfo(poolname, adminwallet);
	}
	
	@CrossOrigin(origins = "http://ec2-18-218-238-56.us-east-2.compute.amazonaws.com:3000")
	@ResponseBody @RequestMapping(value = "/registerwallet", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public WalletModel poolinfo(@RequestBody RegisterWalletModel walletaddress) {
		 return registerWalletService.createpin(walletaddress.getWalletaddress());
	}
	

}