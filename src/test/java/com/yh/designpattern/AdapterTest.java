package com.yh.designpattern;

import org.junit.Test;

import com.yh.designpattern.adapter.Adapter;
import com.yh.designpattern.adapter.Target;

public class AdapterTest {
	
	@Test
	public void getResult(){
		Target adapter = new Adapter();
		adapter.Request();
	}

}
