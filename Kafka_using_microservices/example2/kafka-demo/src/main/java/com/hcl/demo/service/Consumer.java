package com.hcl.demo.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
	
	@KafkaListener(topics = "vishu_topic", groupId = "vishu_group")
	public void listenToTopic(String receivedMessage) {
		System.out.println("The received Message is :"+receivedMessage);
	}

}
