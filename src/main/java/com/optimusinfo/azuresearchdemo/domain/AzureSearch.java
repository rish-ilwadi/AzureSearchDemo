package com.optimusinfo.azuresearchdemo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Domain class used for representing Azure Search response
 * 
 * @author Optimus
 *
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({"search", "select", "filter", "orderby", "top"})
public class AzureSearch {
	
	@JsonProperty("search")
	private String search;
	
	@JsonProperty("select")
	private String select;
	
	@JsonProperty("filter")
	private String filter;
	
	@JsonProperty("orderby")
	private String orderby;
	
	@JsonProperty("top")
	private Integer top;

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getSelect() {
		return select;
	}

	public void setSelect(String select) {
		this.select = select;
	}

	public String getFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}

	public String getOrderby() {
		return orderby;
	}

	public void setOrderby(String orderby) {
		this.orderby = orderby;
	}

	public Integer getTop() {
		return top;
	}

	public void setTop(Integer top) {
		this.top = top;
	}
}
