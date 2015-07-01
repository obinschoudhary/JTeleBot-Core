package com.roadtonerdvana.jtelebot.motor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import com.roadtonerdvana.jtelebot.response.json.TelegramResponse;
import com.roadtonerdvana.jtelebot.response.json.User;

public class ConnectionTest {

	@Test
	public void test() throws ClientProtocolException, IOException{
		String token =  "put token here ";
		String method = "getMe";
		String url = "https://api.telegram.org/"+token+"/"+method;
		 
		HttpClient client = HttpClientBuilder.create().build();
		HttpPost request = new HttpPost(url);
		
		// add request header
		HttpResponse response = client.execute(request);
	 

	 
		BufferedReader rd = new BufferedReader(
			new InputStreamReader(response.getEntity().getContent()));
	 
		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		ObjectMapper mapper = new ObjectMapper();
		System.out.println(result.toString());
		TelegramResponse <User>telegramResponse = mapper.readValue(result.toString(), mapper.getTypeFactory().constructParametricType(TelegramResponse.class, User.class));

		System.out.println(telegramResponse);
	}
}
