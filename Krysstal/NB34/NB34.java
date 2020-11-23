package NB34;

import java.util.Arrays;

public class NB34 {
	
	/*
	 * Lös växlingsproblemet med en girig algoritm. Skriv en metod som tar växlingssumman och en intarray med de olika tillgängliga valutorna I fallande ordning och returnerar en int-array med antalet av
varje valuta. Ex. Man vill veta växeln för 789 kr I vår valuta. Man anropar då:
change(789,new int[] {1000,500,100,50,20,10,5,1})
som då returnerar: {0,1,2,1,1,1,1,4}.
	 */
	
	public static int[] change(int change, int[] currency) {
		int i = 0;
		int[] c = new int[currency.length];
		while(change>0) {
			if((change - currency[i]) >= 0) {
				change -= currency[i];
				c[i]++;
			}
			else
				i++;
		}
		return c;
	}
	
	public static void main(String[] args) {
		
		int sum = 789;
		
		System.out.println("To convert " + sum + " we used :" + Arrays.toString(change(sum, new int[] {1000,500,100,50,20,10,5,1})));
		
	}

}
