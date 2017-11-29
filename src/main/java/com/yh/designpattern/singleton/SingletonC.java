package com.yh.designpattern.singleton;

/**
 * 第三种方法：
 * 包含单个元素的枚举类型
 * 这种方法在功能上与公有域方法相近,但是它更加简洁,无偿地提供了序列化机制,绝对防止多次实例化,即使是在面对复杂的序列化或者反射攻击的时候。
 * @author yh
 *
 */
public enum SingletonC {
	INSTANCE;
}
