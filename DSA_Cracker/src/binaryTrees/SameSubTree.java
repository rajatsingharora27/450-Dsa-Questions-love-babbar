package binaryTrees;

public class SameSubTree {
	
	
	public static boolean Subtree(Node<Integer> root1 , Node<Integer> root2) {
		
		if(root2==null) {
			return true;
		}
		
		if(root1==null) {return false;}
		
		if(isIdentical(root1,root2)) {
			return true;
		}
		
		return false;
	
	}
	
	
	
	
	

	private static boolean isIdentical(Node<Integer> root1, Node<Integer> root2) {
		
		if(root1==null && root2==null) return true;
		
		if(root1==null || root2==null) return false;
		
		if(root1.data==root2.data) {
			
			return(isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right));
			
		}
		return false;
		
	}






	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
