package com.coderscampus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileService {

	public User[] readUserFromFile(String filename) {
		BufferedReader fileReader = null;
		User[] users = new User[4];
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
		return users;
	}

}
