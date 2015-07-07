/**
 * 
 * Copyright (C) 2015 Roberto Dominguez Estrada and Juan Carlos Sedano Salas
 *
 * This material is provided "as is", with absolutely no warranty expressed
 * or implied. Any use is at your own risk.
 *
 */
package com.roadtonerdvana.jtelebot.response.json;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class TelegramResponse<T> {

	/**
	 * The response contains a JSON object, which always has a Boolean field
	 * ok and may have an optional String field description with a
	 * human-readable description of the result. If ok equals true, the
	 * request was successful and the result of the query can be found in the
	 * result field.
	 * 
	 * In case of an unsuccessful request, ok equals false and the error is
	 * explained in the description. An Integer error_code field is also
	 * returned, but its contents are subject to change in the future
	 */
	@JsonProperty("ok")
	private Boolean successful;

	@JsonProperty("description")
	private String description;

	@JsonProperty("error_code")
	private Integer errorCode;
	
	@JsonProperty("result")
	private List<T> result;

	public Boolean isSuccessful() {
		return successful;
	}

	public void setSuccessful(final Boolean successful) {
		this.successful = successful;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(final Integer errorCode) {
		this.errorCode = errorCode;
	}


	public List<T> getResult() {
		return result;
	}

	public void setResult(final List<T> result) {
		this.result = result;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((errorCode == null) ? 0 : errorCode.hashCode());
		result = prime * result
				+ ((this.result == null) ? 0 : this.result.hashCode());
		result = prime * result
				+ ((successful == null) ? 0 : successful.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TelegramResponse other = (TelegramResponse) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (errorCode == null) {
			if (other.errorCode != null)
				return false;
		} else if (!errorCode.equals(other.errorCode))
			return false;
		if (result == null) {
			if (other.result != null)
				return false;
		} else if (!result.equals(other.result))
			return false;
		if (successful == null) {
			if (other.successful != null)
				return false;
		} else if (!successful.equals(other.successful))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TelegramResponse [successful=" + successful + ", description="
				+ description + ", errorCode=" + errorCode + ", result="
				+ result + "]";
	}



	
}
