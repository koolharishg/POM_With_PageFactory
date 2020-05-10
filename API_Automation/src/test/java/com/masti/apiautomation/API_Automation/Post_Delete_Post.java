package com.masti.apiautomation.API_Automation;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Post_Delete_Post {

	@Test
	public void test1() {

		RequestSpecification rs = RestAssured.given();
		rs.header("Content-Type", "application/json");

		JSONObject json = new JSONObject();
		json.put("id", "99");
		json.put("title", "title 99");
		json.put("author", "author 99");

		rs.body(json.toJSONString());

		Response resp = rs.post("http://localhost:3000/posts");
		int code = resp.getStatusCode();
		Assert.assertEquals(code, 201);
	}
}
