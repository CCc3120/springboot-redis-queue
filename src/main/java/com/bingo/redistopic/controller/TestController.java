package com.bingo.redistopic.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bingo.redistopic.model.GoodsMessage;
import com.bingo.redistopic.model.UserMessage;
import com.bingo.redistopic.service.Publisher;

@RestController
@RequestMapping(value = "/topic")
public class TestController {

	@Autowired
	private Publisher publisher;

	@RequestMapping(value = "/test")
	public String test() {
		UserMessage userMessage = new UserMessage();
		userMessage.setMsgId(UUID.randomUUID().toString().replace("-", ""));
		userMessage.setUserId("1");
		userMessage.setUsername("admin");
		userMessage.setUsername("root");
		userMessage.setCreateStamp(System.currentTimeMillis());
		publisher.pushMessage("user", userMessage);
		GoodsMessage goodsMessage = new GoodsMessage();
		goodsMessage.setMsgId(UUID.randomUUID().toString().replace("-", ""));
		goodsMessage.setGoodsType("苹果");
		goodsMessage.setNumber("十箱");
		goodsMessage.setCreateStamp(System.currentTimeMillis());
		publisher.pushMessage("goods", goodsMessage);
		return "success";
	}

}
