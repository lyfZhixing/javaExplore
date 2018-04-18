package lyf.designMode;
/**
 * 线程安全的懒汉模式1
 * @author 	lyf
 * 日期：		2017年10月26日
 */
public class Singleton_v2 {
	private static Singleton_v2 single = null;
	private Singleton_v2(){};
	/**
	 * 同步方法保证线程安全，但是每次都要同步会影响性能，因此有了Singleton_v3版本避免每次同步的性能损耗
	 * @return
	 */
	public static synchronized Singleton_v2 getInstance(){
		if(single == null){
			single = new Singleton_v2();
		}
		return single;
	}
}
