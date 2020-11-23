import java.util.ArrayList;
import java.util.Arrays;

public class f1_Darraylist<E> {
	private E[] data;
	private int elements;
	private int max_size;

	public f1_Darraylist() {
		this.elements = 0;
		this.max_size = 10;
		this.data = (E[]) new Object[this.max_size];

	}

	public boolean add(E element) {
		if (this.elements == this.max_size) {
			reallocate();
		}
		this.data[this.elements++] = element;
		return true;
	}

	private void reallocate() {
		this.max_size *= 2;
		data = Arrays.copyOf(this.data, this.max_size);

	}

	public E get(int index) {
		if (index >= 0 && index <= this.max_size)
			return this.data[index];
		throw new ArrayIndexOutOfBoundsException(index);
	}

	public void add(int index, E element) {
		if (index >= 0 && index <= this.max_size) {
			if (this.elements == this.max_size) {
				reallocate();
			}

			for (int i = this.elements; i > index; i--) {
				this.data[i] = this.data[i - 1];
			}
			this.data[index] = element;
			this.elements++;
			return;
		}
		throw new ArrayIndexOutOfBoundsException(index);
	}
	
	/*
	 * Implementera remove, indexOf och set till vår NArrayList från föreläsningen. Försök själv först utan
	att använda boken.
	 */
	
	public boolean remove(E element) {
		
		int index = indexOf(element);
		if(index<0){
			return false;
		}
		
		for(int i = index; i<this.elements; i++) {
			if(i==this.max_size-1) {
				this.data[index] = null;
				break;
			}
			this.data[i] = this.data[i+1];
		}
		this.elements--;
		return true;
	}
	
	public E remove(int index) {
		E object = null;
		if(index>=0 && index < this.max_size-1) {
			object = this.data[index];
			for(int i = index; i<this.elements; i++) {
				if(i==this.max_size-1) {
					this.data[i] = null;
					break;
				}
				this.data[i] = this.data[i+1];
			}
			this.elements--;
			return object;
		}
		throw new ArrayIndexOutOfBoundsException();
	}
	
	
	public int indexOf(E element) {
		for(int i = 0; i < this.elements;i++){
			if(this.data[i]==null&& element ==null) {
				return i;
			}
			if(this.data[i]!= null) {
				if(this.data[i].equals(element)) {
					return i;
				}		
			}
		}
		return -1;
	}
	
	public boolean set(int index, E element) {
		if(index>=0 && index<=this.max_size) {
			if(this.elements>=this.max_size) {
				reallocate();
			}
			
			this.data[index] = element;
		}
		
		throw new ArrayIndexOutOfBoundsException();
	}
	/*
	 * 
	 * 
	 * Krysstal
	 * 
	 * 
	 */
	public static void replace(ArrayList<String> aList, String oldItem, String newItem) {
		for(int i = 0; i<aList.size();i++) {
			if(aList.get(i).equals(oldItem)) {
				aList.set(i, newItem);
			}
		}
	}
	
	public static void delete(ArrayList<String> aList, String target) {
		if(aList.indexOf(target)==-1) {
			return;
		}
		aList.remove(aList.indexOf(target));	
		
	}
	

	@Override
	public String toString() {
		return "f1_Darraylist [data=" + Arrays.toString(data) + ", elements=" + elements + ", max_size=" + max_size
				+ "]";
	}
	
	
}
