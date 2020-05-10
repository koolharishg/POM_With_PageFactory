package com.masti.apiautomation.API_Automation;

import java.io.IOException;

import org.testng.annotations.Test;

import com.example.Employees;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class EmployeesList {

	@Test
	public void getEmployeesList() throws JsonParseException, JsonMappingException, IOException {

		Response res = RestAssured.get("http://dummy.restapiexample.com/api/v1/employees");

		String body = res.getBody().asString();
		System.out.println(body);

		ObjectMapper mapper = new ObjectMapper();
		Employees user = mapper.readValue(body, Employees.class);
		System.out.println(user.getData().get(1).getEmployeeName());

//		ObjectMapper mapper = new ObjectMapper();
//		Employees user = mapper.readValue(body, Employees.class);
//		System.out.println(user.getData().get(0).getEmployeeSalary());

	}

}
