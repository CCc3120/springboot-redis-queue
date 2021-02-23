package com.bingo.redistopic.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class RedisMessage implements Serializable {
	public String msgId;
	public long createStamp;
}
