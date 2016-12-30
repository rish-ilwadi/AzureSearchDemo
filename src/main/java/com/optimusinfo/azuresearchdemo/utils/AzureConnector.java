package com.optimusinfo.azuresearchdemo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * This class is used for communicating with Azure Search API's for performing various operations
 * 
 * @author Optimus
 */
@Component
public class AzureConnector {

	@Autowired
	private RestTemplate restTemplate;
	
	/**
	 * This method is used for sending request to Azure Search API's for performing various operations
	 * 
	 * @param entity
	 * 			  HttpEntity object for posting contents to Azure
	 * @param url
	 * 			  URL for Azure Search index
	 * @param requestMethod
	 * 			  HttpRequest method to be used for sending Request
	 * 
	 * @return String containing response from API's
	 */
	public <T> String sendRequestToAzure(HttpEntity<T> entity, String url, HttpMethod requestMethod) {		
		return restTemplate.exchange(url, requestMethod, entity, String.class).getBody();	
	}
}
