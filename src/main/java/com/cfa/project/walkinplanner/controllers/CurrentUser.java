package com.cfa.project.walkinplanner.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/userdetails")

public class CurrentUser {

	public CurrentUser() {
		// TODO Auto-generated constructor stub
	}
	@RequestMapping(value="/getInfo",method = RequestMethod.GET)
	public @ResponseBody String getUsersInfo(){
		  return "Call the Url to get the User  Information!!!!!!!!!";
	}
	@RequestMapping(value="/getCurrentUser",method = RequestMethod.GET)
	public @ResponseBody String getCurrentUser(){
		  
		 return null;
	}

}
