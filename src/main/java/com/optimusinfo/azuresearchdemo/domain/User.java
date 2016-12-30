package com.optimusinfo.azuresearchdemo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Domain class used for representing Azure Search Index
 * 
 * @author Optimus
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({"@search.score", "@search.action", "id", "name", "address", "email", "phone"})
public class User {

	@JsonProperty("@search.action")
	private String searchAction;

	@JsonProperty("@search.score")
	private String searchScore;
	
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("address")
	private String address;
	
	@JsonProperty("email")
	private String email;
	
	@JsonProperty("phone")
	private String phone;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSearchAction() {
		return searchAction;
	}

	public void setSearchAction(String searchAction) {
		this.searchAction = searchAction;
	}
	
	public String getSearchScore() {
		return searchScore;
	}

	public void setSearchScore(String searchScore) {
		this.searchScore = searchScore;
	}
}
