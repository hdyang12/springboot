package com.yh.designpattern.simplefactory.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.yh.designpattern.simplefactory.model.Operate;

@Component
public class OperateFactory {
	private Map<String, Operate> operateMap = new HashMap<String, Operate>();
	
	public void addOperator(String operator, Operate Operate){
		operateMap.put(operator, Operate);
	}

	public Operate getOperate(String operator) {
		Operate operate = operateMap.get(operator);
		if (operate == null) {
			return operateMap.get("default");
		}
		return operate;
	}

}
