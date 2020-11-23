package F3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack <E> implements StackInt<E> {
	
	private E[] data;
	private int top;
	private int maxSize;
	
	public ArrayStack() {
		top = -1;
		maxSize = 10;
		data = (E[]) new Object[maxSize];
	}
	public ArrayStack(int size) {
		top = -1;
		maxSize = size;
		data = (E[]) new Object[maxSize];
	}

	@Override
	public E push(E object) {
		if(top==maxSize-1) {
			reallocate();
		}
		top++;
		data[top] = object;
		return object;
	}
	
	private void reallocate() {
		E[] d = (E[]) new Object[maxSize*2];
		for(int i = 0; i<maxSize;i++) {
			d[i] = data[i];
		}
		data = d;
		maxSize = maxSize*2;
	}

	@Override
	public E pop() {
		E retval = data[top];
		data[top] = null;
		top--;
		return retval;
	}

	@Override
	public E peek() {
		if(empty()) {
			throw new EmptyStackException();
		}
		return data[top];
	}

	@Override
	public boolean empty() {
		return top == -1;
	}

	public E peek(int index) {
		if(empty()) {
			throw new EmptyStackException();
		}
		if(index<0 || index>=maxSize) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return data[index];
	}
	
	public E flush() {
		E retval = data[0];
		data = (E[]) new Object[maxSize];
		maxSize = 10;
		top = -1;
		return retval;
	}

	@Override
	public String toString() {
		return "ArrayStack [data=" + Arrays.toString(data) + ", top=" + top + ", maxSize=" + maxSize + "]";
	}
	
	
	
}
