package arrays;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import binaryTrees.Node;

public class BoundayTraveral {
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

	public static void Boundary(Node<Integer> root) {

		// print left side
		printLeft(root);
		leafNodes(root);
		printRight(root.right);
	}


	private static void printRight(Node<Integer> root) {

		if(root==null) {
			return;
		}

		if(root.right!=null) {
			System.out.print(root.data+" ");
			printRight(root.right);
		}

		else if(root.left!=null) {
			System.out.print(root.data+" ");
			printRight(root.left);
		}


	}


	private static void leafNodes(Node<Integer> root) {
		if(root==null) {
			return;
		}


		leafNodes(root.left);
		if(root.left==null && root.right==null) {
			System.out.print(root.data);
		}
		leafNodes(root.right);

	}


	private static void printLeft(Node<Integer> root) {
		if(root==null) return;

		if(root.left!=null) {
			System.out.print(root.data+" ");
			printLeft(root.left);
		}
		else if(root.right!=null) {
			System.out.print(root.data+" ");
			printLeft(root.right);
		}




	}








	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> root=build();
		Boundary(root);
		

	}

}
