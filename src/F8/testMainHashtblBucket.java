package F8;

public class testMainHashtblBucket {
	public static void main(String[] args){
		HashTableBucket htb = new HashTableBucket(2);
		htb.put(7, 2);
		htb.put(9, "value");
		System.out.println(htb.toString());
		htb.put(4, "value number 2");
		htb.put("j", "hallå");
		htb.put(0, "hej");
		htb.put(2, "hello");
		htb.put(19, "hello");
		htb.put(3, "Halle");
		System.out.println(htb.toString());
		System.out.println(htb.remove(19));	
		System.out.println(htb.toString());
	}

}
