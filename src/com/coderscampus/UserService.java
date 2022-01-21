package com.coderscampus;

public class UserService {
	// Assignment3Application application=new Assignment3Application();
	public User validateUser(String userName, String password) {
		for (User user : Assignment3Application.users) {
			if ((user.getUsername().equalsIgnoreCase(userName)) && (user.getPassword().equals(password))) {
				return user;
			}
		}
		return null;
	}
}
