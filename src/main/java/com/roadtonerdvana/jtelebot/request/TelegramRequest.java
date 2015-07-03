package com.roadtonerdvana.jtelebot.request;

import java.io.File;
import java.util.List;

import org.apache.http.message.BasicNameValuePair;

import com.roadtonerdvana.jtelebot.client.RequestType;

public class TelegramRequest {
	private RequestType requestType;
	private List<BasicNameValuePair> parameters;
	private File file;
	
	public TelegramRequest(final RequestType requestType, final List<BasicNameValuePair> parameters){
		this(requestType,parameters,null);
	}
	
	public TelegramRequest(final RequestType requestType, final List<BasicNameValuePair> parameters, final File file){
		this.requestType = requestType;
		this.parameters = parameters;
		this.file = file;
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
	
	public File getFile(){
		return file;
	}
	
}
