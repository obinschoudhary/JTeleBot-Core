package com.roadtonerdvana.jtelebot.response;

import org.codehaus.jackson.annotate.JsonProperty;

import com.roadtonerdvana.jtelebot.response.json.Result;

public class BasicTelegramResponse<T extends Result> extends TelegramResponse {

	@JsonProperty("result")
	private T result;

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "BasicTelegramResponse [successful=" + isSuccessful()
				+ ", description=" + getDescription() + ", errorCode="
				+ getErrorCode() + ", result=" + result + "]";
	}

}
