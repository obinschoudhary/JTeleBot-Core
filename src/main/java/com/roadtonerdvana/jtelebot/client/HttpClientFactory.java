package com.roadtonerdvana.jtelebot.client;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public final class HttpClientFactory {

	private HttpClientFactory() {
	}

	public static HttpClient createHttpClient() {
		return HttpClientBuilder.create().build();
	}

}
