package com.yh.mongo.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.yh.model.Hqinfo;

public interface HqinfoRepository extends MongoRepository<Hqinfo, String>{
	
	Hqinfo findByStkcode(String stkcode);
	
	@Query("{'zuidazhangfu':{$gte: ?0}}") //?0指的是第一个入参,?1指第二个入参
	List<Hqinfo> findByZuidazhangfu(Double d);

}
