/**
 * 
 * Copyright (C) 2015 Roberto Dominguez Estrada and Juan Carlos Sedano Salas
 *
 * This material is provided "as is", with absolutely no warranty expressed
 * or implied. Any use is at your own risk.
 *
 */
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
