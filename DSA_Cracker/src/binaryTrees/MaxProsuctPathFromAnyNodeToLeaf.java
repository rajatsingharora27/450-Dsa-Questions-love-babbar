package binaryTrees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MaxProsuctPathFromAnyNodeToLeaf {

	static int maxPro=0;

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


	public static Node<Integer> findNode(Node<Integer>  root,int x){

		if(root==null) {
			return null;
		}

		if(root.data==x) {
			return root;
		}

		Node<Integer> left= findNode(root.left, x);

		Node<Integer> right= findNode(root.right, x);



		if(left!=null && right==null) {
			return left;
		}
		else if(left==null && right!=null)
		{
			return right;
		}
		else {
			return null;
		}







	}

	public static int maxProductSum(Node<Integer> root) {
		if(root==null) {
			return maxPro;
		}
		if(root.left==null &&  root.right==null) {
			return root.data;
		}
		int left=maxProductSum(root.right);
		int right=maxProductSum(root.left);

		int op1=left*right*root.data;

		if(op1>maxPro) {
			maxPro=op1;
		}



		int op2=Math.max(right, left)*root.data;
		return op2;





	}





	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node<Integer> root=build();
		Node <Integer> midNode= (findNode(root, 4));
		maxProductSum(midNode);
		System.out.println(maxPro);



	}

} 
