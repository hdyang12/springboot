package com.yh.designpattern.chainofresponsibility;

public class ConcreteHandlerA extends Handler {

	@Override
	public void handleRequest(int request) {
		if (request > 0 && request < 10) {
			System.out.println("0-10在这里处理");
		}else if (super.successor != null) {
			super.successor.handleRequest(request);
		} else {
			System.out.println("A无法处理此请求");
		}

	}

}
