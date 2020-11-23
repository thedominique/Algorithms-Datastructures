package ten100413;

public class BinarySearchTree<E extends Comparable<E>> {

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

	public BinarySearchTree() {
		root = null;
	}

	@Override
	public String toString() {
		if(root == null)
			return "empty";
		return ts(root);
	}
	
	private String ts(Node<E> n) {
		String s =  "";
		if(isLeaf(n))
			return n.data.toString();
		if(n.left!=null)
			s+= " " + ts(n.left);
		s+=n.data.toString();
		if(n.right!=null)
			s+= " " +ts(n.right);
		return s;
	}
	
	private boolean isLeaf(Node<E> n) {
		if(n.left == null && n.right == null)
			return true;
		return false;
	}

	public String toString(E target) {
		
		return ts(findNode(target, root));
	}
	
	private Node<E> findNode(E target, Node<E> n){
		
		if(target.compareTo(n.data) == 0)
			return n;
		
		if(target.compareTo(n.data)<0)
			return findNode(target, n.left);
		else if(target.compareTo(n.data)>0)
			return findNode(target, n.right);
		return null;
	}

	private boolean add(E data, Node<E> node) {
		if (data.compareTo(node.data) == 0)
			return false;
		else if (data.compareTo(node.data) < 0)
			if (node.left == null) {
				node.left = new Node<>(data);
				return true;
			} else
				return add(data, node.left);
		else if (node.right == null) {
			node.right = new Node<>(data);
			return true;
		} else
			return add(data, node.right);
	}

	public boolean add(E data) {
		if (root == null) {
			root = new Node<>(data);
			return true;
		} else {
			return add(data, root);
		}
	}
}
