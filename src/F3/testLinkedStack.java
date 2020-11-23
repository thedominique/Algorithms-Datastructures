package F3;

public class testLinkedStack {
	LinkedStack ls = new LinkedStack();
	public static void main(String[] args) {
		LinkedStack ls = new LinkedStack();
		System.out.println(ls.empty());
		System.out.println(ls.push(1));
		System.out.println(ls.push(2));
		System.out.println(ls.peek());
		System.out.println(ls.empty());
		System.out.println(ls.flush());
		System.out.println(ls.empty());
	}
}
