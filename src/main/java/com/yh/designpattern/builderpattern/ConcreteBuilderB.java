package com.yh.designpattern.builderpattern;

public class ConcreteBuilderB extends Builder{

	@Override
	void BuilderPartA() {
		System.out.println("BA");
	}

	@Override
	void BuilderPartB() {
		System.out.println("BB");
	}

}
