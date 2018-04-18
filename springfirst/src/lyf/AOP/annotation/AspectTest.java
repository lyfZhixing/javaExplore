package lyf.AOP.annotation;

import org.aspectj.lang.annotation.AfterThrowing;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AspectTest {
	ApplicationContext context;
	/**
	 * 
	 */
	@Before
	public void init(){
		context = new ClassPathXmlApplicationContext("/aopBean.xml");
	}
	/**
	 * 艾特Before("execution(public void lyf.AOP.annotation.Eat.eat*(..))")
	 * 艾特AfterReturning("execution(* lyf.AOP.annotation.Eat.eat*(..))")
	 * 输出结果：
	 * 		做饭---
			吃肉...
			刷碗---

			做饭---
			吃米饭...
			刷碗---
	 */
	@Test
	public void eatTest() {
		Eat eat = (Eat)context.getBean("eat");
		eat.eatMeat();
		System.out.println();
		eat.eatRice();
	}
	/**
	 * 艾特AfterThrowing("execution(* lyf.AOP.annotation.Eat.drink*(..))")
	 * 输出：有异常抛出---
	 */
	@Test
	public void drinkTest(){
		Eat eat = (Eat)context.getBean("eat");
		eat.drink();
	}
	/**
	 * 艾特AfterThrowing(pointcut="execution(* lyf.AOP.annotation.Eat.drink*(..))",throwing="e")
	 * 输出：	有异常抛出---
			异常：找不到相对应的类
	 * @throws ClassNotFoundException
	 */
	@Test
	public void drinkWaterTest() throws ClassNotFoundException{
		Eat eat = (Eat)context.getBean("eat");
		eat.drinkWater();
	}
	/**
	 * Around("execution(* lyf.AOP.annotation.Eat.taste*(..))")
	 * 输出：	品尝前闻一闻---
			品尝...
			品尝后--------
	 */
	@Test
	public void tasteTest(){
		Eat eat = (Eat)context.getBean("eat");
		eat.taste();
	}
}
