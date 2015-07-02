package com.roadtonerdvana.jtelebot.client.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.MessageFormat;
import java.util.List;

import org.apache.http.Consts;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;

import com.roadtonerdvana.jtelebot.client.BotRequestHandler;
import com.roadtonerdvana.jtelebot.client.HttpClientFactory;
import com.roadtonerdvana.jtelebot.client.RequestType;
import com.roadtonerdvana.jtelebot.mapper.json.MapperHandler;
import com.roadtonerdvana.jtelebot.response.json.TelegramResponse;
import com.roadtonerdvana.jtelebot.response.json.Update;
import com.roadtonerdvana.jtelebot.response.json.User;

public class DefaultBotRequestHandler implements BotRequestHandler {

	// TODO This should be in a CommonConstants class
	private static final String URL_TEMPLATE = "https://api.telegram.org/bot{0}/{1}";

	private HttpClient httpClient;
	private String token;

	public DefaultBotRequestHandler() {
		httpClient = HttpClientFactory.createHttpClient();
	}

	public DefaultBotRequestHandler(final String token) {
		this();
		this.token = token;
	}

	@Override
	public String sendRequest(final RequestType requestType,
			final List<BasicNameValuePair> parameters) {
		TelegramResponse<?> telegramResponse = null;
		String json = callHttpService(requestType.getMethodName(), parameters);
		telegramResponse = parseJsonResponse(json,
					TelegramResponse.class, requestType.getResultClass());

		/**
		 * the switch is gone, aint that pretty?
		 */


		if (telegramResponse != null) {
			return telegramResponse.toString();
		}
		
		return null;
	}

	private String callHttpService(final String methodName,
			final List<BasicNameValuePair> parameters) {
		final String url = MessageFormat
				.format(URL_TEMPLATE, token, methodName);
		// System.out.println("About to send: " + url);

		final HttpPost request = new HttpPost(url);
		request.setEntity(new UrlEncodedFormEntity(parameters, Consts.UTF_8));

		try {
			final HttpResponse response = httpClient.execute(request);

			BufferedReader reader = new BufferedReader(new InputStreamReader(
					response.getEntity().getContent()));

			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = reader.readLine()) != null) {
				result.append(line);
			}

			return result.toString();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	// TODO This method should be implemented in a ResponseParser class
	private TelegramResponse<?> parseJsonResponse(final String jsonResponse,
			final Class responseClass, final Class resultTypeClass) {
		try {

			TelegramResponse<?> telegramResponse = null;

			telegramResponse = (TelegramResponse<?>) MapperHandler.INSTANCE.getObjectMapper().readValue(
						jsonResponse,
						MapperHandler.INSTANCE.getObjectMapper().getTypeFactory().constructParametricType(
								responseClass, resultTypeClass));



			
			System.out.println("TelegramResponse: \n" + telegramResponse);
			return telegramResponse;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
