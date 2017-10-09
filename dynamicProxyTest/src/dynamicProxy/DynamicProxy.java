package dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxy implements InvocationHandler {
	private Object obj;//obj为委托类对象
	
	public DynamicProxy(Object obj) {
		super();
		this.obj = obj;
	}
	/**
	 * @param proxy 	代理类对象
	 * @param method 	标识具体调用的是代理类的哪个方法
	 * @param args 		method方法的参数
	 * 可以在invoke方法中添加统一的处理逻辑，也可以根据method参数对不同的代理方法做不同的处理
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("run before");
		Object result = null;
		if(args[0].equals("妹子")){
			result = method.invoke(obj, args);
		}
		System.out.println("run after");
		
		return result;
	}

}
