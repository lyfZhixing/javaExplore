package lyf.generic;
/**
 * 先进后出的栈接口Stack
 * <T>是一个泛型，可在实现类中指出具体类型
 * @author 	lyf
 * 日期：		2017年10月25日
 */
public interface Stack<T> {
	/**
	 * 放入一个元素
	 * @param ob
	 */
	void push(T ob);
	/**
	 * 查看最后放入的元素
	 * @return
	 */
	T get();
	/**
	 * 获取最后放入的元素
	 * @return
	 */
	T pop();
}
