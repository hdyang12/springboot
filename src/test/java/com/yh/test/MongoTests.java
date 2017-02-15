package com.yh.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yh.controller.SampleController;
import com.yh.model.Hqinfo;
import com.yh.mongo.dao.HqinfoRepository;

/**
 * springboot单元测试
 * Mongo测试类
 * @author yh
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)	//在JUnit环境下提供Spring TestContext Framework的功能
//用来加载配置application,其中classes 属性用来加载配置类
@SpringBootTest(classes = {SampleController.class})
public class MongoTests {
	
	@Autowired
	private HqinfoRepository hqinfoRepository;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Test
	public void getHqinfoTests(){
		Hqinfo hqinfo = hqinfoRepository.findByStkcode("000591.SZ");
		System.out.println(hqinfo);
	}
	
	@Test
	public void getHqinfoListTests(){
		List<Hqinfo> hqinfoList = hqinfoRepository.findByZuidazhangfu(9.5);
		for(Hqinfo hqinfo : hqinfoList){
			System.out.println(hqinfo);
		}
	}
	
	@Test
	public void mongoTemplateTest(){
		Hqinfo hqinfo = mongoTemplate.findOne(Query.query(Criteria.where("stkcode").is("000591.SZ")), Hqinfo.class);  
		System.out.println(hqinfo);
	}

}
