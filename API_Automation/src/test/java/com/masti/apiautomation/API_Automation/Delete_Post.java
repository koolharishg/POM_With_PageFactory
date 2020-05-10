package com.masti.apiautomation.API_Automation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Delete_Post {

	@Test
	public void test1() {
		RequestSpecification request = RestAssured.given();

		Response resp = request.delete("http://localhost:3000/posts/99");
		int code = resp.getStatusCode();
		Assert.assertEquals(code, 200);

	}
}
