package com.yh.designpattern;

import org.junit.Test;

import com.yh.designpattern.builderpattern.BuilderPerson;
import com.yh.designpattern.builderpattern.ConcreteBuilderA;
import com.yh.designpattern.builderpattern.ConcreteBuilderB;

/**
 * 建造者模式
 * 建造者模式是在当创建复杂对象的算法应该独立于该对象的组成部分以及它们的装配方式时适用的模式。
 * @author yh
 *
 */
public class BuilderPatternTest {

	@Test
	public void getResult(){
		BuilderPerson bp = new BuilderPerson();
		bp.getResult(new ConcreteBuilderA());
		bp.getResult(new ConcreteBuilderB());
	}
}
