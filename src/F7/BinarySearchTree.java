package F7;

import java.util.Scanner;

public class BinarySearchTree<E extends Comparable<E>> {
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Node n = new Node("hej");
		BinarySearchTree bt = new BinarySearchTree();
		/*int a = 7;
		while(a>0) {
			System.out.println("Enter your word: ");
			bt.add(scan.nextLine());
			a--;
		}*/
		bt.add(4);
		bt.add(2);
		bt.add(6);
		bt.add(3);
		bt.add(1);
		bt.add(5);
		bt.add(7);
		
		
		System.out.println(bt.toString());
		//bt.delete("2");
		//4System.out.println(bt.toString());
		System.out.println(bt.toStringPreOrd());
		System.out.println(bt.toStringPostOrd());
		System.out.println(bt.numberOfLeaves());
		System.out.println(bt.numberOfNodes());
	}
	

	private static class Node<E> {
		private E data;
		private Node<E> left, right;

		private Node(E d) {
			data = d;
			left = right = null;
		}

		@Override
		public String toString() {
			return data.toString();
		}
	}

	private Node<E> root;
	private E deletedData;

	public BinarySearchTree() {
		root = null;
	}
	
	public int numberOfLeaves() {
		return numberOfLeaves(root);
	}

	private int numberOfLeaves(Node<E> node) {
		if(node.left==null && node.right == null)
			return 1;
		return numberOfLeaves(node.left) + numberOfLeaves(node.right);
	}
	
	public int numberOfNodes() {
		return numberOfNodes(root);
	}

	private int numberOfNodes(Node<E> node) {
		if(node==null)
			return 0;
		return 1+ numberOfNodes(node.left) + numberOfNodes(node.right);
	}

	private void inOrder(Node<E> node, StringBuilder sb) {
		if (node != null) {
			inOrder(node.left, sb);
			sb.append(":" + node.toString());
			inOrder(node.right, sb);
		}
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		inOrder(root, sb);
		return sb.toString();
	}
	
	private void preOrder(Node<E> node, StringBuilder sb) {
		if(node != null) {
			sb.append(":" +node.toString());
			preOrder(node.left, sb);
			preOrder(node.right, sb);
		}
	}
	public String toStringPreOrd() {
		StringBuilder sb = new StringBuilder();
		preOrder(root, sb);
		return sb.toString();
	}
	
	private void postOrder(Node<E> node, StringBuilder sb) {
		if(node != null) {
			postOrder(node.left, sb);
			postOrder(node.right, sb);
			sb.append(":" +node.toString());
		}
	}
	public String toStringPostOrd() {
		StringBuilder sb = new StringBuilder();
		postOrder(root, sb);
		return sb.toString();
	}
	

	private boolean add(E data, Node<E> node) {
		if (data.compareTo(node.data) == 0)
			return false;
		else if (data.compareTo(node.data) < 0)
			if (node.left == null) {
				node.left = new Node<E>(data);
				return true;
			} else
				return add(data, node.left);
		else if (node.right == null) {
			node.right = new Node<E>(data);
			return true;
		} else
			return add(data, node.right);
	}
	
	public boolean add(E data) {
		if(root == null) {
			root = new Node<E>(data);
			return true;
		} else
			return add(data, root);
	}
	
	public E find(E target) {
		return find(target, root);
	}
	private E find(E target, Node<E> node) {
		if(node == null)
			return null;
		if(target.compareTo(node.data)== 0)
			return node.data;
		if(target.compareTo(node.data)<0)
			return find(target, node.left);
		return find(target, node.right);
	}
	
	public E delete(E target) {
		root = delete(target, root);
		return deletedData;
	}
	private Node<E> delete(E target, Node<E> node) {
		if(node == null){
			deletedData = null;
			return null;
		} else {
			if(target.compareTo(node.data)<0) {
				node.left = delete(target, node.left);
				return node;
			} else if(target.compareTo(node.data)>0) {
				node.right = delete(target, node.right);
				return node;
			} else {
				deletedData = node.data;
			}
		}
		
		if(node.left == null)
			return node.right;
		else if(node.right == null)
			return node.left;
		else {
			Node<E> nodeToMove = node.right, parentNodeToMove = node;
			if(nodeToMove.left == null) {
				nodeToMove.left = node.left;
				return nodeToMove;
			}
			while(nodeToMove.left!=null) {
				parentNodeToMove = nodeToMove;
				nodeToMove = nodeToMove.left;
			}
			parentNodeToMove.left = nodeToMove.right;
			node.data = nodeToMove.data;
			return node;
		}
		
	}
	
}






