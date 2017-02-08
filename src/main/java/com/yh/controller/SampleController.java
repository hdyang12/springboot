package com.yh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
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
@ComponentScan("com.yh.model")
@EnableAutoConfiguration//让SpringBoot根据类路径中的jar包依赖为当前项目进行自动配置
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
