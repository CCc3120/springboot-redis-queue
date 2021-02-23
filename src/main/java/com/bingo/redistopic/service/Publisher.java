package com.bingo.redistopic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.bingo.redistopic.model.RedisMessage;

@Service
public class Publisher {
	private final RedisTemplate<String, Object> redisMessageTemplate;

	@Autowired
	public Publisher(RedisTemplate<String, Object> redisMessageTemplate) {
		this.redisMessageTemplate = redisMessageTemplate;
	}

	public void pushMessage(String topic, RedisMessage message) {
		redisMessageTemplate.convertAndSend(topic, message);
	}
}
