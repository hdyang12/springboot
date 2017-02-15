package com.yh.redis.dao;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import com.yh.model.Person;

@Repository
public class PersonDao {
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;//springboot已为我们配置stringRedisTemplate;在此可以直接注入
	
	@Resource(name="stringRedisTemplate")
	ValueOperations<String, String> valOpsStr;//可注入基于字符串的简单属性操作方法
	
	@Autowired
	private RedisTemplate<Object, Object> redisTemplate;//springboot已为我们配置redisTemplate;在此可以直接注入
	
	@Resource(name="redisTemplate")
	ValueOperations<Object, Object> valOps;//可注入基于对象的简单属性操作方法
	
	public void stringRedisTemplateDemo(){
		valOpsStr.set("xx", "yy");
	}
	
	public void save(Person person){
		valOps.set(person.getId(), person);
	}
	
	public String getString(){
		return valOpsStr.get("xx");
	}
	
	public Person getPerson(){
		return (Person)valOps.get("1");
	}

}
