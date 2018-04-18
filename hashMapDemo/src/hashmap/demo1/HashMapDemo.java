package hashmap.demo1;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {

	public static void main(String[] args) {
		Map<String,String> hashmap = new HashMap<String, String>();
		hashmap.put("a", "23");
		hashmap.put("a", "32");
		String remove = hashmap.remove("a");
		System.out.println(remove);
	}

}
