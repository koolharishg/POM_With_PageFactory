package com.masti.apiautomation.API_Automation;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestRestApi {

	@Test
	public void testReponse() {
		Response res = RestAssured.get(
				"https://samples.openweathermap.org/data/2.5/weather?q=London&appid=a51529fbc07077777b3e3d3db71bda1f");
		System.out.println("status code is ->" + res.getStatusCode());
		String body = res.asString();
		System.out.println("body of response is ->" + body);

	}

}
