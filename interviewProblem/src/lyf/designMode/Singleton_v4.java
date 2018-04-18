package lyf.designMode;
/**
 * 
 * @author 	lyf
 * 日期：		2017年10月26日
 */
public class Singleton_v4 {
	private static class LazyHolder{
		private static final Singleton_v4 INSTANCE = new Singleton_v4();
	}
	private Singleton_v4(){}
	public static final Singleton_v4 getInstance(){
		//String s = (String)'\uface';
		String s2 = "\n\tnull";
		return LazyHolder.INSTANCE;
	}
}
