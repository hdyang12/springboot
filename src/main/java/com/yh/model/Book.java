package com.yh.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
//通过@ConfigurationProperties加载properties文件内的配置;prefix = "author"指定前缀:book.author=zhangsan中的book
@PropertySource("classpath:book.properties")
@ConfigurationProperties(prefix = "book")
public class Book {
	
	private String author;
	private String name;
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
