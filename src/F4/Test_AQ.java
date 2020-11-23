package F4;

public class Test_AQ {
	public static void main(String[] args) {
		ArrayQueue<String> nameQ = new ArrayQueue<String>(10);
		for (int i = 0; i < 8; i++)
			nameQ.offer("e" + (i + 1));
		System.out.println(nameQ.toString());
		nameQ.poll();
		nameQ.poll();
		nameQ.poll();
		nameQ.poll();
		nameQ.poll();
		nameQ.poll();
		System.out.println(nameQ.toString());
		for (int i = 8; i < 14; i++)
			nameQ.offer("e" + (i + 1));
		System.out.println(nameQ.toString());
		while (nameQ.peek() != null)
			System.out.println(nameQ.poll());
		System.out.println(nameQ.toString());
	}
	
}