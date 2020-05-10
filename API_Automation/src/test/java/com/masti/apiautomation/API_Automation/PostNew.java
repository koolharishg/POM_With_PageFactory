package com.masti.apiautomation.API_Automation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostNew {

	@Test
	public void postsomething() {
		RequestSpecification rs = RestAssured.given();
		rs.header("Content-Type", "application/json");
		Response resp = rs.delete("http://localhost:3000/posts/109");
		int code = resp.getStatusCode();
		Assert.assertEquals(code, 200);
	}
}
