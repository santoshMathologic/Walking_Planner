/**
 * 
 */
package com.cfa.project.walkinplanner.controllers;





import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.List;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cfa.project.walkinplanner.repository.UserRepository;




/**
 * @author RAKESH
 *
 */

@Controller
@RequestMapping("/api/v1/user")
public class User {

	 @Autowired
	 UserRepository userrepository;
	
	public User() {
	}
	
	@RequestMapping(value="/getListUsers",method=RequestMethod.GET)
	public @ResponseBody String getListUsers(){
		
	List<com.cfa.project.walkinplanner.models.User> userList	 = userrepository.findAll();
	System.out.print(""+userList);
	
		//return new Gson().toJson(userList);
	return "jjjj";
		
		
		
	}
	
	@RequestMapping(value="/getUsers",method=RequestMethod.GET)
	public @ResponseBody Page<com.cfa.project.walkinplanner.models.User> getUsers(){
		
	Page<com.cfa.project.walkinplanner.models.User> userList	 = userrepository.findAll(new PageRequest(0,10, Direction.ASC, "username"));
		
		return userList;
		
		
		
	}
	@RequestMapping(value="/saveUser",method=RequestMethod.POST)
	public String saveUser(@RequestBody com.cfa.project.walkinplanner.models.User user){
		
		try{
			System.out.println(""+getRandomKey());	
		}catch(Exception e){
			System.out.println(""+e);
		}
		
	 userrepository.save(user);
		
		return "User has been saved Successfully";
		
		
		
	}
	public byte[] getRandomKey() throws NoSuchAlgorithmException,
	NoSuchProviderException {
	KeyGenerator keyGen = KeyGenerator.getInstance("AES");
	keyGen.init(256);
	SecretKey secretKey = keyGen.generateKey();
	return secretKey.getEncoded();
	}
	
	
	
	

}
