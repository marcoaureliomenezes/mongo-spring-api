package com.marcomenezes.mongoDBspringapi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcomenezes.mongoDBspringapi.domain.Post;
import com.marcomenezes.mongoDBspringapi.repositories.PostRepository;
import com.marcomenezes.mongoDBspringapi.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
}
