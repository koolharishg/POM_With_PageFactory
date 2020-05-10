package com.masti.apiautomation.API_Automation;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ParseRespo {

	@Test
	public void parseResponse() throws ParseException, IOException {

		RestAssured rs = new RestAssured();
		Response resp = rs.get("http://dummy.restapiexample.com/api/v1/employees");
		String str = resp.body().asString();

		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(str);
		FileWriter file = new FileWriter("C:\\Users\\ghorh\\Documents\\seleniumbazinga\\json string\\baz.json");
		file.write(json.toJSONString());
		file.close();

	}

}
