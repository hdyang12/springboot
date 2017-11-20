package com.yh.designpattern.simplefactory.model;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.yh.designpattern.simplefactory.util.OperateFactory;

/**
 * 运算符
 * @author yh
 *
 */
public abstract class Operate implements InitializingBean{
	
	@Autowired
	private OperateFactory operateFactory;
	abstract double operation(double d1, double d2);
	abstract String getOperator();

	@Override
	public void afterPropertiesSet() throws Exception {
		operateFactory.addOperator(getOperator(), this);
	}
	
	public double calc(double d1, double d2){
		return operation(d1, d2);
	}
}
