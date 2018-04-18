package lyf.AOP.JDKProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * 动态代理类
 * jdk原生动态代理中，代理类与被代理类是兄弟关系
 * 
 * 					调用方
 * 			 		  |
 * 			 		  v
 * 			-----接口ProductDao-----
 * 			个		  		    个
 * 运行时动态生成类				被代理类
 * com.sun.proxy.$Proxy0	ProductDaoImpl
 * 
 * @author lyf
 *
 */
public class LogProxy implements InvocationHandler {
	Logger logger = Logger.getLogger(this.getClass().getName());
	Object delgate;
	/**
	 * 绑定方法
	 * @param obj	被代理对象
	 * @return		代理对象：proxy:com.sun.proxy.$Proxy0
	 */
	public Object bind(Object obj){
		this.delgate = obj;
		Class<?> cls = this.delgate.getClass();
		//Proxy.newProxyInstance方法的三个参数依次是：被代理类的加载器、被代理类所实现的接口、代理类this
		return Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), this);
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		System.out.println("proxy:"+proxy.getClass().getName());	//proxy:com.sun.proxy.$Proxy0
		System.out.println("method:"+method.getName());				//method:delete
		if(args.length > 0){
			for (int i = 0; i < args.length; i++) {
				System.out.println("arg:"+args[i]);					//arg:ben
			}
		}
		
		logger.log(Level.INFO,"befor...");
		//回调
		Object obj = method.invoke(delgate, args);
		logger.log(Level.INFO,"after...");
		String log = "方法："+method.getName()+"被"+args[0]+"执行";
		logger.log(Level.INFO,log);									//信息: 方法：delete被ben执行
		
		return obj;
	}

}
