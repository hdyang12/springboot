package com.yh.designpattern.adapter;

public class Adapter extends Target{
	
	//通过在内部包装一个Adaptee对象,把源接口转换成目标接口
	private Adaptee adaptee = new Adaptee();

	@Override
	public void Request() {
		System.out.print("目标接口包装");
		adaptee.Request();
	}
}
