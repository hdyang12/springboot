package com.yh.designpattern.decorator.model;

import com.yh.designpattern.decorator.service.Component;

abstract class Decorator implements Component {
	
	protected Component component;

	@Override
	public void Operation() {
		if (component != null) {
			component.Operation();
		}
	}

	public void setComponent(Component component) {
		this.component = component;
	}

}
