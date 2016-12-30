package com.optimusinfo.azuresearchdemo.service;

import java.util.List;

import com.optimusinfo.azuresearchdemo.domain.AzurePostDocumentResponse;
import com.optimusinfo.azuresearchdemo.domain.AzureSearch;
import com.optimusinfo.azuresearchdemo.domain.User;

/**
 * Service interface for performing operations over User index documents
 * 
 * @author Optimus
 */
public interface UserService {

	/**
	 * This method is used for posting a list of User documents in Azure Search
	 * 
	 * @param users 
	 * 			  List of Model representation of User Index documents to be posted
	 * 
	 * @return List<AzurePostDocumentResponse> List containing Azure post document response
	 */
	List<AzurePostDocumentResponse> saveUser(List<User> users);

	/**
	 * This method is used for performing Azure Search operation over User index based upon the search query
	 * 
	 * @param azureSearchQuery 
	 * 			  Model representation of Azure Search query
	 * 
	 * @return List<User> List containing User index documents
	 */
	List<User> performAzureSearch(AzureSearch azureSearchQuery);

}
