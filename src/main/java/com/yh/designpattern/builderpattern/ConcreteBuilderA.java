package com.yh.designpattern.builderpattern;

public class ConcreteBuilderA extends Builder{

	@Override
	void BuilderPartA() {
		System.out.println("AA");
	}

	@Override
	void BuilderPartB() {
		System.out.println("AB");
	}

}
