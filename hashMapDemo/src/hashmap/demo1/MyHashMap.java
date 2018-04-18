package hashmap.demo1;

public class MyHashMap<K, V> implements MyMap<K, V> {

	//默认容量
	private static int defaultLength = 16;
	//默认系数
	private static double defaultLoder = 0.75;
	//
	private Entry<K, V>[] table = null;
	//
	private int size = 0;
	//
	@SuppressWarnings("unchecked")
	public MyHashMap(int length,double loder){
		defaultLength = length;
		defaultLoder = loder;
		table = new Entry[defaultLength];
	}
	//
	public MyHashMap(){
		this(defaultLength, defaultLoder);
	}
	
	@Override
	public V put(K k, V v) {
		//hash
		int index = hash(k);
		Entry<K,V> entry = table[index];
		if(entry == null){
			
			table[index] = newEntry(k,v, null);
		}else{
			table[index] = newEntry(k,v,entry);
			//输出旧的value值
			System.out.println("old value:"+table[index].next.getValue(k));
		}
		return table[index].getValue(k);
	}

	public Entry<K,V> newEntry(K k,V v,Entry<K,V> next){
		return new Entry<K,V>(k,v,next);
	}
	//hash下标
	public int hash(K k){
		int length = defaultLength;
		int index = k.hashCode()%length;
		return index>=0?index:-index;
	}
	
	@Override
	public V get(K k) {
		V v = null;
		
		for(Entry<K,V> entry : table){
			if(entry != null){
				if(k == entry.getKey()){
					v = entry.getValue(k);
				}
			}
			
		}
		return v;
	}

	@Override
	public int size() {
		int size = 0;
		for(Entry<K,V> entry : table){
			if(entry != null){
				size++;
			}
			
		}
		return size;
	}

	class Entry<K,V> implements MyMap.Entry<K,V>{
		K k;
		V v;
		Entry<K,V> next;
		
		public Entry(K k, V v, Entry<K, V> next) {
			super();
			this.k = k;
			this.v = v;
			this.next = next;
		}

		@Override
		public K getKey() {
			return k;
		}

		@Override
		public V getValue(K k) {
			return v;
		}
		
	}

	@Override
	public V remove(K k) {
		// TODO Auto-generated method stub
		return null;
	}
}
