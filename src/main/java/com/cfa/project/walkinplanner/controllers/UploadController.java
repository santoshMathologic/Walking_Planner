package com.cfa.project.walkinplanner.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cfa.project.walkingplanner.utils.CsvToDataBase;
import com.cfa.project.walkinplanner.models.CompanyDetailsModel;
import com.cfa.project.walkinplanner.models.WalkInDetailsModel;
import com.cfa.project.walkinplanner.repository.CompanyRepository;
import com.cfa.project.walkinplanner.repository.WalkingRepository;
import com.opencsv.CSVReader;



@Controller
public class UploadController {
	
	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);
	
	 @Autowired
	 @Qualifier("CompanyDetails")
	 CsvToDataBase companyDetailsCsvToDatabase;
	 
	 @Autowired
		CompanyRepository companyRepository;
		
		@Autowired
		WalkingRepository walkingRepository;

	public UploadController() {
		// TODO Auto-generated constructor stub
	}
	
	  @RequestMapping(value="/upload", method= RequestMethod.GET)
	    public @ResponseBody String provideUploadInfo() {
	        return "You can upload a file by posting to this same URL.";
	    }
	
	 @RequestMapping(value="/uploading",method=RequestMethod.POST)
	   public @ResponseBody String uploading(@RequestParam("file") MultipartFile fileCompanyDetails,HttpServletRequest request){
		 
			Path currentRelativePath = Paths.get("");
		   	String s = currentRelativePath.toAbsolutePath().toString();
		   	String nameTrainDetails = s+"/uploads";
		 
		 if (!fileCompanyDetails.isEmpty()) {
	         try {
	        	 // writes to the buffer contents of the csv file
	        	 File file = new File(nameTrainDetails);
	        	 file.mkdirs();
	        	 nameTrainDetails += "/"+LocalDateTime.now().toString().replace(':','-')+fileCompanyDetails.getOriginalFilename();
	        	 nameTrainDetails = nameTrainDetails.replace("%20", " ");
	        	 nameTrainDetails = nameTrainDetails.replace("\\", "/");
	        	 file =  new File(nameTrainDetails);
	             byte[] bytes = fileCompanyDetails.getBytes();
	             BufferedOutputStream stream =
	                     new BufferedOutputStream(new FileOutputStream(file));
	             stream.write(bytes);
	             stream.close();

	             //If file is not type of csv type means do not allow to upload
	             if(!fileCompanyDetails.getOriginalFilename().contains(".csv")){
	                 return "Uploaded file is not CSV";
	             }

	            
	             CSVReader reader = new CSVReader(new FileReader(nameTrainDetails),',','\'',1);
	             for (String[] line; (line = reader.readNext()) != null;) {
	             	
	            	 companyDetailsCsvToDatabase.processRecord(line);
	            	 logger.debug("get users list");
	             }

		 
		 System.out.println("Upload Details "+fileCompanyDetails);
		return null;
	         
	         }catch(Exception e){
	        	 System.out.println(""+e);
	         }
		 }
		return "File Upload Successfully";
	 
	         
	        
		 
	 
}
	 @RequestMapping(value="/getAllRecords", method= RequestMethod.GET)
	    public @ResponseBody Page<CompanyDetailsModel> getAllRecords(
	    		@PathParam("sort") String sort,
	   			@PathParam("limit")int limit,
	   			@PathParam("page") int page,
	   			@PathParam("companyName") String companyName,
	   			@PathParam("city") String city
	    		){
		 final PageRequest page1 = new PageRequest(
				 page, limit, Direction.ASC, "companyName"
				);
		 
		     System.out.println(""+sort);
		     System.out.println(""+limit);
		     System.out.println(""+page);
		     System.out.println(""+companyName);
		 	
		     
		 		Page<CompanyDetailsModel> companydetails = companyRepository.findByAllParams(companyName,city,page1);
		        return companydetails;
	    } 
	 

	 @RequestMapping(value="/getAllWalkingRecords", method= RequestMethod.GET)
	    public @ResponseBody Page<WalkInDetailsModel> getAllWalkingRecords() {
		 final PageRequest page1 = new PageRequest(
				  0, 10, Direction.ASC, "venu"
				);
		 	
		 		Page<WalkInDetailsModel> walkingList = this.walkingRepository.findAll(page1);
		        return walkingList;
	    }

	public CsvToDataBase getCompanyDetailsCsvToDatabase() {
		return companyDetailsCsvToDatabase;
	}

	public void setCompanyDetailsCsvToDatabase(CsvToDataBase companyDetailsCsvToDatabase) {
		this.companyDetailsCsvToDatabase = companyDetailsCsvToDatabase;
	}

	public CompanyRepository getCompanyRepository() {
		return companyRepository;
	}

	public void setCompanyRepository(CompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}

	public WalkingRepository getWalkingRepository() {
		return walkingRepository;
	}

	public void setWalkingRepository(WalkingRepository walkingRepository) {
		this.walkingRepository = walkingRepository;
	}

	public static Logger getLogger() {
		return logger;
	} 
	
	

}
