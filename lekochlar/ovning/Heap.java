package ovning;

public class Heap {

	private int[] heap;
	private int size;

	public Heap() {
		heap = new int[7];
		size = 0;
	}

	public boolean offer(int data) {
		if (size == heap.length)
			return false;

		heap[size] = data;
		int i = size;

		int pi = (i - 1) / 2;

		while (heap[pi] > data && pi >= 0) {
			int tmp = heap[pi];
			heap[pi] = data;
			heap[i] = tmp;
			i = pi;
			pi = (i - 1) / 2;
		}
		size++;
		return true;

	}

	public int poll() {
		int retval = heap[0];
		if(heap[0] == 0)
			return Integer.MAX_VALUE;
		heap[0] = heap[size-1];
		heap[size-1] = 0;
		size--;

		int i = 0;
		int leftkid = 0, rightkid = 0;
		while (i <= size) {
			leftkid = (2 * i) + 1;
			rightkid = (2 * i) + 2;
			if(leftkid > size || rightkid > size)
				return retval;
			System.out.println("index = " + i);
			if(heap[leftkid] == 0 && heap[rightkid] == 0) {
				return retval;
			}
			if(heap[rightkid] == 0 && heap[i] > heap[leftkid])
				i= swap(leftkid, i);

			else if (heap[rightkid] < heap[leftkid] && heap[i] > heap[rightkid])
				i =swap(rightkid, i);
			else if (heap[leftkid] < heap[rightkid] && heap[i] > heap[leftkid])
				i=swap(leftkid, i);
			else {
				return retval;
			}
		}

		return retval;
	}

	private int swap(int l, int i) {
		int tmp = heap[l];
		heap[l] = heap[i];
		heap[i] = tmp;
		System.out.println("Temp is " + tmp);
		return l;
	}

	public String toString() {
		String s = "";
		for (int i = 0; i < size; i++) {
			s += heap[i] + " ";
		}
		return s;
	}
	
	

	public static void main(String[] args) {
		Heap h = new Heap();
		h.offer(15);
		h.offer(17);
		h.offer(16);
		h.offer(30);
		h.offer(29);
		h.offer(18);
		h.offer(19);
		System.out.println(h.toString());
		System.out.println(h.poll());
		System.out.println(h.toString());
	}

}
