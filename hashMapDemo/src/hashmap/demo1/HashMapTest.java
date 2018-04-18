package hashmap.demo1;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class HashMapTest {

	public static void main(String[] args) {
		MyMap<String, Integer> ageMap = new MyHashMap<String, Integer>();
		int v1 = ageMap.put("张三", 23);
		int v2 = ageMap.put("张三", 24);
		int v = ageMap.get("张三");
		int size = ageMap.size();
		System.out.println(v+"  size:"+size);
		
		Map<String, Integer> ageMap2 = new HashMap<String, Integer>();
		ageMap2.put("张三", 23);
		ageMap2.put("张三", 24);
		
		int v5 = ageMap2.get("张三");
		int size1 = ageMap2.size();
		
		
		
		System.out.println(v5+"  size:"+size1);
	}

}
