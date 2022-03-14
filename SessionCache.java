package com.revature.utils;

import java.util.Optional;

import com.revature.beans.Users;

/**
 * Cache which stores the currently logged in User 
 */
public class SessionCache {
	
	private static Optional<Users> loggedInUser;
	
	public static Optional<Users> getCurrentUser() {
		return loggedInUser;
	}
	
	public static void setCurrentUser(Users u) {
		loggedInUser = Optional.ofNullable(u);
	}

}