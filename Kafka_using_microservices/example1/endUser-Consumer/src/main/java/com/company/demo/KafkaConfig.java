package com.company.demo;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

	@KafkaListener(topics = AppConstants.LOCATION_UPDATE_TOPIC,groupId = AppConstants.GROUP_ID)
	public void updatedLocation(String value){
		
		System.out.println(value);
	}
}
