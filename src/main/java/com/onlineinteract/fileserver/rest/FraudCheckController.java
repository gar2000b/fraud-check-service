package com.onlineinteract.fileserver.rest;

import java.io.IOException;
import java.util.Map;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@EnableAutoConfiguration
public class FraudCheckController {

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "text/plain", value = "/fraudCheck")
	@ResponseBody
	public ResponseEntity<String> fraudCheck(@RequestBody String customer) {
		System.out.println("\nFraud checking customer (with extra fraud checks): " + customer);
		boolean result = processFraudCheck(customer);

		if (result)
			return new ResponseEntity<>("Customer checks out OK", HttpStatus.OK);
		else
			return new ResponseEntity<>("Customer does not check out OK", HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@SuppressWarnings("unchecked")
	protected boolean processFraudCheck(String customerJson) {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, String> customer = null;
		try {
			customer = mapper.readValue(customerJson, Map.class);
		} catch (IOException e) {
			System.out.println("Sorry, there was a problem converting customer json to map");
			return false;
		}

		/**
		 * Simulate additional fraud checks here.
		 */
		Integer customerId = Integer.valueOf(customer.get("CustomerId"));
		if (customerId > 0 && customerId < 100000000) {
			return true;
		}

		return false;
	}
}
