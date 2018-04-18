package lyf.generic;

import java.util.ArrayList;
/**
 * 利用ArrayList实现栈的数据结构
 * @author 	lyf
 * 日期：		2017年10月25日
 */
public class ArrayListStatck implements Stack<String> {

	private static ArrayList<String> list = new ArrayList<String>();
	
	public static void main(String[] args) {
		Stack<String> stack = new ArrayListStatck();
		
		stack.push("a");	//list: a
		stack.push("b");	//list: ba
		stack.push("c");	//list: cba
		stack.push("d");	//list: dcba
		
		System.out.println(stack.get());	//d
		System.out.println(stack.pop());	//d
		System.out.println(stack.get());	//c
	}
	
	/**
	 * 往栈中添数据，ArrayList是有序有下标的，栈是先进后出的
	 */
	@Override
	public void push(String ob) {
		
		ArrayList<String> list2 = new ArrayList<String>();
		list2.add(ob);//c
		for(int i = 0; i < list.size(); i++){
			list2.add(list.get(i));//c,b,a
		}
		list = list2;
		
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
		
		list = new ArrayList<String>();
		for(int i = 0; i < size-1; i++){
			list.add(list2.get(i+1));
		}
		
		return last;
	}


}
