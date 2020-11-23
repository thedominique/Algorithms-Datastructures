package F3;

public class testArrayStack {
	public static void main(String[] args) {
		ArrayStack as = new ArrayStack();
		
		System.out.println(as.toString());
		as.push(1);
		System.out.println(as.toString());
		as.push(2);
		as.push(3);
		System.out.println(as.toString());
		System.out.println(as.peek());
		System.out.println(as.pop());
		System.out.println(as.toString());
		System.out.println(as.flush());
		System.out.println(as.toString());
		ArrayStack as1 = new ArrayStack(2);
		System.out.println(as1.toString());
		as1.push(1);
		as1.push(2);
		as1.push(3);
		System.out.println(as1.toString());
		
	}
}
