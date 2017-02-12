package com.cfa.project.walkinplanner.controllers;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cfa.project.walkinplanner.models.CompanyDetailsModel;
import com.cfa.project.walkinplanner.models.CustomWalkingDetails;
import com.cfa.project.walkinplanner.models.WalkInDetailsModel;
import com.cfa.project.walkinplanner.repository.CompanyRepository;
import com.cfa.project.walkinplanner.repository.WalkingRepository;


@Controller
@RequestMapping("api/v1/company")
public class CompanyController {
	
	@Autowired
	CompanyRepository companyRepository;
	
	@Autowired
	WalkingRepository walkingRepository;
	
	 @RequestMapping(value="/getCompanyInfo",method=RequestMethod.GET)
	   public @ResponseBody CompanyDetailsModel getCompanyInfo(
			   @PathParam("companyId") Long companyId
	   			){
		 		CompanyDetailsModel companydetail = companyRepository.findOne(companyId);
		        return companydetail;
		        }
	 
	 
	 @RequestMapping(value="/getAllCompany",method=RequestMethod.GET)
	   public @ResponseBody Page<CompanyDetailsModel> getAllCompany(
			   @PathParam("companyName") String companyName
			  ){
		 final PageRequest page1 = new PageRequest(
				  0, 20, Direction.ASC, "companyName"
				);
		 	
		 		Page<CompanyDetailsModel> companydetails = companyRepository.findByCompanyNameContains(companyName,page1);
		        return companydetails;
		        }
	 
	 @RequestMapping(value="/getAllCompanyDetails",method=RequestMethod.GET)
	   public @ResponseBody Page<CompanyDetailsModel> getAllCompanyDetails(){
		 final PageRequest page1 = new PageRequest(
				  0, 20, Direction.ASC, "companyName"
				);
		 	
		 		Page<CompanyDetailsModel> companydetails = companyRepository.findAll(page1);
		        return companydetails;
		        }
	 
	 @RequestMapping(value="/getCompanyDetailBySearch",method=RequestMethod.GET)
	   public @ResponseBody CompanyDetailsModel getCompanyDetailBySearch(@PathParam("companyName")String companyName){
		 
		 	
		 		CompanyDetailsModel companydetails = companyRepository.findByCompanyNameContains(companyName);
		        return companydetails;
		        }
	 
	 @RequestMapping(value="/saveDetails",method=RequestMethod.POST)
	   public @ResponseBody String saveDetails(@RequestBody CustomWalkingDetails CompanyDetailList[]){
		 
		   System.out.println(""+CompanyDetailList);
		   CompanyDetailsModel companyDetailobj = null;
		   WalkInDetailsModel WalkInDetail  = null;
		   
		   
		     for(int i = 0;i<CompanyDetailList.length;i++){
		    	 	WalkInDetail  =  new WalkInDetailsModel(); 
			     	WalkInDetail.setShortVenue(CompanyDetailList[i].getShortVenue());
		    	   	WalkInDetail.setVenu(CompanyDetailList[i].getVenu());
		    	   	WalkInDetail.setWalkingdate(CompanyDetailList[i].getWalkingdate());
		    	   	WalkInDetail.setWalkingTime(CompanyDetailList[i].getWalkingTime());
		    	   	
		    	    WalkInDetail.setCompanydetails(companyRepository.findByCompanyNameContains(CompanyDetailList[i].getCompanyName()));
		    	   	walkingRepository.save(WalkInDetail);
		    	 
		    	 
		     }
		  
		   
		   
		     return "Successfully saved ";
		        }
	 
	 @RequestMapping(value="/saveWalking",method=RequestMethod.POST)
	   public @ResponseBody String saveWalking(@RequestBody WalkInDetailsModel walkInDetailsModel){
		 
		   System.out.println(""+walkInDetailsModel);
		   CompanyDetailsModel companyDetailobj = null;
		   WalkInDetailsModel WalkInDetail  = null;
		   
		   
		   if((walkInDetailsModel.getId()==null) && (walkInDetailsModel.getCompanydetails().getId()==null)){
		    	  
	    	    companyDetailobj = new CompanyDetailsModel();
		    	companyDetailobj.setCompanyName(walkInDetailsModel.getCompanydetails().getCompanyName());
		    	companyDetailobj.setCompanyAddress(walkInDetailsModel.getCompanydetails().getCompanyAddress());
		    	companyDetailobj.setCity(walkInDetailsModel.getCompanydetails().getCity());
		    	companyDetailobj.setCountry(walkInDetailsModel.getCompanydetails().getCountry());
		    	companyDetailobj.setState(walkInDetailsModel.getCompanydetails().getState());
		    	companyRepository.save(companyDetailobj);
		    	
		    	 WalkInDetail  =  new WalkInDetailsModel(); 
		    	
		     	WalkInDetail.setShortVenue(walkInDetailsModel.getShortVenue());
	    	   	WalkInDetail.setVenu(walkInDetailsModel.getVenu());
	    	   	WalkInDetail.setWalkingdate(walkInDetailsModel.getWalkingdate());
	    	   	WalkInDetail.setWalkingTime(walkInDetailsModel.getWalkingTime());
	    	   	
	    	    WalkInDetail.setCompanydetails(companyRepository.findByCompanyNameContains(walkInDetailsModel.getCompanydetails().getCompanyName()));
	    	   	walkingRepository.save(WalkInDetail);
	    	  
	      }
		   
		   
		   
		     return "Successfully saved ";
		        }
	 
	 
	 
}
