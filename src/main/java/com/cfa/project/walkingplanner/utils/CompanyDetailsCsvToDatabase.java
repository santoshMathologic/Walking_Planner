package com.cfa.project.walkingplanner.utils;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cfa.project.walkinplanner.models.CompanyDetailsModel;
import com.cfa.project.walkinplanner.models.WalkInDetailsModel;
import com.cfa.project.walkinplanner.repository.CompanyRepository;
import com.cfa.project.walkinplanner.repository.WalkingRepository;
import com.fasterxml.jackson.annotation.JsonFormat;

@Service("CompanyDetails")
public class CompanyDetailsCsvToDatabase implements CsvToDataBase {

	CompanyDetailsModel companyDetailobj = null;
	   WalkInDetailsModel WalkInDetail  = null;
	   
	   @Temporal(TemporalType.DATE)
	   Date walkingdate;
		  
		@Temporal(TemporalType.TIME)
		@JsonFormat
	    (shape = JsonFormat.Shape.STRING, pattern = "hh:mm")
		Date walkingTime;
	   

		@Autowired
		CompanyRepository companyRepository;
		
		@Autowired
		WalkingRepository walkingRepository;
	public CompanyDetailsCsvToDatabase() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean processRecord(String[] columns) {
 
		
		 String companyName  =  columns[1];
		 String companyAddress  = columns[2];
		 String city  = columns[3];
		 String state = columns[4];
		 String country  = columns[5];
		 String shortVenue  = columns[6];
		 String venu  = columns[7];
		 
		 
		
		
 	   	
 	   
 	   CompanyDetailsModel companyDetailsModel = companyRepository.findByCompanyNameContains(companyName);
 	   if(companyDetailsModel!=null){
 		   
 		  
 			WalkInDetail  =  new WalkInDetailsModel(); 
 		    WalkInDetail.setShortVenue(shortVenue);
 	 	   	WalkInDetail.setVenu(venu);
 	 	   	//WalkInDetail.setWalkingdate(walkingDate);
 	 	   	//WalkInDetail.setWalkingTime(Walking_time);
 	 	  //WalkInDetail.setCompanydetails(companyDetailsModel);
 	 	WalkInDetail.setCompanydetails(companyRepository.findByCompanyNameContains(companyName));
 	 	walkingRepository.save(WalkInDetail);
 	 	  
 		   
 	   }
 	   
 	  if(companyDetailsModel==null){
 		  
 		  
 		  
 		  
 		 companyDetailobj = new CompanyDetailsModel();
	    	companyDetailobj.setCompanyName(companyName);
	    	companyDetailobj.setCompanyAddress(companyAddress);
	    	companyDetailobj.setCity(city);
	    	companyDetailobj.setCountry(country);
	    	companyDetailobj.setState(state);
	    	companyRepository.save(companyDetailobj);
	    	
	    	 WalkInDetail  =  new WalkInDetailsModel(); 
	    	
	    	 WalkInDetail  =  new WalkInDetailsModel(); 
	 		    WalkInDetail.setShortVenue(shortVenue);
	 	 	   	WalkInDetail.setVenu(venu);
	 	 	   	//WalkInDetail.setWalkingdate(walkingDate);
	 	 	   	//WalkInDetail.setWalkingTime(Walking_time);
	 	 	  //WalkInDetail.setCompanydetails(companyDetailsModel);
 	    WalkInDetail.setCompanydetails(companyRepository.findByCompanyNameContains(companyName));
 	   	walkingRepository.save(WalkInDetail);
 		  
 		  
 		  
 		  
 	  }
 	   
 	   	
 	 
		 
		 
		return false;
	}

}
