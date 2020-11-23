package F4;

import java.util.NoSuchElementException;

public class LinkedQueue <E> {


	/* NB9 Implementera en kö med en enkellänkad lista med en pekare till varje ända av listan så att alla
	//operationer blir O(1). Det räcker om du implementerar enqueue (offer), dequeue (poll) och size.*/
	
	private static class Node<E> {
		private E data;
		private Node<E> next;

		private Node(E dataItem, Node<E> nodeRef) {
			data = dataItem;
			next = nodeRef;
		}
	}

	private Node<E> front, rear;
	int size;
		

		public LinkedQueue() {
			size = 0;
			front = null;
			rear = null;
			
		}
		
		public E enqueue (E object){
			if(object ==null) {
				throw new IllegalArgumentException();
			}
			if(size == 0) {
				front = new Node<E>(object, null);
				rear = front;
				
			} else {
				rear.next = new Node<E>(object, null);
				rear = rear.next;
			}
			size++;
			return object;
		}
		
		public E dequeue() {
			if(size ==0) {
				throw new NoSuchElementException();
			}
			E retval = front.data;
			
			front = front.next;
			size--;
			return retval;
		}

		@Override
		public String toString() {
			String s = "";
			Node<E> current = front;
			while(current != null) {
				s += current.data + " ";
				current = current.next;
			}
			return s;
		}

	

}
