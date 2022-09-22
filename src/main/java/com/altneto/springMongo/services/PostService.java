package com.altneto.springMongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.altneto.springMongo.domain.Post;
import com.altneto.springMongo.repositories.PostRepository;
import com.altneto.springMongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;

	public Post findById(String id) {
		Optional<Post> post = postRepository.findById(id);
		
		if (!post.isPresent()) {
			throw new ObjectNotFoundException("Post não encontrado");
		}
		
		return post.get();
	}
	
	public List<Post> findByTilte(String text) {
		List<Post> posts = postRepository.findByTitleContaining(text);
		
		return posts;
	}
}
