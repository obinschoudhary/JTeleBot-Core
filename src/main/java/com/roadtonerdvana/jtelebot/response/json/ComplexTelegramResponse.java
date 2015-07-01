package com.roadtonerdvana.jtelebot.response.json;

import java.util.Arrays;

import org.codehaus.jackson.annotate.JsonProperty;

public class ComplexTelegramResponse <T extends Result>{

	@JsonProperty("ok")
	private Boolean successful;
	@JsonProperty("description")
	private String description;
	@JsonProperty("error_code")
	private Integer errorCode;
	@JsonProperty("result")
	private T[] result;
	public Boolean getSuccessful() {
		return successful;
	}
	public void setSuccessful(Boolean successful) {
		this.successful = successful;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}
	public T[] getResult() {
		return result;
	}
	public void setResult(T[] result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "ComplexTelegramResponse [successful=" + successful
				+ ", description=" + description + ", errorCode=" + errorCode
				+ ", result=" + Arrays.toString(result) + "]";
	}
	
	
}
