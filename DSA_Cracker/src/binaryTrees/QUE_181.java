package binaryTrees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import bst.BstNode;



public class QUE_181 {
	
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
	
	public static  void printLevelOrder(Node<Integer> root) {
		
		if(root==null) {
			return;
		}
		
		if(root.left==null &&  root.right==null) {
			System.out.println(root.data);
			return;
		}
		
		
		Queue<Node<Integer>> q= new LinkedList<>();
		
		q.add(root);
		
		while(!q.isEmpty()) {
			
			Node<Integer> fv=q.poll();
			System.out.print(fv.data+" ");
			
			if(fv.left!=null) {
				q.add(fv.left);
			}
			
			if(fv.right!=null) {
				q.add(fv.right);
			}
		}

	}
	
	
	
	public static void mirror(Node<Integer> root) {
		
		if(root==null) {
			return;
		}
		
		mirror(root.right);
		mirror(root.left);
		Node<Integer> temp = root.left;
		root.left=root.right;
		root.right=temp;
		return;	
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node <Integer > root=build();
		printLevelOrder(root);
		mirror(root);
		System.out.println();
		printLevelOrder(root);
		

	}

}
