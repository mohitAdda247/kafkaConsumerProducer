package com.kafkaproducer.controller;


import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kafkaproducer.model.User;

@RestController
public class ProducerController {
	@Autowired
	private KafkaTemplate<String,User> kafkaTemplate;
	
	@PostMapping("/produce")
	public ResponseEntity<Object> postToKafka(@RequestBody User user) throws InterruptedException,ExecutionException{

       ListenableFuture<SendResult<String, User>> result = kafkaTemplate.send("user", user);
		return new ResponseEntity<>(result.get().getProducerRecord().value(),HttpStatus.OK);
	}
}
