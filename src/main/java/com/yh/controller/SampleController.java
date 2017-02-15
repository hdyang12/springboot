package com.yh.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yh.model.Book;

/**
 * 静态首页 http://localhost:8080/springboot/
 * classpath:/resources/index.html
 * 静态首页会和/index冲突
 * @author yh
 *
 */
@Controller
//@SpringBootApplication	//组合注解;包含@EnableAutoConfiguration;@Configurable;@ComponentScan
@ComponentScan("com.yh")
@MapperScan("com.yh.mybatis.mapper")	//MapperScan的注解，这个是会扫描该包下的接口
@EnableAutoConfiguration//让SpringBoot根据类路径中的jar包依赖为当前项目进行自动配置
@EnableMongoRepositories(value= {"com.yh.mongo.dao"})
@EnableRedisRepositories(value= {"com.yh.redis.dao"})
public class SampleController {
	
	//application.properties的属性直接使用@Value注入
	@Value("${book.name}")
	private String bookName;
	
	@Autowired
	Book book;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SampleController.class, args);
	}
	
	//http://localhost:8080/springboot/home
    @RequestMapping("/home")
    @ResponseBody
    String home() {
//    	System.out.println(hqinfoRepository.findByStkcode("000591.SZ"));
        return "Hello World!";
    }
    
    //SpringBoot 默认thymeleaf 模板引擎  ThymeleafProperties
    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }
    
    @RequestMapping("/bookName")
    @ResponseBody
    String index() {
        return "书名为:"  + bookName;
    }
    
    @RequestMapping("/book")
    @ResponseBody
    String book() {
        return "书名为:"  + book.getName() + ";作者为：" + book.getAuthor();
    }
    
}
