package com.yh.designpattern.proxy.model;

import com.yh.designpattern.proxy.service.GiveGift;

public class ProxyPerson implements GiveGift {
	
	private Pursuit pursuit;

	public ProxyPerson(Girl girl) {
		super();
		this.pursuit = new Pursuit(girl);
	}

	@Override
	public void giveDolls() {
		pursuit.giveDolls();
	}

	@Override
	public void giveFlowers() {
		pursuit.giveFlowers();
	}

	@Override
	public void giveChocolate() {
		pursuit.giveChocolate();
	}

}
