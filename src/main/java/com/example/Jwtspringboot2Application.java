package com.example;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.entity.User;
import com.example.repository.UserRepository;

@SpringBootApplication
public class Jwtspringboot2Application {
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(Jwtspringboot2Application.class, args);
	}

	@PostConstruct
	public void initUsers() {
		List<User> users = Stream.of(new User(10, "amitava", "1234", "a@gmail.com"),
				new User(11, "amit", "3234", "b@gmail.com"), new User(12, "sunit", "9234", "n@gmail.com"),
				new User(13, "dipak", "6234", "g@gmail.com"), new User(14, "tarok", "5234", "t@gmail.com")

		).collect(Collectors.toList());
		userRepository.saveAll(users);
	}

}
