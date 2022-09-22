package com.altneto.springMongo.config;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.altneto.springMongo.domain.Post;
import com.altneto.springMongo.domain.User;
import com.altneto.springMongo.dto.AuthorDto;
import com.altneto.springMongo.dto.CommentDto;
import com.altneto.springMongo.repositories.PostRepository;
import com.altneto.springMongo.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		if (userRepository.findAll().size() == 0) {
			User maria = new User(null, "Maria Brown", "maria@gmail.com");
			User alex = new User(null, "Alex Green", "alex@gmail.com");
			User bob = new User(null, "Bob Grey", "bob@gmail.com");
			
			userRepository.saveAll(Arrays.asList(maria, alex, bob));
			
			if (postRepository.findAll().size() == 0) {
				Post post1 = new Post(null, LocalDate.now(), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDto(maria));
				Post post2 = new Post(null, LocalDate.now(), "Bom dia", "Acordei feliz hoje!", new AuthorDto(maria));
				
				CommentDto c1 = new CommentDto("Boa viagem mano!", LocalDate.now(), new AuthorDto(alex));
				CommentDto c2 = new CommentDto("Aproveite", LocalDate.now(), new AuthorDto(bob));
				CommentDto c3 = new CommentDto("Tenha um ótimo dia!", LocalDate.now(), new AuthorDto(alex));
				
				post1.getComments().addAll(Arrays.asList(c1, c2));
				post2.getComments().addAll(Arrays.asList(c3));
				
				postRepository.saveAll(Arrays.asList(post1, post2));
				
				maria.getPosts().addAll(Arrays.asList(post1, post2));
				userRepository.save(maria);
			}
		}
	}
}
