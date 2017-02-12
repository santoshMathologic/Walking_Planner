package com.cfa.project.walkinplanner.controllers;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cfa.project.walkinplanner.repository.UserPlanRepository;
import com.cfa.project.walkinplanner.models.*;


@RestController
@RequestMapping("/api/v1/userPlan")
public class UserPlanController {

	  @Autowired
	  UserPlanRepository userPlanRepository;
	  
	public UserPlanController() {
		// TODO Auto-generated constructor stub
	}

	 @RequestMapping(value="/getUserPlanInfo", method= RequestMethod.GET)
	    public @ResponseBody String provideUploadInfo() {
	        return "You can upload a file by posting to this same URL.";
	    }
	
	 @RequestMapping(value="/saveUserPlan", method= RequestMethod.POST)
	   public @ResponseBody String saveUserPlan(@RequestBody UserPlan userPlan) {
		 
		 	
		       if(userPlan != null){
		    	   		userPlanRepository.save(userPlan);
		       }
		 		return "UserPlan has been saved Successfully";
		        
	    }
	
	 
	 
	 @RequestMapping(value="/getUserPlan", method= RequestMethod.GET)
	    public @ResponseBody Page<com.cfa.project.walkinplanner.models.UserPlan> getUserPlan(
	    		@PathParam("planName") String planName,
	    		@PathParam("limit")int limit,
	    		@PathParam("page") int page
	    		) {
	        
		 final PageRequest page1 = new PageRequest(page, limit, Direction.ASC, "planName");
		 
		
		 	
		     
		 		Page<com.cfa.project.walkinplanner.models.UserPlan> userPlanLists = userPlanRepository.findAll(page1);
		        return userPlanLists ;
	    }
	 
	 @RequestMapping(value="/getByAllParams", method= RequestMethod.GET)
	    public @ResponseBody Page<com.cfa.project.walkinplanner.models.UserPlan> getByAllParams(
	    		@PathParam("planName") String planName,
	    		@PathParam("owner") String owner,
	    		@PathParam("isComplete") boolean isComplete,
	    		@PathParam("isUnderReview") boolean isUnderReview,
	    		@PathParam("isLocked") boolean isLocked,
	    		@PathParam("isUnderReviewer") String isUnderReviewer,
	    		@PathParam("reviewer") String reviewer,
	    		@PathParam("limit")int limit,
	    		@PathParam("page") int page
	    		) {
	        
		 final PageRequest page1 = new PageRequest(page, limit, Direction.ASC, "planName");
		 
		
		 	
		     
		 		Page<com.cfa.project.walkinplanner.models.UserPlan> userPlanLists = userPlanRepository.findByAllParams(planName,owner,page1);
		        return userPlanLists ;
	    }
}
