package com.yh.designpattern;

import org.junit.Test;

import com.yh.designpattern.chainofresponsibility.ConcreteHandlerA;
import com.yh.designpattern.chainofresponsibility.ConcreteHandlerB;
import com.yh.designpattern.chainofresponsibility.Handler;

public class ChainOfResponsibilityTest {
	
	@Test
	public void getRequest(){
		Handler a = new ConcreteHandlerA();
		Handler b = new ConcreteHandlerB();
		
		a.setSuccessor(b);
		
		a.handleRequest(5);
		
		a.handleRequest(15);
		
		a.handleRequest(25);
	}

}
