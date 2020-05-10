package com.masti.apiautomation.API_Automation;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class pegaautoapi {

	@Test
	public void api_automation() {

		Response resp = RestAssured.get(
				"https://samples.openweathermap.org/data/2.5/weather?q=London&appid=a51529fbc07077777b3e3d3db71bda1f");
		System.out.println(resp.getStatusCode());
		System.out.println(resp.getBody().asString());
	}

}
