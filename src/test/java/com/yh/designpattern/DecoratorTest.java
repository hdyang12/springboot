package com.yh.designpattern;

import org.junit.Test;

import com.yh.designpattern.decorator.model.ConcreteComponent;
import com.yh.designpattern.decorator.model.ConcreteDecoratorA;
import com.yh.designpattern.decorator.model.ConcreteDecoratorB;

/**
 * 装饰者模式
 * 意图： 动态地给一个对象添加一些额外的职责。就增加功能来说， Decorator模式相比生成子类更为灵活。该模式以对客户端透明的方式扩展对象的功能。
 * 
 * 适用环境:
 *	（1）在不影响其他对象的情况下，以动态、透明的方式给单个对象添加职责。
 *	（2）处理那些可以撤消的职责。
 *	（3）当不能采用生成子类的方法进行扩充时。一种情况是，可能有大量独立的扩展，为支持每一种组合将产生大量的 子类，使得子类数目呈爆炸性增长。另一种情况可能是因为类定义被隐藏，或类定义不能用于生成子类。
 * 参与者:
 *   1.Component（被装饰对象的基类）: 定义一个对象接口，可以给这些对象动态地添加职责。
 *   2.ConcreteComponent（具体被装饰对象）: 定义一个对象，可以给这个对象添加一些职责。
 *   3.Decorator（装饰者抽象类）: 维持一个指向Component实例的引用，并定义一个与Component接口一致的接口。
 *   4.ConcreteDecorator（具体装饰者）: 具体的装饰对象，给内部持有的具体被装饰对象，增加具体的职责。
 * 涉及角色:
 *	（1）抽象组件:定义一个抽象接口，来规范准备附加功能的类
 *	（2）具体组件：将要被附加功能的类，实现抽象构件角色接口
 *	（3）抽象装饰者：持有对具体构件角色的引用并定义与抽象构件角色一致的接口
 *	（4）具体装饰：实现抽象装饰者角色，负责对具体构件添加额外功能。
 *
 * 优点:
 * 	把类中的装饰功能从类中搬移去除,简化原有的类,有效地把类的核心职责和装饰功能区分开了。
 * 
 */


/**
 * 装饰模式测试类
 * @author yh
 */
public class DecoratorTest {
	
	@Test
	public void decoratorTest() {
		ConcreteComponent c = new ConcreteComponent("小明");
		ConcreteDecoratorA ca = new ConcreteDecoratorA();
		ConcreteDecoratorB cb = new ConcreteDecoratorB();
		
		ca.setComponent(c);
		cb.setComponent(ca);
		cb.Operation();
	}

}
