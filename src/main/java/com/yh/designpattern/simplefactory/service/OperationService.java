package com.yh.designpattern.simplefactory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yh.designpattern.simplefactory.model.Operate;
import com.yh.designpattern.simplefactory.util.OperateFactory;

/**
 * 简单工厂模式和策略模式结合的一个实现
 * 简单工厂模式特性：
 * 可维护、可复用、可扩展、灵活性好、松耦合
 *	 策略模式：
 * 	—抽象策略角色： 策略类，通常由一个接口或者抽象类实现。
 *	—具体策略角色：包装了相关的算法和行为。
 *	—环境角色：持有一个策略类的引用，最终给客户端调用。
 *	应用场景：
 *	1、 多个类只区别在表现行为不同，可以使用Strategy模式，在运行时动态选择具体要执行的行为。
 *	2、 需要在不同情况下使用不同的策略(算法)，或者策略还可能在未来用其它方式来实现。
 *	3、 对客户隐藏具体策略(算法)的实现细节，彼此完全独立。
 * @author yh
 *
 */
@Service
public class OperationService {
	
	@Autowired
	private OperateFactory operateFactory;
	
	public double getResult(double param1, String operator, double param2){
		Operate operate = operateFactory.getOperate(operator);
		return operate.calc(param1, param2);
	}

}
