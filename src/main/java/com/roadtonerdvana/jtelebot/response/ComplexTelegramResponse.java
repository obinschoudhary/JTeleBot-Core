package com.roadtonerdvana.jtelebot.response;

import java.util.Arrays;

import org.codehaus.jackson.annotate.JsonProperty;

import com.roadtonerdvana.jtelebot.response.json.Result;

public class ComplexTelegramResponse<T extends Result> extends TelegramResponse {

	@JsonProperty("result")
	private T[] result;

	public T[] getResult() {
		return result;
	}

	public void setResult(T[] result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "ComplexTelegramResponse [successful=" + isSuccessful()
				+ ", description=" + getDescription() + ", errorCode="
				+ getErrorCode() + ", result=" + Arrays.toString(result) + "]";
	}

}
