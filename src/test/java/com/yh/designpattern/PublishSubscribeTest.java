package com.yh.designpattern;

import org.junit.Test;

import com.yh.designpattern.publishsubscribe.Observer;
import com.yh.designpattern.publishsubscribe.StudentObserver;
import com.yh.designpattern.publishsubscribe.Subject;
import com.yh.designpattern.publishsubscribe.TeacherSubject;

/**
 * 观察者模式(发布-订阅模式)
 * @author yh
 *
 */
public class PublishSubscribeTest {
	
	@Test
	public void getResult(){
		Subject teacherSub = new TeacherSubject();
		Observer StudentObs1 = new StudentObserver("张三");
		Observer StudentObs2 = new StudentObserver("李四");
		
		teacherSub.addObserver(StudentObs1);
		teacherSub.addObserver(StudentObs2);
		
		teacherSub.notifyObserver("布置作业:第1题");
		teacherSub.notifyObserver("布置作业:第2题");
		teacherSub.notifyObserver("布置作业:第5题");
		
	}

}
