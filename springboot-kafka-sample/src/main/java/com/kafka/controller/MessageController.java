package com.kafka.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.producer.KafkaProducer;

@RestController
public class MessageController {

	private KafkaProducer kafkaProducer;

	public MessageController(KafkaProducer kafkaProducer) {
		this.kafkaProducer = kafkaProducer;
	}
	
	@RequestMapping("/api/v1/kafka/publish")
	public ResponseEntity<String> publish(@RequestParam("message") String message){
		
		
		 kafkaProducer.sendMessage(message);
		 return ResponseEntity.ok("Message send to the topic");
		
	}
	
}
