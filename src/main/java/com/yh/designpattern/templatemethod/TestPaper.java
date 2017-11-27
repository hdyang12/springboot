package com.yh.designpattern.templatemethod;

public class TestPaper {

	public void question1() {
		System.out.println("题目1的答案是?");
		System.out.println(answer1());
	}
	
	public void question2() {
		System.out.println("题目2的答案是?");
		System.out.println(answer2());
	}
	
	public String answer1() {
		return null;
	}

	public String answer2() {
		return null;
	}
}
