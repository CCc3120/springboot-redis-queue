package com.bingo.redistopic.model;

import lombok.Data;

@Data
public class UserMessage extends RedisMessage {
	private String userId;
	private String username;
	private String password;
}
