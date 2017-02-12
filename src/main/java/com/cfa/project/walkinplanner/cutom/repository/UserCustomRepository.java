/**
 * 
 */
package com.cfa.project.walkinplanner.cutom.repository;

import com.cfa.project.walkinplanner.exception.CustomException;
import com.cfa.project.walkinplanner.models.User;


/**
 * @author SANTOSH
 *
 */
public interface UserCustomRepository {
	
	
	     User findUsernameAndPassword(String username,String password)throws CustomException;

}
