package com.yh.designpattern.singleton;

/**
 * 第二种方式:
 * 懒汉式
 * 懒汉式是不安全的。
 * 如果两个线程，我们称它们为线程1和线程2，在同一时间调用getInstance()方法，如果线程1先进入if块，然后线程2进行控制，那么就会有两个实例被创建。
 * 多线程时,需要增加锁
 * @author yh
 *
 */
public class SingletonB2 {
	
	private static SingletonB2 INSTANCE = null;
	
	private SingletonB2() {
		
	}
	
	//不加锁的有线程风险的公用方法
	public static SingletonB2 getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new SingletonB2();
		}
		return INSTANCE;
	}
	
	//加锁
	public static SingletonB2 getInstanceA() {
		synchronized (SingletonB2.class) {
			if (INSTANCE == null) {
				INSTANCE = new SingletonB2();
			}
		}
		
		return INSTANCE;
	}
	
	//双重锁定
	public static SingletonB2 getInstanceB() {
		if (INSTANCE == null) {
			synchronized (SingletonB2.class) {
				if (INSTANCE == null){
					INSTANCE = new SingletonB2();
				}
			}
		}
		
		return INSTANCE;
	}

}
