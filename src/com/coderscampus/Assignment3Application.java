package com.coderscampus;

import java.io.*;
import java.util.Scanner;

public class Assignment3Application {
	public static User[] users = new User[4];
	static UserService userService = new UserService();
	static FileService fileService=new FileService();

	public static void main(String[] args) {
		users=fileService.readUserFromFile("data.txt");
		User checkedInUser = null;
		int loginAttempts = 1;
		try (Scanner scanner = new Scanner(System.in)) {
			while (checkedInUser == null && loginAttempts < 6) {
				System.out.println("Enter username : ");
				String consoleUserName = scanner.nextLine();

				System.out.println("Enter password : ");
				String consolePwd = scanner.nextLine();
				checkedInUser = userService.validateUser(consoleUserName, consolePwd);
				
				if (checkedInUser != null) {
					System.out.println("Welcome: " + checkedInUser.getName());
					break;
				} else if (checkedInUser == null) {
					System.out.println("Invalid login, please try again");
				}
				if (loginAttempts >= 5 && checkedInUser == null) {
					System.out.println("Too many failed login attempts, you are now locked out.");
				}
				loginAttempts++;
			}
		}
	}
}
