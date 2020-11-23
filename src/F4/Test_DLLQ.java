package F4;

//

public class Test_DLLQ {
	public static void main(String[] args) {
		DoubleLinkedQueue dllq = new DoubleLinkedQueue();
		
		dllq.enqueue("One");
		dllq.enqueue("two");
		dllq.enqueue("three");
		dllq.enqueue("my dog");
		System.out.println(dllq.toString());
		System.out.println(dllq.pollFirst());
		System.out.println(dllq.toString());
		System.out.println(dllq.pollLast());
		System.out.println(dllq.toString());
		
		dllq.offerFirst("one");
		dllq.offerFirst("now");
		dllq.offerFirst("Fumare");
		dllq.pollLast();
		dllq.pollLast();
		dllq.pollLast();
		System.out.println(dllq.toString());
		dllq.pollLast();
		System.out.println(dllq.toString());
		dllq.pollLast();
		System.out.println("TEST [ " + dllq.toString());
		dllq.offerFirst("f");
		dllq.pollFirst();
		//dllq.pollLast();
		//dllq.dequeue();
		System.out.println("[" + dllq.toString());
		dllq.enqueue("One");
		dllq.enqueue("two");
		dllq.enqueue("three");
		dllq.enqueue("my dog");
		System.out.println(dllq.toString());
		
		
	}

}
