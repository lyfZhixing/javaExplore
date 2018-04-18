package lyf.jdkAop;

import java.lang.reflect.Proxy;

/**
 * jdk动态代理测试
 * @author mingshan
 *
 */
public class Test {

	public static void main(String[] args) {
       Calculator target=new CalculatorImpl();
	   Calculator proxy = (Calculator) Proxy.newProxyInstance(Calculator.class.getClassLoader(),new Class<?>[]{Calculator.class}, new MyProxyHandler(target));
	   
	   proxy.add(1, 2);
	   
	}
}
