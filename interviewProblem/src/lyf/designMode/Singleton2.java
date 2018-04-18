package lyf.designMode;
/**
 * 饿汉模式单例
 * 其本身就是线程安全的
 * 在类创建的同时就已经创建好一个静态的对象提供系统使用，以后不再改变，所以天生就是线程安全的
 * @author 	lyf
 * 日期：		2017年10月26日
 */
public class Singleton2 {
	private final static Singleton2 single = new Singleton2();
	private Singleton2(){}
	public static Singleton2 getObj(){
		return single;
	}
}
