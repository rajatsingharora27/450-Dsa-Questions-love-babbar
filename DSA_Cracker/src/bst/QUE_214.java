package bst;

import java.util.*;

public class QUE_214 {
	
	public static BstNode<Integer> buildbst(){
		Scanner sc=new Scanner(System.in);
		Queue<BstNode<Integer>> q= new LinkedList<>();
		BstNode<Integer> root=null;
		System.out.println("Enter root data: ");
		int rootData=sc.nextInt();

		if(rootData!=-1) {
			root=new BstNode<>(rootData);
			q.add(root);
		}

		while(!q.isEmpty()) {

			BstNode<Integer> fv=q.poll();
			//System.out.println("Enter left child and right child: ");


			//System.out.println("left child press 1 ?" +fv.data+" ");
			System.out.println("Enter the left child of "+fv.data+" " );
			int leftdata=sc.nextInt();

			if(leftdata!=-1) {

				BstNode<Integer> leftChild=new BstNode<Integer>(leftdata);
				fv.left=leftChild;
				q.add(leftChild);
			}

			System.out.println("Enter the right child of "+fv.data+" " );
			int rightdata=sc.nextInt();

			if(rightdata!=-1){

				BstNode<Integer> rightChild=new BstNode<Integer>(rightdata);
				fv.right=rightChild;
				q.add(rightChild);
			}
		}	
		return root;	

	}	

	public static  void printLevelOrder(BstNode<Integer> root) {
		
		if(root==null) {
			return;
		}
		
		if(root.left==null &&  root.right==null) {
			System.out.println(root.data);
			return;
		}
		
		
		Queue<BstNode<Integer>> q= new LinkedList<>();
		
		q.add(root);
		
		while(!q.isEmpty()) {
			
			BstNode<Integer> fv=q.poll();
			System.out.print(fv.data+" ");
			
			if(fv.left!=null) {
				q.add(fv.left);
			}
			
			if(fv.right!=null) {
				q.add(fv.right);
			}
		}

	}
	
	public static BstNode<Integer> search(BstNode<Integer> root, int key){
		
		if(root==null) {
			return null;
		}
		
		if(root.data==key) {
			return root;
		}
		
		if(root.data>key) {
			return search(root.left,key);
		}
		
		else {
			return search(root.right,key);
		}		
	}
	
	public static BstNode<Integer> insert(BstNode<Integer>root, int key){
		
		if(root==null) {
			BstNode<Integer> newroot=new BstNode<Integer>(key);
			return newroot;
		}
		
		if(root.data<key) {
			root.right=insert(root.right,key);
		}else {
			root.left=insert(root.left,key);
		}
		
		return root;
		
		
		
		
		
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BstNode<Integer> root = buildbst();
		printLevelOrder(root);
		
		

	}

}
