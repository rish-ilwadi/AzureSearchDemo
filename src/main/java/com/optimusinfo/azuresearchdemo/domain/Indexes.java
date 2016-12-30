package com.optimusinfo.azuresearchdemo.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Domain class used as a part of Azure requests and Responses
 * 
 * @author Optimus
 *
 * @param <T>
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({"@odata.context", "value"})
public class Indexes<T> {
	
	@JsonProperty("@odata.context")
	private String odataContext;
	
	@JsonProperty("value")
	private List<T> value;

	public List<T> getValue() {
		return value;
	}

	public void setValue(List<T> value) {
		this.value = value;
	}
	
	public String getOdataContext() {
		return odataContext;
	}

	public void setOdataContext(String odataContext) {
		this.odataContext = odataContext;
	}

}
