package com.yh.designpattern.bridgepattern;

public abstract class Shape {
	
	Color color;
	
	public abstract void draw();

	public void setColor(Color color) {
		this.color = color;
	}
	
}
