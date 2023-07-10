package com.haji.MyFirstWebApp.Security;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecurityConfiguration {
	@Bean
	InMemoryUserDetailsManager createUserManager() {
		UserDetails u = CreateUserDetails("haji", "boss");
		UserDetails u1 = CreateUserDetails("aaliyah", "boss");
		UserDetails u2 = CreateUserDetails("satyam", "boss");
		InMemoryUserDetailsManager im = new InMemoryUserDetailsManager(u1);
		im.createUser(u);
		im.createUser(u2);
		return im;
	}

	UserDetails CreateUserDetails(String Username, String password) {
		Function<String, String> passwordEncoder = input -> PassEncoder().encode(input);

		UserDetails u = User.builder().passwordEncoder(passwordEncoder).username(Username).password(password)
				.roles("USER", "ADMIN").build();
		return u;
	}

	@Bean
	PasswordEncoder PassEncoder() {
		return new BCryptPasswordEncoder();
	}
}
