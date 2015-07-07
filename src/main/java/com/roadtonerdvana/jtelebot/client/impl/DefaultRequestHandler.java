/**
 * 
 * Copyright (C) 2015 Roberto Dominguez Estrada and Juan Carlos Sedano Salas
 *
 * This material is provided "as is", with absolutely no warranty expressed
 * or implied. Any use is at your own risk.
 *
 */
package com.roadtonerdvana.jtelebot.client.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.MessageFormat;

import org.apache.http.Consts;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.message.BasicNameValuePair;

import com.roadtonerdvana.jtelebot.client.RequestHandler;
import com.roadtonerdvana.jtelebot.client.HttpClientFactory;
import com.roadtonerdvana.jtelebot.mapper.json.MapperHandler;
import com.roadtonerdvana.jtelebot.request.TelegramRequest;
import com.roadtonerdvana.jtelebot.response.json.TelegramResponse;

public class DefaultRequestHandler implements RequestHandler {

	// TODO This should be in a CommonConstants class
	private static final String URL_TEMPLATE = "https://api.telegram.org/bot{0}/{1}";

	private HttpClient httpClient;
	private String token;

	public DefaultRequestHandler() {
		httpClient = HttpClientFactory.createHttpClient();
	}

	public DefaultRequestHandler(final String token) {
		this();
		this.token = token;
	}

	@Override
	public TelegramResponse<?> sendRequest(TelegramRequest telegramRequest) {
		TelegramResponse<?> telegramResponse = null;
		final String response = callHttpService(telegramRequest);

		telegramResponse = parseJsonResponse(response, telegramRequest
				.getRequestType().getResultClass());

		return telegramResponse;
	}

	private String callHttpService(TelegramRequest telegramRequest) {
		final String url = MessageFormat.format(URL_TEMPLATE, token,
				telegramRequest.getRequestType().getMethodName());

		final HttpPost request = new HttpPost(url);
		if (telegramRequest.getFile() != null) {
			final MultipartEntityBuilder mpeb = MultipartEntityBuilder.create();
			mpeb.addBinaryBody(telegramRequest.getFileType(),
					telegramRequest.getFile());
			for (BasicNameValuePair bnvp : telegramRequest.getParameters()) {
				mpeb.addTextBody(bnvp.getName(), bnvp.getValue());
			}
			request.setEntity(mpeb.build());
		} else {
			request.setEntity(new UrlEncodedFormEntity(telegramRequest
					.getParameters(), Consts.UTF_8));
		}
		try {
			final HttpResponse response = httpClient.execute(request);

			BufferedReader reader = new BufferedReader(new InputStreamReader(
					response.getEntity().getContent()));

			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = reader.readLine()) != null) {
				result.append(line);
			}

			if (response.getStatusLine().getStatusCode() != 200) {
				System.err.println("Request to Telegram failed!");
				/**
				 * TODO: should we throw an exception?
				 */
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
			final Class<?> resultTypeClass) {
		try {

			final TelegramResponse<?> telegramResponse = (TelegramResponse<?>) MapperHandler.INSTANCE
					.getObjectMapper().readValue(
							jsonResponse,
							MapperHandler.INSTANCE
									.getObjectMapper()
									.getTypeFactory()
									.constructParametricType(
											TelegramResponse.class,
											resultTypeClass));

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
