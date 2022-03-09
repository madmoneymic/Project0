package com.revature.services;

import com.revature.beans.User;
import com.revature.dao.AccountDao;
import com.revature.dao.UserDao;

import com.revature.exceptions.RuntimeException;

import com.revature.exceptions;

/**
 * This class should contain the business logic for performing operations on users
 */
public class UserService2 {
	
	UserDao userDao;
	AccountDao accountDao;
	boolean found;
	
	public class UsernameAlreadyExistsException extends RuntimeException {

		private static final long serialVersionUID = 1712843686624302051L;
	}	
	public UserService(UserDao udao, AccountDao adao) {
		this.userDao = udao;
		this.accountDao = adao;
	}
	
	/**
	 * Validates the username and password, and return the User object for that user
	 * @throws InvalidCredentialsException if either username is not found or password does not match
	 * @return the User who is now logged in
	 */
	public User login(String username, String password) {
	    if (found==TRUE)
	    	userDao.getUser(username,password);
	    else
	    	throw InvalidCredentialsException;
		return userDao;
	}
	
	/**
	 * Creates the specified User in the persistence layer
	 * @param newUser the User to register
	 * @throws UsernameAlreadyExistsException if the given User's username is taken
	 */
	public void register(User newUser) {	  
		newUser.getUser(newUser.username,newUser.password);
	    if (found==TRUE)
	    	throw UsernameAlreadyExistsException;
	    else {
	    	UserService(newUser);
	        userDao.adduser(newUser);
	} 
}
}


