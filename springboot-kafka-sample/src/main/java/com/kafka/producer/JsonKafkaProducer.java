package com.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.payload.User;

@Service
public class JsonKafkaProducer {

	
	private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);

private KafkaTemplate<String, String> kafkaTemplate;

public JsonKafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
	this.kafkaTemplate = kafkaTemplate;
}

public void sendMessage(User data) {
	
	 LOGGER.info(String.format("Message sent-->%s", data.toString()));
	 ObjectMapper mapper=new ObjectMapper();
	 String message = null;
	try {
		message = mapper.writeValueAsString(data);
		kafkaTemplate.send("sagar",message);
	} catch (JsonProcessingException e) {
		e.printStackTrace();
	}
			 //Message<User> message =MessageBuilder.withPayload(data).setHeader(KafkaHeaders.TOPIC, "sagar").build();
	
	
}


}
