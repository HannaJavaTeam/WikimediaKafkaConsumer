package com.genspark.wikimediakafkaConsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.genspark.wikimediakafkaConsumer.service.KafkaDatabaseConsumer;

@SpringBootApplication
public class WikimediaKafkaConsumerApplication implements CommandLineRunner{
	
	@Autowired
	private KafkaDatabaseConsumer kafkaDatabaseConsumer;

	public static void main(String[] args) {
		SpringApplication.run(WikimediaKafkaConsumerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//kafkaDatabaseConsumer.consume(null);//consumer start consuming messages automatically
	}
}
