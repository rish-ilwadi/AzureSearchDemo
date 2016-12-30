package com.optimusinfo.azuresearchdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.optimusinfo.azuresearchdemo.domain.AzurePostDocumentResponse;
import com.optimusinfo.azuresearchdemo.domain.AzureSearch;
import com.optimusinfo.azuresearchdemo.domain.User;
import com.optimusinfo.azuresearchdemo.service.UserService;

/**
 * Controller class for performing operations over User index in Azure Search
 * 
 * @author Optimus
 */
@RestController
@RequestMapping("/azuresearch")
public class AzureSearchController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * This method is used for posting a list of User index documents in Azure Search for making them available for searching
	 * 
	 * @param users
	 * 			   List of Model representation of User Index documents to be posted 
	 * 
	 * @return List<AzurePostDocumentResponse> List containing Azure post document response
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/postUser", headers="Content-Type=application/json")
	public List<AzurePostDocumentResponse> postUser(@RequestBody List<User> users) {		
		return userService.saveUser(users);
	}
	
	/**
	 * This method is used for performing Azure Search operation over User index based upon the search query
	 * 
	 * @param azureSearchQuery 
	 * 			  Model representation of Azure Search query
	 * 
	 * @return List<User> List containing User index documents
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/searchUser")
	public List<User> performAzureSearch(@RequestBody AzureSearch azureSearchQuery) {
		return userService.performAzureSearch(azureSearchQuery);
	}
}
