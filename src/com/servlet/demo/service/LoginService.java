package com.servlet.demo.service;

import java.util.HashMap;
import java.util.Map;

import com.servlet.demo.dto.User;

public class LoginService {

	Map<String, String> users = new HashMap<String,String>(); 
	public LoginService() {		
		users.put("user1", "User One" );
		users.put("user2", "User Two" );
		users.put("user3", "User Three" );
	}
	
	public boolean authenticate(String userId, String password) {
		
		if(password == null || password.trim() == "")  {
			return false;
		  }
		return true;
	}
	
public User getUserDetails(String userId) {
	User user = new User();
	user.setUserName(users.get(userId));
	user.setUserId(userId);
	return user;
	}
}
