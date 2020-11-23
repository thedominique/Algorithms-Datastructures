package F2;

public class F2_testMain {
	public static void main(String[] args) {
		IntList ill = new IntList(2);
		ill.add(1);
		ill.add(2);
		System.out.println(ill.toString());
		ill.add(3);
		System.out.println(ill.toString());
		System.out.println(ill.size());
		ill.remove(0);
		System.out.println(ill.toString());
		ill.add(1, 7);
		System.out.println(ill.toString());
		System.out.println(ill.get(0));
		System.out.println(ill.indexOf(7));
		ill.set(0, 0);
		System.out.println(ill.toString()+ "\n\n");
		
		/*
		 * node test
		 * ”Gilgamesh” -> ”löper” -> ”på” -> ”stäppen
		 */
		
		Node n = new Node();
		
		n.data = "Gilgamesh";
		n.next = new Node();
		
		n.next.data = "löper";
		n.next.next = new Node();
		n.next.next.data = "på";
		n.next.next.next = new Node();
		n.next.next.next.data = "stäppen";
		
		
		/*while(n !=null) {
			System.out.print(n.data + " ");
			n= n.next;
		}*/
		
		while(n !=null) {
			if(n.data == "löper") {
				n.next = n.next.next;
			}
			System.out.print(n.data + " ");
			n = n.next;
		}
		
		/* Node n = new Node();
		 * Node n1 = new Node();
		 * Node n2 = new Node();
		 * Node n3 = new Node();
		 * 
		 * n.data = "Gilgamesh";
		 * n1.data = "löper";
		 * n2.data = "på";
		 * n3.data = "stäppen";
		 * 
		 * 
		 * while(n !=null) {
			if(n1) {
				n.next = n.next.next;
			}
			System.out.print(n.data + " ");
			n= n.next;
		}
		 * 
		 */
		
	}
	
	
	
}
