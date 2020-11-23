package ten190607;

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

	private boolean add(E data, Node<E> node) {
		if (data.compareTo(node.data) == 0) {
			return false;
		} else if (data.compareTo(node.data) < 0) {
			if (node.left == null) {
				node.left = new Node<>(data);
				return true;
			} else {
				return add(data, node.left);
			}
		} else if (node.right == null) {
			node.right = new Node<>(data);
			return true;
		} else {
			return add(data, node.right);
		}
	}

	public boolean add(E data) {
		if (root == null) {
			root = new Node<>(data);
			return true;
		} else {
			return add(data, root);
		}
	}

	public int height() {
		if (root == null)
			return 0;
		return height(root, 0);

	}

	private int height(Node<E> n, int depth) {
		if (n == null)
			return -1;
		if (isLeaf(n))
			return depth;

		return Math.max(height(n.left, depth + 1), height(n.right, depth + 1));
	}

	private boolean isLeaf(Node<E> n) {
		if (n.left == null && n.right == null)
			return true;
		return false;
	}

	public int nrNodesWith2children() {
		if (root == null)
			return 0;
		return nrNodesWith2children(root);

	}

	private int nrNodesWith2children(Node<E> n) {
		
		if(isLeaf(n))
			return 0;
		if(has2kids(n)){
			return nrNodesWith2children(n.left) + nrNodesWith2children(n.right) + 1;
		} else if(n.left!=null && n.right==null)
			return nrNodesWith2children(n.left);
		else if(n.left==null && n.right!=null)
			return nrNodesWith2children(n.right);
		
		return 0;
	}
	
	private boolean has2kids(Node<E> n) {
		if(n.right!= null && n.left != null)
			return true;
		return false;
	}

	public int nrNodesWith2grandchildren() {
		if (root == null)
			return 0;
		return nrNodesWith2grandchildren(root, 0);

	}

	public int nrNodesWith2grandchildren(Node<E> n, int cnt) {

		return 0;

	}

	public static void main(String[] args) {

		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		bst.add(20);
		bst.add(10);
		bst.add(30);
		bst.add(5);
		bst.add(15);
		bst.add(40);
		bst.add(3);
		bst.add(12);
		bst.add(35);
		bst.add(45);
		bst.add(11);
		bst.add(14);
		bst.add(33);
		bst.add(37);
		bst.add(48);

		BinarySearchTree<Integer> b = new BinarySearchTree<>();

		b.add(5);
		b.add(4);
		b.add(6);
		b.add(7);
		b.add(9);
		b.add(8);

		System.out.println(b.height());

		System.out.println(bst.height());
		System.out.println(bst.nrNodesWith2children());
		System.out.println(bst.nrNodesWith2grandchildren());

	}

}
