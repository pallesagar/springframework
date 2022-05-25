package com.kafka;

import java.net.URI;
import java.util.concurrent.TimeUnit;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;

@Service
public class WikimediaChangesProducer {

	private KafkaTemplate<String,String> kafkaTemplate;

	public WikimediaChangesProducer(KafkaTemplate<String, String> kafkaTemplate) {
		super();
		this.kafkaTemplate = kafkaTemplate;
	}
	
	
	public void sendMessage() {
		String topic ="wikimedia";
		
		EventHandler eventHandler =new WikimediaChangesHandler(kafkaTemplate,topic);
		String url="https://stream.wikimedia.org/v2/stream/recentchange";
		EventSource.Builder builder= new EventSource.Builder(eventHandler, URI.create(url));
		EventSource eventSource = builder.build();
		eventSource.start();
		try {
			TimeUnit.MINUTES.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
