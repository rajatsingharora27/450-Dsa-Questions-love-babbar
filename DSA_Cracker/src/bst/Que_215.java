package bst;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Que_215 {
	
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
			
			
			System.out.println("left child press 1 ?" +fv.data+" ");
			if(sc.nextInt()!=-1) {
				System.out.println("Enter the left child of "+fv.data+" " );
				int leftdata=sc.nextInt();
				BstNode<Integer> leftChild=new BstNode<Integer>(leftdata);
				fv.left=leftChild;
				q.add(leftChild);
			}
			
			System.out.println("right child press 1?" +fv.data+" ");
			if(sc.nextInt()!=-1) {
				System.out.println("Enter the right child of "+fv.data+" " );
				int rightdata=sc.nextInt();
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
	
	public static BstNode<Integer> delete(BstNode<Integer> root , int key){
		
		if(root==null) {
			return null;
		}
		
		// reaching to the key node
		if(root.data<key) {
			root.left=delete(root.left , key);
			return root;
		}
		else if(root.data>key) {
			root.right=delete(root.right,key);
			return root;
		}
		else {
			// means we are the node to be deleted
			
			// check if the node is leaf node
			if(root.left==null && root.right==null) {
				return null;
			}
			// node is having left or a right child only
			else if(root.left==null) {
				return root.right;
			}
			else if(root.right==null) {
				return root.left;
			}
			else {
				BstNode<Integer> minnode=root.right;
				while(minnode.left!=null) {
					minnode=minnode.left;
				}
				root.data=minnode.data;
				root.right=delete(root.right,minnode.data);
				return root;
			}
		}
		
	}
	
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
