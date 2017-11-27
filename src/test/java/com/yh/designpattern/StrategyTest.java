package com.yh.designpattern;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yh.controller.SampleController;
import com.yh.designpattern.simplefactory.service.OperationService;

/**
 * springboot单元测试
 * 简单工厂结合策略模式测试类
 * @author yh
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)	//在JUnit环境下提供Spring TestContext Framework的功能
//用来加载配置application,其中classes 属性用来加载配置类
@SpringBootTest(classes = {SampleController.class})
public class StrategyTest {
	
	@Autowired
	private OperationService operationService;
	
	@Test
	public void getResultTest(){
		
		System.out.println("5 + 10 =" + operationService.getResult(5, "+", 10));
		System.out.println("5 - 10 =" + operationService.getResult(5, "-", 10));
		System.out.println("5 * 10 =" + operationService.getResult(5, "*", 10));
		System.out.println("5 / 10 =" + operationService.getResult(5, "/", 10));
		System.out.println("5 / 0 =" + operationService.getResult(5, "/", 0));
		System.out.println("5 @ 10 =" + operationService.getResult(5, "@", 10));
	}

}
