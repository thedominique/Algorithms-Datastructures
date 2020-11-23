package F4;

//pollFirst, pollLast, offerFirst, offerLast och empty

import java.util.NoSuchElementException;

public class DoubleLinkedQueue <E>{
	private static class Node<E> {
		private E data;
		private Node<E> next, prev;

		private Node(E dataItem, Node<E> nodeRef, Node<E> prevref) {
			data = dataItem;
			next = nodeRef;
			prev = prevref;
		}
	}

	private Node<E> front, rear;
	int size;
		

		public DoubleLinkedQueue() {
			size = 0;
			front = null;
			rear = null;
			
		}
		
		public E enqueue (E object){
			if(object ==null) {
				throw new IllegalArgumentException();
			}
			if(size == 0) {
				front = new Node<E>(object, null, null);
				rear = front;
				
			} else {
				rear.next = new Node<E>(object, null, rear);
				rear = rear.next;
			}
			size++;
			return object;
		}
		
		public E dequeue() {
			if(sizeCheck()) {
				if(size>0) {
					size--;
				}
				return null;
			}
			E retval = front.data;
			
			front = front.next;
			size--;
			return retval;
		}
		
		public E pollFirst() {
			return dequeue();
		}
		public E pollLast() {
			if(sizeCheck()) {
				if(size>0) {
					size--;
				}
				return null;
			}
			E retval = rear.data;
			rear = rear.prev;
			rear.next = null;
			size--;
			
			return retval;
		}
		
		private boolean sizeCheck() {
			if(size ==0) {
				throw new NoSuchElementException();
			}
			if(size ==1) {
				front = null;
				rear =null;
				return true;
			}
			return false;
		}
		
		public E offerFirst(E object) {
			if(object == null) {
				throw new IllegalArgumentException();
			}
			
			if(size == 0) {
				front = new Node<E>(object, null, null);
				rear = front;
				
			} else {
				rear.next = new Node<E>(object, null, rear);
				rear = rear.next;
			}
			size++;
			
			return object;
		}
		
		public E offerLast(E obj) {
			return enqueue(obj);
		}
		

		public boolean empty() {
			if(size == 0) {
				return true;
			}
			return false;
		}
		
		@Override
		public String toString() {
			String s = "";
			Node<E> current = front;
			while(current != null) {
				s += current.data + " ";
				current = current.next;
			}
			s+= " size : " + size;
			return s;
		}
}
