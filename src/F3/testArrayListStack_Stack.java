package F3;

public class testArrayListStack_Stack {
	public static void main(String[] args) {
		Stack als = new Stack();
		
		System.out.println(als.toString());
		als.push(1);
		als.push(2);
		als.push(3);
		als.push(4);
		System.out.println(als.toString());
		als.pop();
		System.out.println(als.toString());
		System.out.println(als.peek());
		System.out.println(als.empty() + " " + als.size());
		als.push(4);
		als.push(4);
		System.out.println(als.toString());
		als.pop();
		System.out.println(als.toString());
		
	
	}

}
