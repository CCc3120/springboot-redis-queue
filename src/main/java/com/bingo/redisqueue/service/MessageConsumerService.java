package com.bingo.redisqueue.service;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * 队列模型实现
 * 
 * @author SURIOT
 *
 */
@Service
public class MessageConsumerService extends Thread {
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	private volatile boolean flag = true;

	@Value("${redis.queue.key}")
	private String queueKey;

	@Value("${redis.queue.pop.timeout}")
	private Long popTimeout;

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	@Override
	public void run() {
		try {
			Object message;
			while (flag && !Thread.currentThread().isInterrupted()) {
				message = redisTemplate.opsForList().rightPop(queueKey, popTimeout, TimeUnit.SECONDS);
				System.out.println("接收到了" + message);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}


}
