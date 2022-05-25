package com.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);
	@KafkaListener(topics = "sagar", groupId = "myGroup")
	public void consume(String user) {
		LOGGER.info(String.format("Json message receiver-%s",user.toString()));
		
	}
}
