package ten100413;

import java.util.Arrays;

public class U4<E> {

	private static class Heap<E> {
		int[] heap;
		int nextPos;

		public Heap(int size) {
			heap = new int[size];
			nextPos = 0;
		}
		
		private void reallocate() {
			int[] nH = new int[heap.length*2];
			for(int i = 0; i<heap.length;i++)
				nH[i] = heap[i];
			heap = nH;
		}
		
		public boolean offer(int data) {
			if(nextPos==heap.length)
				reallocate();
			heap[nextPos++] = data;
			
			int pos = nextPos-1, parent;
			while(pos>=0) {
				parent = (pos-1) /2;
				if(data<heap[parent]) {
					swap(parent, pos);
					pos = parent;
				} else {
					break;
				}
			}
			
			return true;
		}
		
		private void swap(int i, int j) {
			int tmp = heap[i];
			heap[i] = heap[j];
			heap[j] = tmp;
		}
		
		@Override
		public String toString() {
			return Arrays.toString(heap);
		}
		
	}

	public static void main(String[] args) {
		Heap h = new Heap(3);
		h.offer(82);
		h.offer(41);
		h.offer(24);
		h.offer(30);
		h.offer(4);
		h.offer(19);
		h.offer(91);
		h.offer(12);
		System.out.println(h.toString());
	}

	
	
	

}
