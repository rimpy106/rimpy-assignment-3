package com.coderscampus;

import java.io.*;
import java.util.Scanner;

public class Assignment3Application {
	public static User[] users = new User[4];;
	static UserService userService = new UserService();

	public static void main(String[] args) {
		BufferedReader fileReader = null;
		try {
			fileReader = new BufferedReader(new FileReader("data.txt"));
			String line;
			int i = 0;
			while ((line = fileReader.readLine()) != null) {
				String[] lineData = line.split(",");
				users[i] = new User(lineData[0], lineData[1], lineData[2]);
				i++;
			}
			/*
			 * for (int k = 0; k < users.length; k++) {
			 * System.out.println(users[k].toString()); }
			 */
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		User checkedInUser = null;
		int loginAttempts = 0;
		try (Scanner scanner = new Scanner(System.in)) {
			while (checkedInUser == null && loginAttempts < 5) {
				System.out.println("Enter username : ");
				String consoleUserName = scanner.nextLine();

				System.out.println("Enter password : ");
				String consolePwd = scanner.nextLine();
				checkedInUser = userService.validateUser(consoleUserName, consolePwd);
				loginAttempts++;
				if (checkedInUser != null) {
					System.out.println("Welcome: " + checkedInUser.getName());
				}
				if (checkedInUser == null) {
					System.out.println("Invalid login, please try again");
				}
				if (loginAttempts > 5) {
					System.out.println("Too many failed login attempts, you are now locked out.");
				}
			}
		}
	}
}
