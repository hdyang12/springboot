package com.yh.designpattern;

import org.junit.Test;

import com.yh.designpattern.adapter.Adapter;
import com.yh.designpattern.adapter.Target;

/**
 * 适配器模式
 * 
 * 有点亡羊补牢的感觉,最好能事先预防接口不同的问题;在有小问题的时候,及时重构;不至于到了最后无法挽救,只能用适配器模式
 * @author yh
 *
 */
public class AdapterTest {
	
	@Test
	public void getResult(){
		Target adapter = new Adapter();
		adapter.Request();
	}

}
