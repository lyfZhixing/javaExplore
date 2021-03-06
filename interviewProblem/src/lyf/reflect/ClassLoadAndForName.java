package lyf.reflect;
/**
 * classForName与ClassLoader的区别
 * 两者都可以将类的.class文件加载到JVM中
 * 但是classForName还会对类进行解释，执行类中的static代码块
 * 而ClassLoader加载则不会执行static代码块，只有在使用Class<?>的newInstance()方法时才会执行static代码块
 * 注意：classForName加载类也可以对是否解释类，执行static代码块进行配置
 * @author 	lyf
 * 日期：		2017年10月30日
 */
public class ClassLoadAndForName {

	public static void main(String[] args) {
		//classLoaderTest();
		classForNameTest();
	}
	
	//classLoader test
	public static void classLoaderTest(){
		System.out.print("classload test:\t");
		try {
			//此时并不会执行static代码块
			Class<?> white = ClassLoader.getSystemClassLoader().loadClass("lyf.reflect.White");
			//此时会执行static代码块
			White whiteObj = (White) white.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	public static void classForNameTest(){
		System.out.print("classForName Test: \t");
		try {
			//会解释运行static代码块
			Class<?> black = Class.forName("lyf.reflect.Black");
			//通过设置第二个参数为false使其在类加载的时候不运行static代码块
			ClassLoader loader = ClassLoader.getSystemClassLoader();
			Class<?> white = Class.forName("lyf.reflect.White", false, loader);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
