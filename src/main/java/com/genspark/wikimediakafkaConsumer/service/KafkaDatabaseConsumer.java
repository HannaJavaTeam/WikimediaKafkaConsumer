package com.genspark.wikimediakafkaConsumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.genspark.wikimediakafkaConsumer.model.WikimediaData;
import com.genspark.wikimediakafkaConsumer.repository.WikimediaDataRepository;

@Service
public class KafkaDatabaseConsumer {

	private static final Logger LOGGER=LoggerFactory.getLogger(KafkaDatabaseConsumer.class);
	
	@Autowired
	public KafkaDatabaseConsumer(WikimediaDataRepository wikimediaDataRepository) {
		super();
		this.wikimediaDataRepository = wikimediaDataRepository;
	}


	private WikimediaDataRepository wikimediaDataRepository;
	
	
	@KafkaListener(
			topics="wikimedia_topic",
			groupId = " group_id"
			)
	public void consume(String eventMessage) {
		LOGGER.info("message received -> %s", eventMessage);
		//create entity
		WikimediaData wikimediaData=new WikimediaData();
		//bind event data to the entity
		wikimediaData.setWikiEventData(eventMessage);
		//save entity to database table
		wikimediaDataRepository.save(wikimediaData);
	}
}
