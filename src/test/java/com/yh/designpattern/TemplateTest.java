package com.yh.designpattern;

import org.junit.Test;

import com.yh.designpattern.templatemethod.StudentA;
import com.yh.designpattern.templatemethod.StudentB;
import com.yh.designpattern.templatemethod.TestPaper;

/**
 * 模板方法模式
 * 通过把不变的行为搬移到父类,去除重复代码
 * @author yh
 *
 */
public class TemplateTest {
	
	@Test
	public void getResult(){
		TestPaper stuA = new StudentA();
		TestPaper stuB = new StudentB();
		
		stuA.question1();
		stuB.question1();
	}

}
