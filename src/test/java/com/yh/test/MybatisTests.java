package com.yh.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.yh.controller.SampleController;
import com.yh.service.MybatisService;

/**
 * springboot单元测试
 * Mybatis测试类
 * @author yh
 *
 */
@Component
@RunWith(SpringJUnit4ClassRunner.class)	//在JUnit环境下提供Spring TestContext Framework的功能
//用来加载配置application,其中classes 属性用来加载配置类
@SpringBootTest(classes = {SampleController.class})
public class MybatisTests {
	@Autowired
	private MybatisService mybatisService;
	
	@Test
	@Transactional
	public void getCountTests(){
		int count = mybatisService.getQueryCount();
		System.out.println(count);
	}

}
