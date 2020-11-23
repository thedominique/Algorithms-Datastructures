package F4;


// NB8


import java.util.AbstractQueue;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayQueue<E> extends AbstractQueue<E> {
	private int front, rear, size, maxSize;
	private E[] data;

	public ArrayQueue(int initialMaxSize) {
		size = 0;
		front = 0;
		maxSize = initialMaxSize;
		rear = maxSize - 1;
		data = (E[]) new Object[maxSize];
	}

	public boolean offer(E element) {
		rear = (rear + 1) % maxSize;
		data[rear] = element;
		size++;
		return true;
	}

	public E peek() {
		if (size == 0)
			return null;
		return data[front];
	}

	public E poll() {
		if (size == 0) {
			return null;
		} else {
			size--;
			E element = data[front];
			front = (front + 1) % maxSize;
			if(size == maxSize/4) {
				deallocate();
			}
			return element;
		}
	}

	private void reallocate() {
		int newMaxSize = 2 * maxSize;
		E[] newData = (E[]) new Object[newMaxSize];
		int j = front;
		for (int i = 0; i < size; i++) {
			newData[i] = data[j];
			j = (j + 1) % maxSize;
		}
		front = 0;
		rear = size - 1;
		maxSize = newMaxSize;
		data = newData;
	}
	
	private void deallocate() {
		E[] newData = (E[]) new Object[maxSize/2];
		int j = front;
		for(int i = 0; i < size; i++) {
			newData[i] = data[front];
			j = (j + 1) % maxSize;
		}
		
		front = 0;
		rear = size - 1;
		maxSize = maxSize/2;
		data = newData;
		
	}

	@Override
	public Iterator<E> iterator() {
		return new Iter();
	}

	@Override
	public int size() {
		return size;
	}

	private class Iter implements Iterator<E> {
		private int index;
		private int count = 0;

		public Iter() {
			index = front;
		}

		@Override
		public boolean hasNext() {
			return count < size;
		}

		@Override
		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			E returnValue = data[index];
			index = (index + 1) % maxSize;
			count++;
			return returnValue;
		}

		@Override
		public void remove() {
			// ska endast kunna ta bort det första
			
			size--;
			front = (front + 1) % maxSize;
			if(size == maxSize/4) {
				deallocate();
			}
			
			throw new UnsupportedOperationException();
		}
	}

	@Override
	public String toString() {
		return "ArrayQueue [front=" + front + ", rear=" + rear + ", size=" + size + ", maxSize=" + maxSize + ", data="
				+ Arrays.toString(data) + "]";
	}
		
	
}
