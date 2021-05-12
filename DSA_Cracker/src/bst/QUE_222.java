package bst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.*;

public class QUE_222 {
	static int j=0;
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

	private static void binaryTreeToBST(BstNode<Integer> root) {
		
		// taking all elements to array
		int size=Size(root);
		int array[]=new int [size];
		// sorting the array
		toarray(root,array,0);
		Arrays.sort(array);
		
		arraytoBST(root,array,0);
		
		printLevelOrder(root);
	
		
	}
	
	
	

	private static void toarray(BstNode<Integer> root, int[] array,int i) {
		
		if(root==null) {
			return;
		}
		
		toarray(root.left,array,i);
		array[i]=root.data;
		i++;
		toarray(root.right,array,i);
		
	}

	private static void arraytoBST(BstNode<Integer> root, int[] array, int i) {
		// TODO Auto-generated method stub
		
		if(root==null) {
			return;
		}
		arraytoBST(root.left,array,i);
		root.data=array[i];
		i++;
		arraytoBST(root.right,array,i);
				
		
	}

	private static int Size(BstNode<Integer> root) {
		// TODO Auto-generated method stub
		if(root==null) {
			return 0;
		}
		int leftSize=Size(root.left);
		int rightSize=Size(root.right);
		return leftSize+rightSize+1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BstNode<Integer> root= buildbst();
		
		
		//printLevelOrder(root);
		
		binaryTreeToBST(root);
		
		
		
		

	}

	

}
