package F3;

import java.util.EmptyStackException;

public class LinkedStack<E> implements StackInt<E> {
	private static class Node<E> {
		private E data;
		private Node<E> next;

		private Node(E dataItem, Node<E> nodeRef) {
			data = dataItem;
			next = nodeRef;
		}
	}

	private Node<E> top;

	public LinkedStack() {
		top = null;
	}

	@Override
	public E pop() {
		if (empty()) {
			throw new EmptyStackException();
		} else {
			E result = top.data;
			top = top.next;
			return result;
		}
	}

	@Override
	public E peek() {
		if (empty()) {
			throw new EmptyStackException();
		} else {
			return top.data;
		}
	}

	@Override
	public boolean empty() {
		return top == null;
	}
	
	@Override
	public E push(E object) {
		top = new Node<E>(object, top);
		 return object;
	}
	
	public int size() {
		int s = 0;
		if (empty()) {
			throw new EmptyStackException();
		}
		while(top.next!=null) {
			s++;
		}
		return s;
	}

	public E peek(int n) {
		if(empty()) {
			throw new EmptyStackException();
		}
		if(n<0 || n>=size()) {
			throw new IndexOutOfBoundsException();
		}
		E ret = null;
		for(int i = 0; i<n; i++) {
			ret = top.next.data;
		}
		return ret;
	}
	
	public E flush() {
		while(top.next!=null) {
			top = top.next;
		}
		return this.pop();
	}

	@Override
	public String toString() {
		return "LinkedStack [top=" + top + "]";
	}
	
	
	
}
