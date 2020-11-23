package ovning;
public class BinTree<E extends Comparable<E>> {

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

    public BinTree() {
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

    public int numberOfLeaves() {
    	Node<E> nude = root;
        return numberOfLeaves(0, nude);
    }
    private int numberOfLeaves(int cunt, Node nude) {
    	if(isLeaf(nude)==true)
    		return 1;
    	int cl = 0;
    	int cr = 0;
    	if(nude.left!=null)
    		cl = numberOfLeaves(cunt, nude.left);
    	if(nude.right!=null)
    		cr = numberOfLeaves(cunt, nude.right);
    	
    	return cl+cr;
    	
    }
    
    private boolean isLeaf(Node n) {
    	if(n.left==null && n.right ==null)
    		return true;
    	return false;
    }



    public E max() {
        Node<E> node = root;
        if(node == null) {
        	return null;
        }
        return max(node.right);
    }
    
    private E max(Node<E> node) {
    	if(node.right == null) {
        	return node.data;
        }
    	return max(node.right);
    }

    public E secondMax() {
        Node<E> node = root;
        
        if(node == null || (node.left == null && node.right == null)) {
        	return null;
        }
        return secondMax(node);
    }
    
    private E secondMax(Node<E> node, E second, E first) {
    	if(node.left == null && node.right == null)
    		return node.data;
    	E tmp = null;
    	E tmp2 = null;
    	if(node.right != null) {
	    	tmp = secondMax(node.right, second, first);
	    	if(first.compareTo(tmp) < 0) {
	    		second = first;
	    		first = tmp;
	    	}
    	}
    	if(node.left != null) {
	    	tmp2 = secondMax(node.left, second, first);
	   		if(first.compareTo(tmp2) < 0) {
	   			second = first;
	   			first = tmp2;
	   		}
    	}
    	System.out.println(first.toString());
    	System.out.println(second.toString());
    	return first;
    }
    
    
    private E secondMax(Node<E> node) {
    	E secondMax = null, bajs2 = null;
  
    	if(isLeaf(node.right)) {
    		return node.data;
    	}
    	
    	if(node.right.right!=null) {
    		secondMax = secondMax(node.right);
    	}
    	
    	if(node.left!=null) {
    		if(node.left.right!=null)
        		bajs2= secondMax(node.left);
    	}
    	
    	if(bajs2!=null && secondMax!=null) {
    		if(secondMax.compareTo(bajs2)<0)
        		return bajs2;
    	}
    	return secondMax;
    	
    }
    
    
    public Node delete(E target) {
    	Node n = root, ret;
    	if(target.equals(root))
    		removeFirst();
    	
    	return n;
    }
    
    private Node removeFirst() {
    	
    	
    	
    	return null;
    }
    
    
    

  /*  @Override
	public String toString() {
    	StringBuilder sb = new StringBuilder();
    	Node node = root;
    	while(node!=null) {
    		sb.append(node.data + " ");
    		node = node.right;
    		
    	}
    	
		return "BinTree [root=" + root + "]" + "\n" + sb.toString();
	}
    
    private String appendShit() {
    	
		return null;
    	
    }*/

	public static void main(String[] args) {
    	BinTree<Integer> b = new BinTree<Integer>();
    	b.add(20);
    	b.add(30);
    	b.add(25);
    	b.add(26);
    	b.add(27);
    	b.add(28);
    
    	System.out.println(b.toString());
    	System.out.println(b.delete(25));
    	System.out.println(b.toString());
    	
    }

}
