package NB33_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class NB_32 {
	/*
	 * list = new Node[8];
		list[0] = new Node(0, 0, new Node(1, 2, new Node(5, 1, null)));
		list[1] = new Node(1, 0, new Node(0, 2, new Node(2, 2, new Node(3, 2, new Node(4, 4, null)))));
		list[2] = new Node(2, 0, new Node(1, 2, new Node(4, 3, new Node(7, 1, null))));
		list[3] = new Node(3, 0, new Node(1, 2, new Node(4, 3, new Node(5, 1, null))));
		list[4] = new Node(4, 0, new Node(2, 3, new Node(3, 3, new Node(6, 7, null))));
		list[5] = new Node(5, 0, new Node(0, 1, new Node(3, 1, new Node(6, 5, null))));
		list[6] = new Node(6, 0, new Node(4, 7, new Node(5, 5, new Node(7, 6, null))));
		list[7] = new Node(7, 0, new Node(2, 1, new Node(6, 6, null)));
		
	 */
	private Node[] list;
	private String[] nodes;
	private String[] data;
	private int[] d;
	
	public NB_32(String filename) throws Exception{
		File file = new File(filename);
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		String st;
		
		list = new Node[8];
		int count = 0;
		Node current = null;
		while((st = br.readLine()) != null) {
			nodes = st.split(", ");
			for(int i = 0; i < nodes.length; i++) {
				data = nodes[i].split(" ");
				if(data[0].length() == 0) {
					break;
				}
				if(list[count] == null) {
					list[count] = new Node((int)(data[0].charAt(0) - 'A'), Integer.parseInt(data[1]), null);
					current = list[count];
				}
				else{
					current.next = new Node((int)data[0].charAt(0) - 'A', Integer.parseInt(data[1]), null);
					current = current.next;
				}
			}
			count++;
		}
	}
	
	// går igenom d, kollar om maxval & inte är tagen. ändrar index om index är större än d[i], returnerar minsta index
	public int next(int[] d, boolean[] taken) {
		int index = Integer.MAX_VALUE;
		int minindex = 0;
		for(int i = 0; i < d.length; i++) {
			if(d[i] < index && taken[i] == false) {
				index = d[i];
				minindex = i;
			}
		}
		return minindex;
	}
	
	public int[] dijkstra(char start_, char end_) {
		int start = (int) start_ - 'A';
		int end = (int) end_ - 'A';
		int count = 0;
		for(int i = 0; i < list.length; i++) {
			if(list[i] != null) {
				count++;
			}
		}
		this.d = new int[count];
		Arrays.fill(d, Integer.MAX_VALUE);
		d[start] = 0;
		int p[] = new int[count]; 
		Arrays.fill(p, 0);
		boolean[] checked = new boolean[count];
		for(int i = 0; i < d.length; i++) {
			int u = next(d, checked);
			checked[u] = true;
			Node src = list[u];
			Node current = list[u];
			while(current != null) {
				if(current.weight < d[current.value] && checked[current.value] == false) {    													//
					d[current.value] = current.weight;
					p[current.value] = src.value;
				}
				current = current.next;
			}
		}
		
		return p;
	}
	public void linkNodes(String[] nodes, Node node) {
		
	}
	
	public static void saveToFile(Node[] list) throws IOException {
		StringBuilder sb = new StringBuilder();
		Node current;
		for(int i = 0; i < list.length; i++) {
			current = list[i];
			while(current != null) {
				if(current.next != null)
				sb.append((char)(current.value + 'A') + " " + current.weight + ", ");
				else
				sb.append((char)(current.value + 'A') + " " + current.weight);
				current = current.next;
			}
			sb.append("\n");
		}
		BufferedWriter writer = new BufferedWriter(new FileWriter("test.txt"));
		writer.write(sb.toString());
		writer.close();
	}
	
	private static class Node{
		private int value;
		private Node next;
		private int weight;
		
		public Node(int value, int weight, Node next) {
			this.value = value;
			this.weight = weight;
			this.next = next;
		}
		
		@Override
		public String toString() {
			if(this.next != null)
			return ((char)(this.value + 'A')) + " " + this.weight;
			return ((char)(this.value + 'A')) + " " + this.weight;
		}
	}
	
	public static void main(String[] args) {
		NB_32 list = null;
		try {
			list = new NB_32("testy.txt");
		} catch (Exception e2) {
			System.out.println("Failed to open file");
			e2.printStackTrace();
		}
		System.out.println(list.toString());
		int p[] = list.dijkstra('A', 'H');		
		System.out.println(Arrays.toString(p));
		System.out.println("Node A var start nod");
		for(int i = 1; i < p.length; i++) {
			System.out.println("Nod " + (char)(i+'A') + " anslöts via " + (char)(p[i] + 'A'));
		}
		int distance = 0;
		for(int i = 1; i < p.length; i++) {
			distance += list.d[i];
		}
		System.out.println("Totalvikt: " + distance);
		/*try {
			list.saveToFile(list.list);
		} catch (IOException e) {
			System.out.println("failed to save file");
			e.printStackTrace();
		}*/
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node current;
		for(int i = 0; i < list.length; i++) {
			current = list[i];
			while(current != null) {
				if(current.next != null)
				sb.append("Node " + (char)(current.value + 'A') + " Weight: " + current.weight + " => ");
				else
				sb.append("Node " + (char)(current.value + 'A') + " Weight: " + current.weight);
				current = current.next;
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}