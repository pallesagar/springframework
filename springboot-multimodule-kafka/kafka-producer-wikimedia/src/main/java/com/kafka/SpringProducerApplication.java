package com.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringProducerApplication implements CommandLineRunner{
	public static void main(String[] args) {
		SpringApplication.run(SpringProducerApplication.class, args);
	}

	@Autowired
	private WikimediaChangesProducer wikimediaProducer;
	@Override
	public void run(String... args) throws Exception {
		wikimediaProducer.sendMessage();
		
	}
}
