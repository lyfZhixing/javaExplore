package lyf.generic;

import java.util.ArrayList;
/**
 * 利用ArrayList实现栈的数据结构
 * @author 	lyf
 * 日期：		2017年10月25日
 */
public class ArrayListStack2 implements Stack<String> {

private static ArrayList<String> list = new ArrayList<String>();
	
	public static void main(String[] args) {
		Stack<String> stack = new ArrayListStatck();
		
		stack.push("a");	//list: a
		stack.push("b");	//list: ab
		stack.push("c");	//list: abc
		stack.push("d");	//list: abcd
		
		System.out.println(stack.get());	//d
		System.out.println(stack.pop());	//d
		System.out.println(stack.get());	//c
	}
	
	/**
	 * 往栈中添数据，ArrayList是有序有下标的，栈是先进后出的
	 */
	@Override
	public void push(String ob) {
		list.add(ob);
	}

	@Override
	public String get() {
		return list.get(list.size()-1);
	}

	@Override
	public String pop() {
		
		String last = get();
		int size = list.size();
		ArrayList<String> list2 = list;
		for(int i = 0; i < size-1; i++){
			list2.add(list.get(i));
		}
		list = list2;
		return last;
	}

}
