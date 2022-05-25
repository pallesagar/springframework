package com.kafka.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.payload.User;
import com.kafka.producer.JsonKafkaProducer;

@RestController
public class JsonMessageController {

	
	private JsonKafkaProducer kafkaProducer;

	public JsonMessageController(JsonKafkaProducer kafkaProducer) {
		this.kafkaProducer = kafkaProducer;
	}
	
	@PostMapping("/api/v1/kafka/publish")
	public ResponseEntity<String> publish(@RequestBody User user){
		
		kafkaProducer.sendMessage(user);
		
		return ResponseEntity.ok("Json Message sent to kafka topic");
		
	}
}
