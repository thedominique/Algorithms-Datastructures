package ovning;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class HeapSortNB29 {

	int[] heap;
	int size;

	public HeapSortNB29(int size) {
		heap = new int[size];
		size = 0;
	}

	public boolean insert(int e) {
		heap[size] = e;

		int p = (size - 1) / 2, c = size;
		while (p <= 0) {
			if (heap[p] < e) {
				swap(c, p);
				c = p;
				p = (c - 1) / 2;
			} else {
				break;
			}
			
		}


		size++;
		return true;
	}

	private int indexOf(int e) {
		for (int i = 0; i < size; i++) {
			if (heap[i] == e)
				return i;
		}
		throw new NoSuchElementException();

	}
	
	private void swap(int child, int parent) {
		int tmp = heap[child];
		heap[child] = heap[parent];
		heap[parent] = tmp;
	}

	public int extract() {
		int rv = heap[0];

		heap[0] = heap[size - 1];
		heap[size] = 0;
		size--;

		int p = 0;
		boolean cont = true;
		while (cont) {
			int l = 2 * p + 1, r = 2 * p + 2;
			if (heap[l] != 0 && heap[r] != 0) {
				int i = indexOf(Math.max(heap[l], heap[r]));
				if (heap[p] < heap[i]) {
					swap(i, p);
					p = i;
				}
			}

			if (heap[l] == 0 && heap[r] > heap[p]) {
				swap(r, p);
				p = r;
			}
			if (heap[r] == 0 && heap[l] > heap[p]) {
				swap(l, p);
				p = l;
			}

			if (heap[p] > heap[l] && heap[p] > heap[r] || heap[p] == heap[l] && heap[p] == heap[r])
				cont = false;
		}
		return rv;
	}
	
	public void offer(int e, int pos) {
		for(int i = heap.length-1;i>pos;i--) {
			heap[i+1]=heap[i];
		}
		heap[pos] = e;
	}
	
	

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		int exponent = 3;
		for (int i = 0; i < size; i++) {
			sb.append(heap[i] + " ");
			if (i == 0 || i == 2)
				sb.append("\n");
			if (i == Math.pow(2, exponent) - 2) {
				sb.append("\n");
				exponent += 1;
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		HeapSortNB29 h = new HeapSortNB29(20);
		h.insert(1);
		// System.out.println(h.toString());
		h.insert(5);
		// System.out.println(h.toString());
		h.insert(4);
		h.insert(3);
		h.insert(3);
		h.insert(-3);
		h.insert(-1);
		h.insert(7);
		h.insert(-13);
		h.insert(-19);
		h.insert(2);
		h.insert(1);
		h.insert(8);
		h.insert(3);
		h.insert(-2);
		System.out.println(h.toString());
		System.out.println(h.extract() + "\n");

		// System.out.println(h.toString());
		System.out.println(h.extract() + "\n");
		System.out.println(h.toString());

	}

}
