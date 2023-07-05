package com.haji.MyFirstWebApp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticateService {

	public boolean AuthenticateUser(String name, String password) {
		boolean isUserNameValid = name.equalsIgnoreCase("haji");
		boolean isPasswordValid = password.equalsIgnoreCase("boss");
		if (isUserNameValid && isPasswordValid) {
			return true;
		}

		return false;
	}

}
