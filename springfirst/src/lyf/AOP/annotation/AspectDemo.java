package lyf.AOP.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AspectDemo {
	
	@Before("execution(public void lyf.AOP.annotation.Eat.eat*(..))")
	public void make(){
		System.out.println("做饭---");
	}
	
	@AfterReturning("execution(* lyf.AOP.annotation.Eat.eat*(..))")
	public void clean(){
		System.out.println("刷碗---");
	}
	@AfterThrowing("execution(* lyf.AOP.annotation.Eat.drink*(..))")
	public void throwing(){
		System.out.println("有异常抛出---");
	}
	@AfterThrowing(pointcut="execution(* lyf.AOP.annotation.Eat.drink*(..))",throwing="e")
	public void throwing2(ClassNotFoundException e){
		System.out.println("异常：找不到相对应的类");
	}
	@Around("execution(* lyf.AOP.annotation.Eat.taste*(..))")
	public void aroun(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("品尝前闻一闻---");
		pjp.proceed();
		System.out.println("品尝后--------");
	}
}
