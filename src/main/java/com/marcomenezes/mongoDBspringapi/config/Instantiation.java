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
import com.marcomenezes.mongoDBspringapi.dto.CommentDTO;
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

		CommentDTO c1 = new CommentDTO("Parabéns. Vai se dar bem demais lá.", sdf.parse("03/09/2020"), new AuthorDTO(user3));
		CommentDTO c2 = new CommentDTO("Boa sorte lá mano. Sucesso!!!", sdf.parse("03/09/2020"), new AuthorDTO(user2));
		CommentDTO c3 = new CommentDTO("Aí deu certo. É nois.", sdf.parse("05/09/2020"), new AuthorDTO(user1));
		CommentDTO c4 = new CommentDTO("Até que enfim hein", sdf.parse("28/08/2020"), new AuthorDTO(user3));
		CommentDTO c5 = new CommentDTO("Aí sim hein.", sdf.parse("29/08/2020"), new AuthorDTO(user1));
		
		post1.getComments().addAll(Arrays.asList(c4, c5));
		post2.getComments().addAll(Arrays.asList(c1, c2, c3));
		
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		user4.getPosts().addAll(Arrays.asList(post1, post2));
		
		userRepository.save(user4);
	}

	
}
