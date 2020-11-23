package F3;
import java.util.Stack;
import java.util.EmptyStackException;
import java.util.Scanner;

public class ParenChecker {
	
	private static final String OPEN = "([{";
	private static final String CLOSE = ")]}";
	
	public static boolean isBalanced(String expression) {
		Stack<Character> s = new Stack<Character>();
		boolean balanced = true;
		
		try {
			int index = 0;
			while(balanced && index <expression.length()) {
				char nextCh = expression.charAt(index);
				if(isOpen(nextCh)) {
					s.push(nextCh);
				} else if(isClose(nextCh)) {
					char topCh = s.pop();
					balanced = OPEN.indexOf(topCh) == CLOSE.indexOf(nextCh);
				}
				index++;
			}
		} catch(EmptyStackException ex) {
			balanced = false;
		}
		return (balanced && s.empty());
	}
	
	private static boolean isOpen(char c) {
		return OPEN.indexOf(c) > -1;
	}
	
	private static boolean isClose(char c) {
		return CLOSE.indexOf(c) > -1;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter an expression containing parentaseseseses plz n ty");
		
		String s = scan.nextLine();
		if(ParenChecker.isBalanced(s)) {
			System.out.println("Balanced!");
		} else {
			System.out.println("Not balanced!");
		}
	}
	
}
