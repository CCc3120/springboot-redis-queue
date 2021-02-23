package com.bingo.redistopic.service;

import com.alibaba.fastjson.JSON;

public class GoodsReceiver extends AbstractReceiver {

	@Override
	public void receiveMessage(Object message) {
		System.out.println("接收到商品消息：queue" + JSON.toJSONString(message));

	}

}
