package binaryTrees;

public class QUE_208 {

	
	public static int findDist(Node<Integer> root, int n1,int n2) {
		
		Node<Integer> lca=Lca(root,n1,n2);
		int dis1=distance(lca,n1);
		int dis2=distance(lca,n2);
		return dis1+dis2-2;
	
	}
	
	
	
	
	
	
	private static int distance(Node<Integer> root, int n) {
		
		if(root==null) {
			return 0;
		}
		if(root.data==n) {
			return 1;
		}
		int l=distance(root.left, n);
		int r=distance(root.right, n);
		
		if(l==0 && r==0) return 0;
		else return l+r+1;
		
		
		
	}






	private static Node<Integer> Lca(Node<Integer> root, int n1, int n2) {
		
		if(root==null) {
			return root;
		}
		
		Node<Integer> lca1=Lca(root.left,n1,n2);
		Node<Integer> lca2=Lca(root.right,n1,n2);
		
		if(lca1!=null && lca2!=null) {
			return root;
		}
		
		if(lca1==null) {
			return lca2;
		}
		else {
			return lca1;
		}
	
	}






	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
