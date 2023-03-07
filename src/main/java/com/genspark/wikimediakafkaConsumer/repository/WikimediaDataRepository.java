package com.genspark.wikimediakafkaConsumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.genspark.wikimediakafkaConsumer.model.WikimediaData;

public interface WikimediaDataRepository extends JpaRepository<WikimediaData,Long>{

}
