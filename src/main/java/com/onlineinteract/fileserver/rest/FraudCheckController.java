package com.onlineinteract.fileserver.rest;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class FraudCheckController {

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "text/plain", value = "/fraudCheck")
	@ResponseBody
	public ResponseEntity<String> fraudCheck(@RequestBody String customer) {
		System.out.println("\nFraud checking customer (with extra fraud checks): " + customer);
		return new ResponseEntity<>("Customer checks out OK", HttpStatus.OK);
	}
}
