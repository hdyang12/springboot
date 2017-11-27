package com.yh.designpattern;

import org.junit.Test;

import com.yh.designpattern.proxy.model.Girl;
import com.yh.designpattern.proxy.model.ProxyPerson;

/**
 * 代理模式引用:
 * 1. 远程代理,为一个对象在不同的地址空间提供局部代表。比如引用WebService
 * 2. 虚拟代理,根据需要创建开销很大的对象,通过它来存放实例化需要很长时间的真是对象。比如打开HTML网页,图片的一张张下载,这些图片就是用了虚拟代理
 * 3. 安全代理,用来控制真实对象访问时的权限
 * 4. 智能指引
 * @author yh
 *
 */
public class ProxyTest {
	
	@Test
	public void getResult() {
		ProxyPerson proxy = new ProxyPerson(new Girl("提莫"));
		proxy.giveFlowers();
		proxy.giveChocolate();
		proxy.giveDolls();
	}

}
