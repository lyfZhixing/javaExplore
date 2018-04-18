package lyf.designMode;
/**
 * 单例模式
 * 懒汉模式，在第一次调用时实例化自己
 * 这一版本线程不安全，需要改进
 * @author 	lyf
 * 日期：		2017年10月25日
 */
public class Singleton {
	private static Singleton single = null;
	
	private Singleton(){};
	
	public static Singleton getObj(){
		if(single == null){
			single = new Singleton();
		}
		return single;
	}
}
