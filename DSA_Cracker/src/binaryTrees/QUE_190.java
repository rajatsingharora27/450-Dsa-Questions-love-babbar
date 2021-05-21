package binaryTrees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class QUE_190 {

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


	public static boolean checkBalane(Node<Integer> root) {
		return isBst(root).isBalanced;
	}

	public static pairs isBst(Node<Integer> root) {

		if(root==null) {

			pairs p=new pairs();
			p.height=0;
			p.isBalanced=true;
			return p;
		}


		pairs leftSide=isBst(root.left);
		pairs rightSide=isBst(root.right);

		int diff =Math.abs(leftSide.height-rightSide.height);
		pairs p=new pairs();
		if(diff<=1 && leftSide.isBalanced && rightSide.isBalanced) {

			p.height=1+Math.max(leftSide.height, rightSide.height);
			p.isBalanced=true;
			return p;

		}
		else {
			p.height=1+Math.max(leftSide.height, rightSide.height);
			p.isBalanced=false;
			return p;
		}


	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node<Integer> root=build();
		System.out.println(checkBalane(root));


	}

}
