package com.bingo.redistopic.model;

import lombok.Data;

@Data
public class GoodsMessage extends RedisMessage {
	private String goodsType;
	private String number;
}
