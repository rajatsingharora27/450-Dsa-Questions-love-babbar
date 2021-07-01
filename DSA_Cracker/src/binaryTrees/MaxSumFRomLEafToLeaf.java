package binaryTrees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MaxSumFRomLEafToLeaf {
	static int maxSum_=0;
	public static Node<Integer> build(){
		Scanner sc=new Scanner(System.in);
		Queue<Node<Integer>> q= new LinkedList<>();
		Node<Integer> root=null;
		System.out.println("Enter root data: ");
		int rootData=sc.nextInt();

		if(rootData!=-2) {
			root=new Node<>(rootData);
			q.add(root);
		}

		while(!q.isEmpty()) {

			Node<Integer> fv=q.poll();
			//System.out.println("Enter left child and right child: ");


			//System.out.println("left child press 1 ?" +fv.data+" ");
			System.out.println("Enter the left child of "+fv.data+" " );
			int leftdata=sc.nextInt();

			if(leftdata!=-2) {

				Node<Integer> leftChild=new Node<Integer>(leftdata);
				fv.left=leftChild;
				q.add(leftChild);
			}

			System.out.println("Enter the right child of "+fv.data+" " );
			int rightdata=sc.nextInt();

			if(rightdata!=-2){

				Node<Integer> rightChild=new Node<Integer>(rightdata);
				fv.right=rightChild;
				q.add(rightChild);
			}
		}	
		return root;	

	}

	public static int maxSum(Node<Integer> root) {
		
		if(root==null) {
			return 0;
		}
		
		if(root.left==null && root.right==null) {
			return root.data;
		}
		
		int left=maxSum(root.left);
		int right=maxSum(root.right);
		
		
		int op1=left+right+root.data;
		
		if(op1>maxSum_) {
			maxSum_=op1;
		}
		
		
		
		int op2=Math.max(right, left)+root.data;
		return op2;
	
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> root=build();
		
		maxSum(root);
		System.out.println(maxSum_);
	}

}
