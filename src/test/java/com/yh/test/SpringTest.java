package com.yh.test;

import org.apache.naming.factory.BeanFactory;
import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class SpringTest {
	
	@Test
	public void springTest () {
		XmlBeanFactory bf = new XmlBeanFactory(new ClassPathResource("beanFactory.xml"));
		SpringTest bean  = (SpringTest)bf.getBean("springTest");
	}

}
