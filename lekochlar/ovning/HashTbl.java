package ovning;

import java.util.LinkedList;

public class HashTbl <K, V>{
	
	private LinkedList<Entry<K,V>>[] table;
	
	private static class Entry<K, V> {
		public K key;
		public V value;
		
		public Entry(K k, V v) {
			key = k;
			value = v;
		}

		public V getValue() {
			return value;
		}
		
	}
	
	

}
