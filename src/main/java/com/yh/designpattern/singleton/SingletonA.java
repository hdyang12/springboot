package com.yh.designpattern.singleton;

/**
 * 第一种方式:
 * 私有构造器,共有静态成员
 * 此种方式可以通过反射机制 破解(反射机制调用私有构造器)
 * 
 * 如果需要抵御这种攻击,可以修改构造器,让它在被要求创建第二个实例的时候抛出异常
 * @author yh
 *
 */
public class SingletonA {
	
	public static final SingletonA INSTANCE = new SingletonA();
	
	private SingletonA() {
		
	}

}
