package com.yh.designpattern.simplefactory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yh.designpattern.simplefactory.model.Operate;
import com.yh.designpattern.simplefactory.util.OperateFactory;

/**
 * 简单工厂模式的一个实现
 * 简单工厂模式特性：
 * 可维护、可复用、可扩展、灵活性好、松耦合
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
