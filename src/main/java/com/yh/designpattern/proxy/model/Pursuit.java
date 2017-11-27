package com.yh.designpattern.proxy.model;

import com.yh.designpattern.proxy.service.GiveGift;

public class Pursuit implements GiveGift {
	
	private Girl girl;
	
	public Pursuit(Girl girl) {
		super();
		this.setGirl(girl);
	}

	@Override
	public void giveDolls() {
		System.out.println(girl.getName() + " 给你刷个火箭!");
	}

	@Override
	public void giveFlowers() {
		System.out.println(girl.getName() + " 送你鲜花!");
	}

	@Override
	public void giveChocolate() {
		System.out.println(girl.getName() + " 送你巧克力!");
	}

	public Girl getGirl() {
		return girl;
	}

	public void setGirl(Girl girl) {
		this.girl = girl;
	}

}
