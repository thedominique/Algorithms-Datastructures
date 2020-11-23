package F3;

import java.util.ArrayList;
import java.util.EmptyStackException;

/*
 * Implementera en stack med en ArrayList som inre datastruktur (ärv inte). Klassen skall implementera
interfacet från föreläsningen. Skriv också en main som testar att klassens alla funktioner verkar
fungera
 */
public class Stack <E> implements StackInt<E> {
	
	private ArrayList<E> data;
	private int top;
	private int maxSize;
	
	public Stack() {
		top = -1;
		maxSize = 10;
		data = new ArrayList<E>();
	}

	@Override
	public E push(E object) {
		data.add((E) object);
		top++;
		return object;
	}

	@Override
	public E pop() {
		if(top ==-1) {
			throw new EmptyStackException();
		}
		E ret = data.get(top);
		data.remove(top);
		top--;
		return ret;
	}

	@Override
	public E peek() {
		if(top ==-1) {
			throw new EmptyStackException();
		}
		return data.get(top-1);
	}

	@Override
	public boolean empty() {
		if(top ==-1) {
			return true;
		}
		return false;
	}
	
	
	public int size() {
		return data.size();
	}
	
	public E peek(int index) {
		if(top ==-1) {
			throw new EmptyStackException();
		}
		return data.get(index);
	}

	@Override
	public String toString() {
		return "Stack [data=" + data + ", top=" + top + ", maxSize=" + maxSize + "]";
	}
	
	
}
