package com.roadtonerdvana.jtelebot.request;

import java.util.List;

import org.apache.http.message.BasicNameValuePair;

import com.roadtonerdvana.jtelebot.client.RequestType;

public class TelegramRequest {
	private RequestType requestType;
	private List<BasicNameValuePair> parameters;
	
	public TelegramRequest(final RequestType requestType, final List<BasicNameValuePair> parameters){
		this.requestType = requestType;
		this.parameters = parameters;
	}

	public RequestType getRequestType() {
		return requestType;
	}

	public List<BasicNameValuePair> getParameters() {
		/**
		 * TODO:
		 * should we return a copy?
		 * thus making this unmutable ?
		 */
		return parameters;
	}
	
	
	
}
