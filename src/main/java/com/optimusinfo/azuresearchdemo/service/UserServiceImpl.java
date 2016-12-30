package com.optimusinfo.azuresearchdemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import com.optimusinfo.azuresearchdemo.domain.AzurePostDocumentResponse;
import com.optimusinfo.azuresearchdemo.domain.AzureSearch;
import com.optimusinfo.azuresearchdemo.domain.Indexes;
import com.optimusinfo.azuresearchdemo.domain.User;
import com.optimusinfo.azuresearchdemo.utils.AzureConnector;
import com.optimusinfo.azuresearchdemo.utils.RestSupport;

/**
 * Service implementation for performing operations over User index documents
 * 
 * @author Optimus
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private AzureConnector azureConnector;
	
	@Autowired
	private RestSupport restSupport;
	
	@Value(value = "${azure_search_url}")
	private String azureSearchUrl;
	
	@Value(value = "${primary_admin_key}")
	private String primaryAdminKey;
	
	@Value(value = "${query_key_optimus}")
	private String queryKeyOptimus;
	
	@Value(value = "${user_index_name}")
	private String userIndexName;
	
	@Value(value = "${search_action_merge_or_upload}")
	private String searchActionMergeOrUpload;
	
	@Value(value = "${post_document_uri}")
	private String postDocumentUri;
	
	@Value(value = "${search_document_uri}")
	private String searchDocumentUri;
	
	@Value(value = "${api_version}")
	private String apiVersion;

	/**
	 * This method is used for performing Azure Search operation over User index based upon the search query
	 * 
	 * @param users 
	 * 			  List of Model representation of User Index documents to be posted
	 * 
	 * @return List<AzurePostDocumentResponse> List containing Azure post document response
	 */
	@Override
	public List<AzurePostDocumentResponse> saveUser(List<User> users) {
		Indexes<User> index = new Indexes<User>();
		
		for (User user : users) {
			user.setSearchAction(searchActionMergeOrUpload);
		}
	
		index.setValue(users);
		
		String url = azureSearchUrl.concat(userIndexName).concat(postDocumentUri).concat("?api-version=").concat(apiVersion);
		
		HttpHeaders headers = new HttpHeaders();
		
		headers.add("Content-Type", "application/json");
		headers.add("api-key",primaryAdminKey);
		
		HttpEntity<Indexes<User>> entity = new HttpEntity<Indexes<User>>(index, headers);
		
		String response = azureConnector.sendRequestToAzure(entity, url, HttpMethod.POST);
		
		Indexes<AzurePostDocumentResponse> responseObj = restSupport.readValueFromString(response, Indexes.class);
		
		return responseObj.getValue();
	}
	
	/**
	 * This method is used for performing Azure Search operation over User index based upon the search query
	 * 
	 * @param azureSearchQuery 
	 * 			  Model representation of Azure Search query
	 * 
	 * @return List<User> List containing User index documents
	 */
	@Override
	public List<User> performAzureSearch(AzureSearch azureSearchQuery) {
		
		String url = azureSearchUrl.concat(userIndexName).concat(searchDocumentUri).concat("?api-version=").concat(apiVersion);

		HttpHeaders headers = new HttpHeaders();
		
		headers.add("Content-Type", "application/json");
		headers.add("api-key", queryKeyOptimus);
		
		HttpEntity<AzureSearch> entity = new HttpEntity<AzureSearch>(azureSearchQuery, headers);
		
		String response = azureConnector.sendRequestToAzure(entity, url, HttpMethod.POST);
		
		Indexes<User> responseObj = restSupport.readValueFromString(response, Indexes.class);
		
		return responseObj.getValue();
	}
}
