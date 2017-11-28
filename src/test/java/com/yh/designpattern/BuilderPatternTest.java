package com.yh.designpattern;

import org.junit.Test;

import com.yh.designpattern.builderpattern.BuilderPerson;
import com.yh.designpattern.builderpattern.ConcreteBuilderA;
import com.yh.designpattern.builderpattern.ConcreteBuilderB;

/**
 * 建造者模式
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
