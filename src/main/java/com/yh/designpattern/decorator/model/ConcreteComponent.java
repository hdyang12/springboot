package com.yh.designpattern.decorator.model;

import com.yh.designpattern.decorator.service.Component;

public class ConcreteComponent implements Component {
	
	private String addedState;
	
	public ConcreteComponent() {
		super();
	}

	public ConcreteComponent(String addedState) {
		super();
		this.addedState = addedState;
	}

	@Override
	public void Operation() {
		System.out.println("装扮的" + addedState);
	}

}
