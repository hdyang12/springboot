package com.yh.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.yh.model.Query;

public interface QueryMapper {
	@Insert({
		"insert into query (query)value(#{query})"
	})
	public void insertQuery(Query q)throws Exception;
	
	@Select({"select * from query where id limit #{row},#{pageSize}"})
	public List<Query> findQueryByPage(@Param("row") int row, @Param("pageSize") int pageSize);
	
	@Select({"select * from query where query = #{query}"})
	public List<Query> findQueryByQuery(@Param("query") String query);
	
	@Select({"select count(*) from query"})
	public int getQueryCount();

	@Update({ "update query",
		"set old_result=#{oldResult},",
		"old_time=#{oldTime} ",
		"where id = #{id}" })
	public void updateQuery(Query q)throws Exception;
	
	@Update({ "update query",
		"set new_result=#{newResult} ",
		"where id = #{id}" })
	public void updateNewQuery(Query q)throws Exception;
	
	@Delete({
		"delete from query"
	})
	public void emptyQuery() throws Exception;

}
