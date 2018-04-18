package hashmap.demo1;

public interface MyMap<K,V> {
	V put(K k,V v);
	
	V get(K k);
	
	V remove(K k);
	
	int size();
	
	interface Entry<K,V>{
		public K getKey();
		
		public V getValue(K k);
	}
}
