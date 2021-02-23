package com.bingo.redisqueue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bingo.redisqueue.service.MessageConsumerService;
import com.bingo.redisqueue.service.MessageProducerService;

@RestController
@RequestMapping(value = "/queue")
public class TestQueueController {

	@Autowired
	private MessageProducerService producerService;

	@Autowired
	private MessageConsumerService consumerService;

	@RequestMapping(value = "/test")
	public String test() {
		consumerService.start();
		for (int i = 0; i < 3; i++) {
			producerService.sendMeassage("发送第" + i + "条消息");
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		consumerService.interrupt();
		consumerService.isInterrupted();
		consumerService.interrupted();
		return "success";
	}

}
