package com.yh.designpattern.simplefactory.model;

import org.springframework.stereotype.Component;

/**
 * 默认
 * @author yh
 *
 */
@Component
public class OperationDefault extends Operate{

	@Override
	double operation(double d1, double d2) {
		return 0;
	}

	@Override
	String getOperator() {
		return "default";
	}

}
