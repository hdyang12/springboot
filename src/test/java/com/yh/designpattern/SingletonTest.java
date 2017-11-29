package com.yh.designpattern;

import org.junit.Test;

import com.yh.designpattern.singleton.SingletonA;
import com.yh.designpattern.singleton.SingletonB;
import com.yh.designpattern.singleton.SingletonC;

/**
 * 单例模式
 * @author yh
 *
 */
public class SingletonTest {
	
	@Test
	public void getResult(){
		
		SingletonA sa = SingletonA.INSTANCE;
		
		SingletonB sb = SingletonB.getInstance();
		
		SingletonC sc = SingletonC.INSTANCE;
		
	}

}
