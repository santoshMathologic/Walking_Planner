/**
 * 
 */
package com.cfa.project.walkinplanner.controllers;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cfa.project.walkinplanner.models.Role;
import com.cfa.project.walkinplanner.repository.RoleRepository;

/**
 * @author SANTOSH
 *
 */

@RestController
@RequestMapping("/api/v1/roles")

public class Roles implements Serializable {

	/**
	 * 
	 */
	@Autowired
	RoleRepository roleRepository;
	
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public Roles() {
	}
	@RequestMapping(value="/getUserRoles",method = RequestMethod.GET)
	public @ResponseBody Page<Role> getUserRoles(){
		  
		 final PageRequest page1 = new PageRequest(
				  0, 10, Direction.ASC, "name"
				);
		 	
		 		Page<Role> rolesList = this.roleRepository.findAll(page1);
		        return rolesList ;
	}
	@RequestMapping(value="/getRoleInfo",method = RequestMethod.GET)
	public @ResponseBody String getRoleInfo(){
		  
		 return "You can upload a file by posting to this same URL.";
		
		
	}

}
