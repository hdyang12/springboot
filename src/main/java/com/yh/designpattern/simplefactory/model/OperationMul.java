package com.yh.designpattern.simplefactory.model;

import org.springframework.stereotype.Component;

/**
 * *
 * @author yh
 *
 */
@Component
public class OperationMul extends Operate{

	@Override
	double operation(double d1, double d2) {
		return d1 * d2;
	}

	@Override
	String getOperator() {
		return "*";
	}

}
