package com.yh.designpattern;

import org.junit.Test;

import com.yh.designpattern.bridgepattern.Color;
import com.yh.designpattern.bridgepattern.Red;
import com.yh.designpattern.bridgepattern.Shape;
import com.yh.designpattern.bridgepattern.Square;

public class BridgePatternTest {
	
	@Test
	public void getResult() {
		Color c = new Red();
		
		Shape s = new Square();
		
		s.setColor(c);
		
		s.draw();
	}

}
