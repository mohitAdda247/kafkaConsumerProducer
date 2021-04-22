package com.kafkaconsumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.kafkaconsumer.model.User;
import com.kafkaconsumer.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private Gson gson;
	
	@Autowired
	private UserRepository userRepository;
	
	User newUser = new User();
	
	@KafkaListener(topics="user", groupId="mohit")
	public void getUser(String  user) {
		System.out.println("Kafka consumed:"  + user);
		newUser = gson.fromJson(user, User.class);
		System.out.println("Model converted value:" + newUser);
		userRepository.save(newUser);
	}
}
