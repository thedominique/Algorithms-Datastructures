package F4;

public class Test_LLQ {
	public static void main(String[] args) {
		LinkedQueue lq = new LinkedQueue();
		//lq.dequeue();
		lq.enqueue("one");
		lq.enqueue("two");
		lq.enqueue("three");
		System.out.println(lq.toString());
		lq.dequeue();
		System.out.println(lq.toString());
		lq.dequeue();
		lq.dequeue();
		System.out.println(lq.toString());
		lq.enqueue("one");
		System.out.println(lq.toString());
		
	}

}
