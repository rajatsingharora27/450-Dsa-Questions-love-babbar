package heap;

import java.util.*;

import binaryTrees.Node;
//class TreeNode{
//	int data;
//	TreeNode left;
//	TreeNode right;
//	
//	public TreeNode(int data) {
//		// TODO Auto-generated constructor stub
//		this.data=data;
//	}
//}


public class QUE_348 {
	
	public static Node<Integer> build(){
		Scanner sc=new Scanner(System.in);
		Queue<Node<Integer>> q= new LinkedList<>();
		Node<Integer> root=null;
		System.out.println("Enter root data: ");
		int rootData=sc.nextInt();
		
		if(rootData!=-1) {
			root=new Node<>(rootData);
			q.add(root);
		}

		while(!q.isEmpty()) {
			
			Node<Integer> fv=q.poll();
			//System.out.println("Enter left child and right child: ");
			
			
			//System.out.println("left child press 1 ?" +fv.data+" ");
			System.out.println("Enter the left child of "+fv.data+" " );
			int leftdata=sc.nextInt();
			
			if(leftdata!=-1) {
				
				Node<Integer> leftChild=new Node<Integer>(leftdata);
				fv.left=leftChild;
				q.add(leftChild);
			}
			
			System.out.println("Enter the right child of "+fv.data+" " );
			int rightdata=sc.nextInt();
			
			if(rightdata!=-1){
				
				Node<Integer> rightChild=new Node<Integer>(rightdata);
				fv.right=rightChild;
				q.add(rightChild);
			}
		}	
		return root;	
		
	}
	
	
	
	
	public static boolean isComplete( Node<Integer> tree) {
		
		if(tree==null) {
			return true;
		}
		
		ArrayList<Integer> array=new ArrayList<>();
		Queue<Node<Integer>> q=new LinkedList<>();
		q.add(tree);
		
		while(!q.isEmpty()) {
			
			Node<Integer> first=q.poll();
			if(first==null) {
				array.add(-1);
			}
			else {
				array.add(first.data);
			}
			
			if(first.left!=null) {
				q.add(first.left);
			}
			else{
				q.add(null);
			}
			
			if(first.right!=null) {
				q.add(first.right);
			}
			else{
				q.add(null);
			}
		}
		
		//Now to check if complete ?
		
		int firstNegativ=0;
		
		for(int i=0;i<array.size();i++) {
			if(array.get(i)!=-1) {
				continue;
			}
			else {
				firstNegativ=i;
				break;
			}
		}
		
		for(int k=firstNegativ;k<array.size();k++) {
			if(array.get(k)!=-1) {
				return false;
			}
		}
		return true;
		
		
		
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> root=build();
		System.out.println(isComplete(root));
		
		

	}

}
