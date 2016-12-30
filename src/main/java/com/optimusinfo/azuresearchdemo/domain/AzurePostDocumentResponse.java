package com.optimusinfo.azuresearchdemo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Domain class used for representing Azure Post Document response
 * 
 * @author Optimus
 *
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({"key", "status", "errorMessage", "errorCode"})
public class AzurePostDocumentResponse {
	
	@JsonProperty("key")
	private String key;
	
	@JsonProperty("status")
	private String status;
	
	@JsonProperty("errorMessage")
	private String errorMessage;
	
	@JsonProperty("errorCode")
	private Integer errorCode;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
