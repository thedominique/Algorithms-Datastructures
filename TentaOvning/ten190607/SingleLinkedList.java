package ten190607;

import java.util.Iterator;

public class SingleLinkedList<E> implements Iterable<E> {

    private class Itr implements Iterator<E> {
    	
    	Node<E> current;
    	
    	public Itr(Node<E> n) {
    		current = n;
    	}
    	
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
            //behöver ej implementeras
        }

		@Override
		public boolean hasNext() {
			if(current!=null)
				return true;
			return false;
		}

		@Override
		public E next() {
			E r = null;
			if(current!=null) {
				r = (E) current.data;
				current = current.next;
			}
			return r;
		}
    }

    private class EvenItr implements Iterator<E> {
    	Node<E> current;
    	
    	public EvenItr(Node<E> n) {
    		current = n;
    	}

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
            //behöver ej implementeras
        }

		@Override
		public boolean hasNext() {
			if(current!=null)
				return true;
			return false;
		}

		@Override
		public E next() {
			E r = null;
			if(current!=null) {
				r = current.data;
				if(current.next!=null)
					current = current.next.next;
				else
					current = null;
			}
			return r;
		}
    }

    @Override
    public Iterator<E> iterator() {
		return new Itr(head);

    }

    public Iterator<E> evenIterator() {
		return new EvenItr(head);

    }

    private static class Node<E> {

        private E data;
        private Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

    }

    private Node<E> head;
    private int size;

    public SingleLinkedList() {
        head = null;
        size = 0;
    }

    public void add(int index, E item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        if (index == 0) {
            addFirst(item);
        } else {
            Node<E> node = getNode(index - 1);
            addAfter(node, item);
        }
    }

    public void addFirst(E item) {
        head = new Node<>(item, head);
        size++;
    }

    private Node<E> getNode(int index) {
        Node<E> node = head;
        for (int i = 0; i < index && node != null; i++) {
            node = node.next;
        }
        return node;
    }

    private void addAfter(Node<E> node, E item) {
        node.next = new Node<>(item, node.next);
        size++;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node<E> node = getNode(index);
        return node.data;
    }

    public boolean add(E item) {
        add(size, item);
        return true;
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

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        E element;
        if (index == 0) {
            element = head.data;
            head = head.next;
        } else {
            Node<E> before = getNode(index - 1);
            element = before.next.data;
            before.next = before.next.next;
        }
        size--;
        return element;
    }

    public int size(){
        return size;
    }
    
    public static void main(String[] args) {
        SingleLinkedList<String> list = new SingleLinkedList<>();
        for (int i = 0; i <= 7; i++)
        {
            list.add("e" + i);
        }
        //uppgift 2a
        for(String d:list)
        {
            System.out.println(d);
        }
        System.out.println("\n");
        //uppgift 2b
        Iterator<String> iter = list.evenIterator();
        while(iter.hasNext())
            System.out.println(iter.next());
    }
    
    
}


