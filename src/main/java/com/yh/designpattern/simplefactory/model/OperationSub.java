package com.yh.designpattern.simplefactory.model;

import org.springframework.stereotype.Component;

/**
 * \/ 除法
 * @author yh
 *
 */
@Component
public class OperationSub extends Operate{

	@Override
	double operation(double d1, double d2) {
		return d1 / d2;
	}

	@Override
	String getOperator() {
		return "/";
	}

}
