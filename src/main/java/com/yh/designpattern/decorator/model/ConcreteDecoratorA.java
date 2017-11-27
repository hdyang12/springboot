package com.yh.designpattern.decorator.model;

public class ConcreteDecoratorA extends Decorator {
	
	private String addedState;
	
	@Override
	public void Operation() {
		addedState = "T恤";
		System.out.print(addedState + " ");
		super.Operation();
	}
	

}
