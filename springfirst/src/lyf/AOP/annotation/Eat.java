package lyf.AOP.annotation;

import java.util.List;


public class Eat {

	public void eatMeat(){
		System.out.println("吃肉...");
	}
	public void eatRice(){
		System.out.println("吃米饭...");
	}
	/**
	 * 抛出空指针异常验证AfterThrowing("execution(* lyf.AOP.annotation.Eat.drink*(..))")
	 * @throws NullPointerException
	 */
	@SuppressWarnings("null")
	public void drink() throws NullPointerException{
		List<?> list = null;
		list.size();
		System.out.println("喝水...");
	}
	public void drinkWater() throws ClassNotFoundException{
		Class.forName("NotFound");
		System.out.println("喝水...");
	}
	public void taste() {
		System.out.println("品尝...");
	}
}
