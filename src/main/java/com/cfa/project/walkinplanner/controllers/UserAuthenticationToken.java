/**
 * 
 */
package com.cfa.project.walkinplanner.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author SANTOSH
 *
 */

@RestController
@RequestMapping("/")

public class UserAuthenticationToken {

	/**
	 * 
	 */
	public UserAuthenticationToken() {
		// TODO Auto-generated constructor stub
	}
	
	//@RequestMapping(value="/",method = RequestMethod.GET)
	public String generateToke(HttpServletRequest httpRequest){
		
		System.out.println("Inside Token generation ");
		
		return "";
		
	}

}
