package F8;

import java.util.Arrays;
import java.util.Iterator;

public class HashTableBucket<K, V> {
	private static class Entry<K, V> {
		public K key;
		public V value;

		public Entry(K k, V v) {
			key = k;
			value = v;
		}
		
		public K getKey() {
			return key;
		}
		public V getValue() {
			return value;
		}
		
		@Override
		public String toString() {
			return "Key: "+key.toString() +" value: "+ value.toString();
		}
	}

	private SingleLinkedList<Entry<K, V>>[] table;

	@SuppressWarnings("unchecked")
	public HashTableBucket(int size) {
		table = new SingleLinkedList[size];
	}

	public V put(K key, V value) {
		if(nrOfEntries() >= table.length*0.75) 
			reallocate();
		int index = key.hashCode() % table.length;
		if (index < 0)
			index += table.length;
		if (table[index] == null) {
			table[index] = new SingleLinkedList<Entry<K, V>>();
			table[index].add(new Entry<K, V>(key, value));
			return null;
		} else {
			V oldValue;
			for (Entry<K, V> e : table[index]) {
				if (e.key.equals(key)) {
					oldValue = e.value;
					e.value = value;
					return oldValue;
				}
			}
			table[index].add(0, new Entry<K, V>(key, value));
			return null;
		}
	}
	
	private int nrOfEntries() {
		int nrOfEntries = 0, index = table.length-1;
		while(index>=0) {
			if(table[index]!= null) {
				for(Entry<K, V> e : table[index]) {
					if(e!=null)
						nrOfEntries++;
				}
			}
			index--;
		}
		
		return nrOfEntries;
	}


	public V get(K key) {
		int index = key.hashCode() % table.length;
		if (index < 0)
			index += table.length;
		if (table[index] == null)
			return null;
		for (Entry<K, V> e : table[index]) {
			if (e.key.equals(key))
				return e.value;
		}
		return null;
	}
	
	public V remove(K key) {
		int index = key.hashCode() % table.length;
		if (index < 0)
			index += table.length;
		if(table[index] == null) return null;
		
		V retval = get(key);
		Iterator <Entry<K, V>> it = table[index].iterator();
		
		while(it.hasNext()) {
			Entry<K, V> e = it.next();
			if(e.key.equals(key)) {
				it.remove();
			}
		}
		
		return retval;
	}
	
	//NB 25
	private void reallocate() {
		HashTableBucket nh = new HashTableBucket(table.length*2);
		int i = 0;
		for(SingleLinkedList<Entry<K, V>> n: table) {
			if(n!=null) {
				for(Entry<K,V> e : n) {
					nh.put(e.key, e.value);
				}
				}
			i++;
			}
				
		table = nh.table;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		int i = 0;
		for(SingleLinkedList<Entry<K, V>> n: table) {
			if(n!=null)
				sb.append("Index : "+i+ " "+n.toString()+ "\n");
			i++;
		}
		
		return sb.toString();
	}
	
	public String abToString() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < table.length; i++) {
			if(table[i] != null) {
				for(Entry n : table[i]) {
					sb.append(n.toString());
				}
			} 
		}
		return sb.toString();	
	}
	
	public String domsToString() {
		return Arrays.toString(table);
	}
	
}