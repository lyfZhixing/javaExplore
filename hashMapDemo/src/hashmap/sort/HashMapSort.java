package hashmap.sort;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HashMapSort {

	public static void main(String[] args) {
		Map<Integer , String> map = new HashMap<Integer , String>();
		map.put(1, "a");
		map.put(2, "b");
		map.put(3, "c");
		Set<Integer> set = map.keySet();
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.addAll(set);
		Collections.sort(list);
		
	}
	
}
