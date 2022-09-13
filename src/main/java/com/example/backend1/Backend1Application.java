package com.example.backend1;

import com.example.backend1.domain.Role;
import com.example.backend1.domain.User;
import com.example.backend1.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class Backend1Application {

	public static void main(String[] args) {

		SpringApplication.run(Backend1Application.class, args);
	}
	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	@Bean
	CommandLineRunner run(UserService userService){
		return args-> {
			userService.saveRole(new Role(null,"ROLE_USER"));
			userService.saveRole(new Role(null,"ROLE_ADMIN"));
			userService.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null,"John Travolta","john","1234",new ArrayList<>()));
			userService.saveUser(new User(null,"Szymon Wasik","szymon","1234",new ArrayList<>()));
			userService.saveUser(new User(null,"Will Smith","will","1234",new ArrayList<>()));

			userService.addRoleToUser("john","ROLE_USER");
			userService.addRoleToUser("szymon","ROLE_SUPER_ADMIN");
			userService.addRoleToUser("szymon","ROLE_ADMIN");
			userService.addRoleToUser("szymon","ROLE_USER");
			userService.addRoleToUser("will","ROLE_USER");
		};
	}

}
