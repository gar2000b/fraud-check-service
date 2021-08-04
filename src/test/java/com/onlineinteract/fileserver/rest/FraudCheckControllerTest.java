package com.onlineinteract.fileserver.rest;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class FraudCheckControllerTest {

	private static FraudCheckController fraudCheckController;
	private static final String CUSTOMER_JSON = "{\"Forename\":\"Alex\",\"DOB\":\"22/04/76\",\"Address2\":\"Ingles\",\"SIN\":\"123-456-789\",\"CustomerId\":\"1\",\"Address1\":\"142 Potter Way\",\"City\":\"Surrey\",\"Surname\":\"Beaton\",\"Postcode\":\"SU12 3HG\",\"AccountNumber\":\"12345678\"}";
	private static final String CUSTOMER_FAIL_JSON = "{\"Forename\":\"Alex\",\"DOB\":\"22/04/76\",\"Address2\":\"Ingles\",\"SIN\":\"123-456-789\",\"CustomerId\":\"-1\",\"Address1\":\"142 Potter Way\",\"City\":\"Surrey\",\"Surname\":\"Beaton\",\"Postcode\":\"SU12 3HG\",\"AccountNumber\":\"12345678\"}";

	@BeforeClass
	public static void setup() {
		fraudCheckController = new FraudCheckController();
	}

	@Test
	public void processFraudCheckTest() {
		boolean result = fraudCheckController.processFraudCheck(CUSTOMER_JSON);
		assertEquals(true, result);
	}
	
	@Test
	public void processFraudCheck_Customer_Id_Outside_Range_Test() {
		boolean result = fraudCheckController.processFraudCheck(CUSTOMER_FAIL_JSON);
		assertEquals(false, result);
	}

}
