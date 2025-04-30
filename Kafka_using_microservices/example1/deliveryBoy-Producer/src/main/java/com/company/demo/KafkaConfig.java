package com.company.demo;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

	@Bean
	public NewTopic topic() {
	
		return TopicBuilder
				.name(AppContants.LOCATION_TOPIC_NAME)
				.build();
		
	}
}
