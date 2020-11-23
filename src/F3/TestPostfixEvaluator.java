package F3;

import java.util.Scanner;

public class TestPostfixEvaluator {
	public static void main(String[] args) {
		PostfixEvaluator evaluator = new PostfixEvaluator();
		String line;
		Scanner in = new Scanner(System.in);
		while (true) {
			System.out.println("Enter a postfix expression to evaluate");
			line = in.nextLine();
			if (!line.equals("")) {
				try {
					int result = evaluator.eval(line);
					System.out.println("Value is " + result);
				} catch (PostfixEvaluator.SyntaxErrorException ex) {
					ex.getMessage();
					System.out.println("Syntax error ");
				}
			} else {
				break;
			}
		}
	}
}
