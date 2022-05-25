package com.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumer {

	@Autowired
	private WikimediaRepository wikiRepo;
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);
	
	@KafkaListener(topics = "wikimedia", groupId = "myGroup")
	private void consume(String eventMessage) {
		LOGGER.info(String.format("message received ->%s", eventMessage));
		WikimediaData mediaData =new WikimediaData();
		mediaData.setWikiEventData(eventMessage);
		wikiRepo.save(mediaData);
		LOGGER.info(String.format("message received ->%s", mediaData));
		
		
	}
}
