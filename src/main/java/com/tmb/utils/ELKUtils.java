/**
 * 
 */
package com.tmb.utils;

import static io.restassured.RestAssured.given;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;

import com.tmb.enums.ConfigProperties;

import io.restassured.response.Response;

/**
 * Mar 11, 2023 
 * @author Thrinath K
 * @version 1.0
 * @since 1.0
 */
public class ELKUtils {

	/**
	 * Private constructor to avoid external instantiation
	 */
	private ELKUtils() {}

	/**
	 * Constructs the document that needs to be injected to Elasticsearch using Map interface.
	 * Can also use a POJO to construct the json
	 * 
	 * @author Thrinath Kl
	 * Mar 20, 2023
	 * @param testname
	 * @param status
	 */
	public static void sendDetailsToElk(String testname,String status) {

		if(PropertyUtils.get(ConfigProperties.SENDRESULTTOELK).equalsIgnoreCase("yes")) {
			Map<String,String> map = new HashMap<>();
			map.put("testName",testname );
			map.put("status" , status);
			map.put("executionTime", LocalDateTime.now().toString());

			Response response = given().header("Content-Type","application/json")
					.log()
					.all()
					.body(map)
					.post(PropertyUtils.get(ConfigProperties.ELASTICURL));

			Assert.assertEquals(response.statusCode(), 201);

			response.prettyPrint();
		}
	}

}
