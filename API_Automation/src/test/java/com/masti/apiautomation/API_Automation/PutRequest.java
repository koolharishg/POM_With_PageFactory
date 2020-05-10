package com.masti.apiautomation.API_Automation;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutRequest {

	@Test
	public void test1() {
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");

		JSONObject json = new JSONObject();
		json.put("id", "25");
		json.put("title", "bazinga title");
		json.put("author", "Harish Author");

		request.body(json.toJSONString());
		Response resp = request.put("http://localhost:3000/posts/25");
		int code = resp.getStatusCode();
		System.out.println("response code ->" + code);
		Assert.assertEquals(code, 200);

	}
}
