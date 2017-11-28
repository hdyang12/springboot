package com.yh.designpattern.publishsubscribe;

public class StudentObserver implements Observer {
	
	private String name;

	public StudentObserver(String name) {
		super();
		this.name = name;
	}

	@Override
	public void update(String info) {
		System.out.println(name + "接收到:" + info);
	}

}
