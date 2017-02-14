package com.yh.model;

import java.io.Serializable;
import java.util.Date;

public class Query implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String query;
	private String oldResult;
	private Date oldTime;
	private String newResult;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getOldResult() {
		return oldResult;
	}
	public void setOldResult(String oldResult) {
		this.oldResult = oldResult;
	}
	public Date getOldTime() {
		return oldTime;
	}
	public void setOldTime(Date oldTime) {
		this.oldTime = oldTime;
	}
	public String getNewResult() {
		return newResult;
	}
	public void setNewResult(String newResult) {
		this.newResult = newResult;
	}
	
	
	

}
