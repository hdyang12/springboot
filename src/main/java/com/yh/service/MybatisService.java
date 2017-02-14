package com.yh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yh.mybatis.mapper.QueryMapper;

@Service
public class MybatisService {
	
	@Autowired
	private QueryMapper queryMapper;
	
	//事务;使用rollbackFor属性,指定特定异常时,数据回滚
	@Transactional(rollbackFor={IllegalArgumentException.class})
	public int getQueryCount(){
		return queryMapper.getQueryCount();
	}

}
