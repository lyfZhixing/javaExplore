package dynamicProxy;

import java.lang.reflect.Proxy;

/**
 * 动态生成代理类
 * @author Administrator
 *
 */
public class Main {

	public static void main(String[] args) {
		//创建中介类实例
		DynamicProxy inter = new DynamicProxy(new WhiteFace());
		//动态生成代理类文件，产生一个$Proxy0.class文件,可以通过反编译工具得到代码
		System.getProperties().put("sun.misc.ProxyGenerator.savaGeneratedFiles", "true");
		//获取代理类实例
		//loader：定义了代理类的ClassLoder;interfaces：代理类实现的接口列表
		//h：调用处理器，也就是我们上面定义的实现了InvocationHandler接口的类实例
		DoHelp proxy = (DoHelp)Proxy.newProxyInstance(DoHelp.class.getClassLoader(), new Class[]{DoHelp.class}, inter);
		//通过代理类对象调用代理类方法，实际上会转到invoke方法调用
		proxy.buyMeal("妹子");
		proxy.buyMeal("汉子");
		proxy.fixPc("妹子");
	}
	
	
}
