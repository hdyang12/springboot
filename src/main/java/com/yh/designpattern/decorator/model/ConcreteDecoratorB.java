package com.yh.designpattern.decorator.model;

public class ConcreteDecoratorB extends Decorator {
	
	private String addedState;
	
	@Override
	public void Operation() {
		addedState = "牛仔裤";
		System.out.print(addedState + " ");
		super.Operation();
	}

}
