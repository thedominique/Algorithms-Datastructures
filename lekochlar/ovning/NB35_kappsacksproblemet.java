package ovning;

import java.util.Arrays;

public class NB35_kappsacksproblemet {
	
	
	private static class p{
		private int w;
		private int val;
		
		public p(int w, int val) {
			this.w = w;
			this.val = val;
		}
		
	}
	
	public static int[] pack(int size) {
		int[] stuff = {0,0,0,0,0};
		pack(size, stuff);
		return stuff;
	}
	
	private static void pack(int size, int[] stuff) {
		int[] weight = {10,5,3,2,1};
		if(size<=0)
			return;
		for(int i = 0; i<weight.length;i++) {
			while(size-weight[i]>=0) {
				stuff[i] += weight[i];
				size-=weight[i];
				pack(size);
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(pack(25)));
	}
}
