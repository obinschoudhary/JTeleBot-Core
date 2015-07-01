package com.roadtonerdvana.jtelebot.motor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.HttpEntityWrapper;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import com.roadtonerdvana.jtelebot.response.json.ComplexTelegramResponse;
import com.roadtonerdvana.jtelebot.response.json.GroupChat;
import com.roadtonerdvana.jtelebot.response.json.Message;
import com.roadtonerdvana.jtelebot.response.json.ReplyKeyboardMarkup;
import com.roadtonerdvana.jtelebot.response.json.TelegramResponse;
import com.roadtonerdvana.jtelebot.response.json.Update;
import com.roadtonerdvana.jtelebot.response.json.User;

public class ConnectionTest {

	@Test
	public void testSendMessage() throws ClientProtocolException, IOException{
		String token =  "bot";
		String method = "sendMessage";
		String url = "https://api.telegram.org/"+token+"/"+method;
		 
		HttpClient client = HttpClientBuilder.create().build();
		HttpPost request = new HttpPost(url);
		
		ObjectMapper mapper = new ObjectMapper();

		
		List <BasicNameValuePair> nvps = new ArrayList <BasicNameValuePair>();
        nvps.add(new BasicNameValuePair("chat_id", "-7155093"));
        nvps.add(new BasicNameValuePair("text", "hi you"));
        ReplyKeyboardMarkup keyboard = new ReplyKeyboardMarkup();
        keyboard.setKeyboard(new String[][]{{"yes","double yes"},{"no"},{"robert"}});
        keyboard.setOneTimeKeyboard(false);
        keyboard.setResizeKeyboard(false);
        keyboard.setSelective(false);
        nvps.add(new BasicNameValuePair("reply_markup",mapper.writeValueAsString(keyboard)));
        UrlEncodedFormEntity uefe = new UrlEncodedFormEntity(nvps, Consts.UTF_8);
        request.setEntity(uefe);

		// add request header
		HttpResponse response = client.execute(request);
	 

	 
		BufferedReader rd = new BufferedReader(
			new InputStreamReader(response.getEntity().getContent()));
	 
		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		TelegramResponse <Message>telegramResponse = mapper.readValue(result.toString(), mapper.getTypeFactory().constructParametricType(TelegramResponse.class, Message.class));

		System.out.println(telegramResponse);

	}
	
	@Test
	public void testUpdate() throws ClientProtocolException, IOException{
		String token =  "bot";
		String method = "getUpdates";
		String url = "https://api.telegram.org/"+token+"/"+method;
		 
		HttpClient client = HttpClientBuilder.create().build();
		HttpPost request = new HttpPost(url);
		
		List <BasicNameValuePair> nvps = new ArrayList <BasicNameValuePair>();
        nvps.add(new BasicNameValuePair("offset", "0"));
        nvps.add(new BasicNameValuePair("limit", "100"));
        nvps.add(new BasicNameValuePair("timeout", "0"));

        UrlEncodedFormEntity uefe = new UrlEncodedFormEntity(nvps, Consts.UTF_8);
        request.setEntity(uefe);

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
		ComplexTelegramResponse <Update>telegramResponse = mapper.readValue(result.toString(), mapper.getTypeFactory().constructParametricType(ComplexTelegramResponse.class, Update.class));

		System.out.println(telegramResponse);

	}
	
	@Test
	public void test() throws ClientProtocolException, IOException{
		String token =  "bot";
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
		TelegramResponse <User>telegramResponse = mapper.readValue(result.toString(), mapper.getTypeFactory().constructParametricType(TelegramResponse.class, User.class));

		System.out.println(telegramResponse);
	}
}
