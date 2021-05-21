package binaryTrees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class QUE_185 {
	
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
	

	
	// Using recursion
	public static void leftView(Node<Integer> root) {
		
		boolean level[]=new boolean[100];
		leftView(root,level,0);
		
	}
	
	
	private static void leftView(Node<Integer> root, boolean[] level, int curr) {
		// TODO Auto-generated method stub
		
		if(root==null) {
			return;
		}
		
		if(level[curr]==false) {
			level[curr]=true;
			System.out.print(root.data+" ");
		}
		
		leftView(root.left, level, curr+1);
		leftView(root.right, level, curr+1);
		return;
		
		
		
		
		
		
		
	}


	
	//Level Order Traversal
	public static void leftViewLevel(Node<Integer> root) {
		
		if(root==null) {
			return;
		}
		
		Queue<Node<Integer>> q=new LinkedList<>();
		
		q.add(root);
		
		while(!q.isEmpty()) {
			int size=q.size();
			
			for(int i=0;i<size;i++) {
				
				Node<Integer> front=q.poll();
				
				if(i==0) {
					System.out.print(front.data+" ");
				}
				
				if(front.left!=null) {
					q.add(front.left);
				}
				if(front.right!=null) {
					q.add(front.right);
				}
				
			}
				
		}
		
	}
	
	
	
	





	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> root=build();
		leftView(root);
		System.out.println();
		leftViewLevel(root);

	}

}
