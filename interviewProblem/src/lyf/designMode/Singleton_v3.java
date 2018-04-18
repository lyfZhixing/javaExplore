package lyf.designMode;
/**
 * 线程安全的懒汉模式2
 * 在getInstance方法中做两次null检查，确保了只有第一次调用单例的时候才会做同步，
 * 这样也是线程安全的，同时也避免了每次都同步的性能损耗，但还是有性能损耗，改进版Singleton_v4
 * @author 	lyf
 * 日期：		2017年10月26日
 */
public class Singleton_v3 {
	private static Singleton_v3 single = null;
	private Singleton_v3(){}
	public static Singleton_v3 getInstance(){
		if(single == null){
			//双重检查锁定
			synchronized(Singleton_v3.class){
				if(single == null){
					single = new Singleton_v3();
				}
			}
		}
		return single;
	}
}
