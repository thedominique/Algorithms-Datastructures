import java.util.List;

public class u1 {

	public static int count(List<String> list, String s) {
		int c = 0;
		for(String i : list) {
			if(s.equals(i)) {
				c++;
			}
		}
		return c;
		
	}
	
}
