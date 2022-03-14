package com.revature.services;

import com.revature.beans.Users;
import com.revature.dao.*;


import com.revature.exceptions.*;

/**
 * This class should contain the business logic for performing operations on users
 */
public class UserServices {
	
	UserDaoDB userDao;
	AccountDaoDB accountDao;
    
	
	public class UsernameAlreadyExistsException extends RuntimeException {

		private static final long serialVersionUID = 1712843686624302051L;
	}	
	public UserServices(UserDaoDB udao, AccountDaoDB adao) {
		this.userDao = udao;
		this.accountDao = adao;
	}
	
	/**
	 * Validates the username and password, and return the User object for that user
	 * @throws InvalidCredentialsException if either username is not found or password does not match
	 * @return the User who is now logged in
	 */
	public Users login(String username, String password) {
		Users regUser=null;
		
		try {
	    	regUser.equals(userDao.getUser(username, password));
	    }catch(InvalidCredentialsException e) {
	    	System.out.println("Login credentials are invalid. Please try again later");
	    }
	    	
		return regUser;
	}
	
	/**
	 * Creates the specified User in the persistence layer
	 * @param newUser the User to register
	 * @param String 
	 * @throws UsernameAlreadyExistsException if the given User's username is taken
	 */
	public void register(Users newUser) {	
		
	    try {
	    	userDao.addUser(newUser);
	    }catch(UsernameAlreadyExistsException e) {
	    	System.out.println("This username is taken. Please type another username and press ENTER!!!");
	    }
	        
	    }
	}

	    
	    


