package com.bingo.redistopic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

import com.bingo.redistopic.service.GoodsReceiver;
import com.bingo.redistopic.service.UserReceiver;

/**
 * 订阅者
 * 
 * @author SURIOT
 *
 */
@Configuration
public class ReceiverConfig {
	@Bean
	public RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory, MessageListenerAdapter userListenerAdapter,
			MessageListenerAdapter goodsListenerAdapter) {
		RedisMessageListenerContainer container = new RedisMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.addMessageListener(userListenerAdapter, new PatternTopic("user"));
		container.addMessageListener(goodsListenerAdapter, new PatternTopic("goods"));
		return container;
	}

	@Bean
	public MessageListenerAdapter userListenerAdapter(UserReceiver receiver) {
		return new MessageListenerAdapter(receiver, "receiveMessage");
	}

	@Bean
	public MessageListenerAdapter goodsListenerAdapter(GoodsReceiver receiver) {
		return new MessageListenerAdapter(receiver, "receiveMessage");
	}

	@Bean
	public UserReceiver userReceiver() {
		return new UserReceiver();
	}

	@Bean
	public GoodsReceiver goodsReceiver() {
		return new GoodsReceiver();
	}

}
