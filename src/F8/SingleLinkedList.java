package F8;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class SingleLinkedList<E> implements Iterable<E>{
	private static class Node<E>   {
		private E data;
		private Node<E> next;

		public Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + ", next=" + next.data + "]";
		}
		
	}
	
	@Override
	public Iterator<E> iterator() {
		return new Itr(head);
	}

	private Node<E> head;
	

	public SingleLinkedList() {
		head = null;
		
	}

	public void add(int index, E item) {
		if (index < 0 || index > getSize()) {
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}
		if (index == 0) {
			addFirst(item);
		} else {
			Node<E> node = getNode(index - 1);
			addAfter(node, item);
		}
	}

	private void addAfter(Node<E> node, E item) {
		node.next = new Node<E>(item, node.next);
	}

	public void addFirst(E item) {
		head = new Node<E>(item, head);
	}

	private Node<E> getNode(int index) {
		Node<E> node = head;
		for (int i = 0; i < index && node != null; i++) {
			node = node.next;
		}
		return node;
	}
	
	public int getSize() {
		int size = 0;
		Node<E> node = head;
		for (int i = 0; node != null; i++) {
			node=node.next;
			size++;
		}
		return size;
	}

	public boolean add(E item) {
		add(getSize(), item);
		return true;
	}

	public E get(int index) {
		if (index < 0 || index >= getSize()) {
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}
		Node<E> node = getNode(index);
		return node.data;
	}

	public E remove(int index) {
		if (index < 0 || index >= getSize()) {
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}
		if (head == null) {
			throw new IllegalStateException();
		}
		Node<E> node = head;
		if (index == 0) {
			return removeFirst();
		}
		E data;
		for (int i = 0; i < index - 1 && node != null; i++) {
			if (node.next.next == null) {
				data = node.next.data;
				node.next = null;
				return data;
			}
			node = node.next;
		}
		data = node.next.data;
		node.next = node.next.next;
		return data;
	}

	private E removeFirst() {
		E data = head.data;
		if (head.next == null) {
			head = null;

		} else {
			head = head.next;
		}
		return data;
	}
	
	

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		Node<E> p = head;
		if (p != null) {
			while (p.next != null) {
				sb.append(p.data.toString());
				sb.append(" ==> ");
				p = p.next;
			}
			sb.append(p.data.toString());
		}
		sb.append("]");
		return sb.toString();
	}

	private class Itr implements Iterator<E> {// nested class – ligger i SingleLinkedList
		Node<E> current, previous, b4;
		boolean next, removed;

		public Itr(Node<E> start) {
			current = start;
			previous = null;
			b4 = null;
			next = false;
			removed = false;
		}

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public E next() {
			if (current == null) {
				throw new NoSuchElementException();
			}
			E returnValue = current.data;
			
			if(previous == null) {
				previous = current;
				current = current.next;
				
			} else if(b4 == null) {
				b4 = previous;
				previous = current;
				current = current.next;
			} else if(removed == true) {
				current = current.next;
				previous = previous.next;
			} else {
				current = current.next;
				previous = previous.next;
				b4 = b4.next;
			}
			next = true;
			removed = false;
			
			return returnValue;
		}

		@Override
		public void remove() {
			if(next==false) {
				throw new IllegalStateException();
			}
			// ta bort enda
			if(b4 == null && current == null) { //previous.next == null
				previous = null;
				head = null;
			} 
			// ta bort sista
			else if(current == null ) {
				previous = null; //nödvändig?
				b4.next = null;
				
			} 
			// ta bort första
			else if(b4 == null){
				previous = null;
				head = head.next;
			}
			// ta bort mitten
			else {
				b4.next = current;
			}
			
			removed = true;
			next = false;
		}

		@Override
		public String toString() {
			return "Itr [current=" + current.data + ", prev=" + previous.data + ", b4"+ b4.data+" ]";
		}

	}
}
