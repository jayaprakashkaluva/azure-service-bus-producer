package com.jp.messaging.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	@Autowired
	private JmsTemplate jmsTemplate;

	@PostMapping("/publish")
	public String postMessage(@RequestBody String message) {
		jmsTemplate.convertAndSend("products", message);
		return message;
	}
}
