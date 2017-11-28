package com.yh.designpattern;

import org.junit.Test;

import com.yh.designpattern.publishsubscribe.Observer;
import com.yh.designpattern.publishsubscribe.StudentObserver;
import com.yh.designpattern.publishsubscribe.Subject;
import com.yh.designpattern.publishsubscribe.TeacherSubject;

/**
 * 观察者模式(发布-订阅模式)
 * 
 * 什么时候使用观察者模式?
 * 1. 当一个对象的改变需要同时改变其他对象的时候,而且它不知道有多少对象有待改变。
 * 
 * 总的来讲,观察者模式所做的工作就是在解除耦合。让耦合的双方都依赖于抽象,而不是依赖于具体从而使得各自的变化都不会影响另一边的变化。
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
