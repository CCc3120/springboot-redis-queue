package com.bingo.redisqueue.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducerService {
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	@Value("${redis.queue.key}")
	private String queueKey;

	public Long sendMeassage(Object message) {
		System.out.println("发送了" + message);
		return redisTemplate.opsForList().leftPush(queueKey, message);
	}
}
