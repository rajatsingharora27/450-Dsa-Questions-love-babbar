 package binaryTrees;

import java.util.HashMap;

public class QUE_205 {
	
	static HashMap<Node<Integer> , Integer> dp=new HashMap<>();
	
	public static int maxSumNoAdj(Node<Integer>  root) {
		
		if(root==null) {
			return 0;
		}
		
		if(dp.containsKey(root)) {
			return dp.get(root);
		}
		int inc=root.data;
		if(root.left!=null) {
			inc+=maxSumNoAdj(root.left.left);
			inc+=maxSumNoAdj(root.left.right);
		}
		if(root.right!=null) {
			inc+=maxSumNoAdj(root.right.left);
			inc+=maxSumNoAdj(root.right.right);
		}
		
		
		//not including root;
		int exc=maxSumNoAdj(root.left)+maxSumNoAdj(root.right);
		
		return dp.put(root, Math.max(inc, exc));	
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	} 

}
