package com.yh.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yh.controller.SampleController;
import com.yh.model.Hqinfo;
import com.yh.redis.dao.PersonDao;

/**
 * springboot单元测试
 * Redis测试类
 * @author yh
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)	//在JUnit环境下提供Spring TestContext Framework的功能
//用来加载配置application,其中classes 属性用来加载配置类
@SpringBootTest(classes = {SampleController.class})
public class RedisTests {
	
	@Autowired
	private PersonDao personDao;
	
	@Test
	public void getStringTests(){
		personDao.stringRedisTemplateDemo();
		System.out.println(personDao.getString());
	}

}
