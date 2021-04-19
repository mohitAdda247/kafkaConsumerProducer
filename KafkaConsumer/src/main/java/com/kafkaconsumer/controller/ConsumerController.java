package com.kafkaconsumer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafkaconsumer.model.User;
import com.kafkaconsumer.repository.UserRepository;

@RestController
public class ConsumerController {
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/all")
	public List<User> getAll(){
		return userRepository.findAll();
	}
}
