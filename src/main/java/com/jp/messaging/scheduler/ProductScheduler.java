package com.jp.messaging.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jp.messaging.vo.Product;

@Component
public class ProductScheduler {

	@Autowired
	private JmsTemplate jmsTemplate;

	@Autowired
	private ObjectMapper objectMapper;

	@Scheduled(fixedRate = 2000)
	public void postMessage() {
		StringBuffer prodId = new StringBuffer("prod").append((long)(Math.random() * 10000));
		Product product = new Product();
		product.setId(prodId.toString());
		String productString = null;
		try {
			productString = objectMapper.writeValueAsString(product);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		if(productString != null) {
		jmsTemplate.convertAndSend("products", productString);
		}
	}
}
