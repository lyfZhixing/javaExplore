package lyf.jdkAop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MyProxyHandler implements InvocationHandler {

	//要代理的对象
	private Calculator target;
	
	public MyProxyHandler(Calculator h){
		this.target = h;
	}
	
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		//获取参数
		System.out.println("beginWith---方法的参数是--"+Arrays.asList(args));
		
		before();
		Object result = method.invoke(target,args);
		after();
		return result;
	}

	//前置
	public void before(){
		System.out.println("before---");
	}
	
	//后置
	public void after(){
		System.out.println("after---");
	}
}
