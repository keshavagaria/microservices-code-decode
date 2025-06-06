package com.hcl.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {
	
	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;
	
	public void sendMessageToTopic(String message) {
		kafkaTemplate.send("vishu_topic",message);
	}

}
