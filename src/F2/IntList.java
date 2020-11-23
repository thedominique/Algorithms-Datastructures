package F2;

import java.util.Arrays;

public class IntList {
	
	private int[] array;
	private int nrOfElements;
	
	public IntList() {
		this.array = new int[10];
		this.nrOfElements = 0;
	}
	
	public IntList(int initialCapacity) {
		this.array = new int[initialCapacity];
		this.nrOfElements = 0;
	}
	
	public void add(int element) {
		if(this.nrOfElements==this.array.length) {
			reallocate();
		}
		this.array[this.nrOfElements] = element;
		this.nrOfElements++;
	}
	
	public void add(int index, int element) {
		if(index<0 || index>this.nrOfElements) {
			throw new ArrayIndexOutOfBoundsException();
		}
		if(this.nrOfElements==this.array.length) {
			reallocate();
		}
		
		for(int i = this.nrOfElements; i>index; i--) {
			this.array[i] = this.array[i-1];
		}
		this.array[index] = element;
		this.nrOfElements++;
		
	}
	
	public int get(int index) {
		if(index<0 || index>=this.array.length) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return this.array[index];
	}
	
	public int indexOf(int element) {
		for(int i=0; i<this.nrOfElements;i++) {
			if(this.array[i] == element) {
				return i;
			}
		}
		return -1;
	}
	
	public boolean remove(int index) {
		if(index<0 || index>= this.nrOfElements){
			throw new ArrayIndexOutOfBoundsException();
		}
		
		for(int i = index; i<this.nrOfElements; i++) {
			if(i==this.array.length-1) {
				this.array[index] = (Integer) null;
				break;
			}
			this.array[i] = this.array[i+1];
		}
		this.nrOfElements--;
		return true;
	}
	
	public void set(int index, int element) {
		if(index<0 || index>= this.nrOfElements){
			throw new ArrayIndexOutOfBoundsException();
		}
		this.array[index] = element;
	}
	
	public int size() {
		return this.nrOfElements;
	}
	
	private void reallocate() {
		int[] tmp = new int[this.nrOfElements*2];
		for(int i=0; i<this.nrOfElements; i++) {
			tmp[i] = this.array[i];
		}
		this.array = tmp;
	}

	@Override
	public String toString() {
		return "IntList [array=" + Arrays.toString(array) + ", nrOfElements=" + nrOfElements + "]";
	}
	
	
}
