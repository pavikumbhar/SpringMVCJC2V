package com.pavikumbhar.javaheart.common.V2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pavikumbhar
 */
public class DAOException extends Exception {

	private static final long serialVersionUID = 1L;

	
	public DAOException(String message) {
		super(message);
	}

	public DAOException(String message, Throwable cause) {
		super(message, cause);
	}

}