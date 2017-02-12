/**
 * 
 */
package com.cfa.project.walkinplanner.exception;

import java.io.Serializable;

/**
 * @author SANTOSH
 *
 */
public class CustomException extends Exception implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public CustomException(String exp) {
		super(exp); 
	}

}
