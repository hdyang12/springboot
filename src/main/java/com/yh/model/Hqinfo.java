package com.yh.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document	//映射领域模型和MongoDB的文档
public class Hqinfo {
	
	@Id	//Id注解表明这个属性为文档的id
	private String id;
	private double zuidazhangfu;
	private double zuidadiefu;
	private String stkcode;
	private long timestamp;
	
	public Hqinfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getZuidazhangfu() {
		return zuidazhangfu;
	}
	public void setZuidazhangfu(double zuidazhangfu) {
		this.zuidazhangfu = zuidazhangfu;
	}
	public double getZuidadiefu() {
		return zuidadiefu;
	}
	public void setZuidadiefu(double zuidadiefu) {
		this.zuidadiefu = zuidadiefu;
	}
	public String getStkcode() {
		return stkcode;
	}
	public void setStkcode(String stkcode) {
		this.stkcode = stkcode;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	@Override
	public String toString() {
		return "Hqinfo [id=" + id + ", zuidazhangfu=" + zuidazhangfu
				+ ", zuidadiefu=" + zuidadiefu + ", stkcode=" + stkcode
				+ ", timestamp=" + timestamp + "]";
	}
	
	

}
