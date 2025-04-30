package com.hcl.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.demo.service.Producer;

@RestController
@RequestMapping("/api")
public class KafkaController {

	@Autowired
	Producer producer;
	
	@GetMapping("/produceMsg")
	public void getMessageFromClient(@RequestParam("message") String message){
		producer.sendMessageToTopic(message);
	}
}
