
public class testNB0_NB1 {
	public static void main(String[] args) {
		f1_Darraylist test = new f1_Darraylist();
		
		Object o1 = "element 0", o2 = "element 1", o3 = "element 2", o4 = "element 3", o5 = "element 4", 
				nonex = "doesn't exisit", o6 = "hej";
		test.add(o1);
		test.add(o2);
		test.add(o3);
		test.add(o4);
		test.add(o5);
		test.add(null);
		test.add(o2);
		test.add(o3);
		test.add(o4);
		test.add(o6);
		
		System.out.println(test.toString());
		//System.out.println("Remove existing = " + test.remove(o3));
		System.out.println("\nRemove nonexisting = " + test.remove(nonex));
		System.out.println("Remove last : "+ test.remove(o6));
		System.out.println("Remove null : "+ test.remove(null));
		System.out.println(test.toString());
		System.out.println("Test remove w index : " + test.remove(1));
		
	}
}
