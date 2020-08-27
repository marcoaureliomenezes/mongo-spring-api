package com.marcomenezes.mongoDBspringapi.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.marcomenezes.mongoDBspringapi.domain.User;
import com.marcomenezes.mongoDBspringapi.repositories.UserRepository;


@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {

		userRepository.deleteAll();
		
		User user1 = new User(null, "Alécio Reis", "dicara@gmail.com");
		User user2 = new User(null, "Rosemberg Faria", "zepelim@gmail.com");
		User user3 = new User(null, "Fabricio Fernandes", "digarupa@gmail.com");

		userRepository.saveAll(Arrays.asList(user1, user2, user3));
	}

	
}
