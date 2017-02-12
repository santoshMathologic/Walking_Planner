package com.cfa.project.walkinplanner.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cfa.project.walkinplanner.repository.UserRepository;


@RestController
@RequestMapping("/api/v1/userdetails")

public class CurrentUser {

	
	 @Autowired
	 UserRepository userRepository;
	public CurrentUser() {
	}
	@RequestMapping(value="/getInfo",method = RequestMethod.GET)
	public @ResponseBody String getUsersInfo(){
		  return "Call the Url to get the User  Information!!!!!!!!!";
	}
	@RequestMapping(value="/getCurrentUser",method = RequestMethod.GET)
	public @ResponseBody com.cfa.project.walkinplanner.models.User getCurrentUser(){
		UserDetails userDetails = null;
		com.cfa.project.walkinplanner.models.User user = null;
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	if (!(auth instanceof AnonymousAuthenticationToken)) {
    		userDetails = (UserDetails)auth.getPrincipal();
    	}
    	if(userDetails!=null) {
    		com.cfa.project.walkinplanner.models.User databaseUser = userRepository.findByUsernameAndIsActive(userDetails.getUsername(),true);
    		if(databaseUser!=null){
    			user = new com.cfa.project.walkinplanner.models.User();
    		  
    			user.setActivationKey(databaseUser.getActivationKey());
    			user.setEmail(databaseUser.getEmail());
    			user.setEmployeeNo(databaseUser.getEmployeeNo());
    			user.setExtension(databaseUser.getExtension());
    			user.setFirstName(databaseUser.getFirstName());
    			user.setIsActive(databaseUser.getIsActive());
    			user.setLastName(databaseUser.getLastName());
    			user.setMobileNo(databaseUser.getMobileNo());
    			user.setPassword(databaseUser.getPassword());
    			user.setRole(databaseUser.getRole());
    			user.setTelephoneNo(databaseUser.getTelephoneNo());
    			user.setUsername(databaseUser.getUsername());
    			
    			
    			
    		}
    		
    	}
        
		 return user;
	}

}
