package com.yh.designpattern.singleton;

/**
 * 第二种方式:
 * 饿汉式
 * 共有的成员是个静态工厂方法
 * 工厂方法的主要好处在于,组成类的成员的声明很清楚地表明了这个类是一个Singleton;
 * 工厂方法还提供了灵活性,在不改变其API的前提下,我们可以改变该类是否应该为Singleton的想法。比如为每个调用该方法的线程返回一个唯一的实例。
 * 该方式最常用
 * 
 * 第一、二种方式序列化有问题,不能维持并保证Singleton
 * @author yh
 *
 */
public class SingletonB {
	
	private static boolean flag = true;
	private static final SingletonB INSTANCE = new SingletonB();
	
	private SingletonB() {
		if (flag) {
			flag = false;
		} else {
			throw new RuntimeException("单例模式正在被攻击");
		}
		
	}
	
	public static SingletonB getInstance() {
		return INSTANCE;
	}

}
