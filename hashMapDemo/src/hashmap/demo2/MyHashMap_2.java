package hashmap.demo2;

import java.io.Serializable;

import hashmap.demo1.MyMap;

public class MyHashMap_2<K,V> implements MyMap<K, V>,Serializable {

	/**
	 * 不能运行
	 */
	private static final long serialVersionUID = 1L;
	//默认数组长度
	static int DEFAULT_INITIAL_CAPACITY = 1<<4; //16
	//最大容量
	static final int MAXIMUM_CAPACITY = 1<<30;//2的30次方
	//默认加载因子
	static float DEFAULT_LOAD_FACTOR = 0.75f ;
	//数据实际存储的位置
	transient Entry<K,V>[] table;
	//数组大小
	transient int size;
	//扩容后的阈值
	int threshold;
	
	@SuppressWarnings("unchecked")
	public MyHashMap_2(int length,float loder){
		DEFAULT_INITIAL_CAPACITY = length;
		DEFAULT_LOAD_FACTOR = loder;
		table = new Entry[DEFAULT_INITIAL_CAPACITY];
	}
	public MyHashMap_2(){
		this(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR);
	}
	
	//存
	@Override
	public V put(K k, V v) {
		//hash
		if(k == null){
			//当key为null时，调用putForNullKey方法，放入到table[0]的这个位置（null键只有一个）
		}
		//获取k的哈希值
		//目的在于尽可能的让键值对可以分到不同的桶（bucket）中
		int hash = myHash(k);
		//获取table数组的索引下标
		int index = indexFor(hash,table.length);
		//如果i处的Entry不为null，则通过其next引用不断便利e元素的下一个元素
		for(Entry<K,V> entry = table[index]; entry != null;entry = entry.next){
			//使用临时变量k主要用于entry.k赋值
			K key;
			//hash一致并且（key引用相同 或 key字符串比较相同）
			if(myHash(entry.k) == hash && ((key = entry.k) == key || k.equals(key))){
				//值变更
				V oldValue = entry.v;
				entry.v = v;
				//若存在返回旧值
				return oldValue;
			}
		}
		addEntry(hash,k,v,index);
		return null;
	}
	
	//hash算法散列 
	//jdk1.8扰动函数，散列值优化函数
	public int myHash(K k){
		int hash;
		//把一个数右移16位，就是任何小于2的16次方的数，右移16位后结果都为0
		//2的16次方再右移刚好就是1同时int最大值位32位
		//任何一个数，与0按位或的结果都是这个数的本身
		//为求数组下标做准备
		return (k == null) ? 0 : (hash = k.hashCode()) ^ (hash >>> 16);
	}
	
	//获取数组下标
	public int indexFor(int hash,int length){
		//length一定为2的幂
		//2次幂-1，返回的结果的二进制永远都是1，例：16-1=15 -> 1111( 16 -> 10000)
		//与运算 只有 1 & 1 = 1 正好相当于一个“低位掩码”
		//如果length-1中某一位为0，则不论h中对应位的数字为几，其对应位结果都为0
		//这样进行与运算可以保证索引不会大于数组的大小
		//此时的二进制与运算，相当于取模
		return hash & (length-1);
	}
	
	public void addEntry(int hash, K key,V value,int bucketIndex){
		//当前容量超过阈值 && 当前坐标数组非空
		//若bucketIndex处没有Entry对象那么新添加的entry对象指向null，从而就不会有链利润
		if((size >= threshold) && (null != table[bucketIndex])){
			//扩容2倍
			resize(2*table.length);
		}else{
			Entry<K,V> e = table[bucketIndex];
			table[bucketIndex] = new Entry<K,V>(key, value, e);
			size++;
		}
	}
	
	public void resize(int newCapacity){
		Entry[] oldTable = table;//临时拷贝，保证当前数据失效性
		
	}
	
	@Override
	public V get(K k) {
		V value = null;
		
		return value;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public V remove(K k) {
		// TODO Auto-generated method stub
		return null;
	}

	public final class Entry<K,V> implements MyMap.Entry<K, V>{
		K k;
		V v;
		Entry<K,V> next;
		
		@Override
		public K getKey() {
			return k;
		}

		@Override
		public V getValue(K k) {
			return v;
		}
		
		public Entry(K k,V v,Entry<K,V> next){
			this.k = k;
			this.v = v;
			this.next = next;
			
		}
		
		
	}
	
}
