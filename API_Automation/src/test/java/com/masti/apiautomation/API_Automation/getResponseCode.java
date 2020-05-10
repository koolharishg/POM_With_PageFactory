package com.masti.apiautomation.API_Automation;

import static io.restassured.RestAssured.get;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class getResponseCode {

	@Test
	public void testResponseCode() {
		Response resp = get(
				"https://samples.openweathermap.org/data/2.5/weather?q=London&appid=a51529fbc07077777b3e3d3db71bda1f");
		int code = resp.getStatusCode();
		System.out.println("status code is ->" + code);
		Assert.assertEquals(code, 200);
	}

	@Test
	public void testBody() {

		Response resp = get(
				"https://samples.openweathermap.org/data/2.5/weather?q=London&appid=a51529fbc07077777b3e3d3db71bda1f");

		String data = resp.asString();
		System.out.println("Data is ->" + data);
		System.out.println("Response time is ->" + resp.getTime());
	}
}
