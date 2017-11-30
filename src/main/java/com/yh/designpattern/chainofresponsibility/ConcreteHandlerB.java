package com.yh.designpattern.chainofresponsibility;

public class ConcreteHandlerB extends Handler {

	@Override
	public void handleRequest(int request) {
		if (request > 10 && request < 20) {
			System.out.println("10-20在这里处理");
		}else if (super.successor != null) {
			super.successor.handleRequest(request);
		} else {
			System.out.println("B无法处理此请求");
		}
	}

}
