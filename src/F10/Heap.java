package F10;

public class Heap <E extends Comparable<E>> {
	
	int size;
	E[] data;
	int nextPos;
	
	public Heap(int size) {
		this.size = size;
		data = (E[]) new Comparable[size];
		nextPos = 0;
	}
	
	
	private int partent(int current) {
		return (current-1)/2;
	}
	
	private int leftChild(int current) {
		return current*2+1;
	}
	private int rightChild(int current) {
		return current*2+2;
	}
	
	
	/*public boolean insert(E data) {
		this.data[nextPos++] = data;
	
	
		public E extract() {
		
	}
		
	}*/
	

	
}
