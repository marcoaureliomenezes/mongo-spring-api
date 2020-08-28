package com.marcomenezes.mongoDBspringapi.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.marcomenezes.mongoDBspringapi.domain.Post;
import com.marcomenezes.mongoDBspringapi.domain.User;
import com.marcomenezes.mongoDBspringapi.dto.AuthorDTO;
import com.marcomenezes.mongoDBspringapi.repositories.PostRepository;
import com.marcomenezes.mongoDBspringapi.repositories.UserRepository;


@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User user1 = new User(null, "Alécio Reis", "dicara@gmail.com");
		User user2 = new User(null, "Rosemberg Faria", "zepelim@gmail.com");
		User user3 = new User(null, "Fabricio Fernandes", "digarupa@gmail.com");
		User user4 = new User(null, "Marco Menezes", "marco@gmail.com");
		userRepository.saveAll(Arrays.asList(user1, user2, user3, user4));

		
		Post post1 = new Post(null, sdf.parse("02/09/2020"),
				"Partiu viagem!", "Vou para São Carlos, abraços!!!", 
				new AuthorDTO(user4));
		Post post2 = new Post(null, sdf.parse("28/08/2020"),
				"Deu certo!", "Graças a Deus consegui um emprego!!!",
				new AuthorDTO(user4));

		user4.getPosts().addAll(Arrays.asList(post1, post2));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		userRepository.save(user4);
	}

	
}
