package binaryTrees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class QUE_202a {
	
	
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
	
	
	
	
	public static void maxPathLength(Node<Integer>  root) {
		
		
		PairClass p=  maxPathLength(root,0,0);
		System.out.println(p.height+" " +p.sum);
		//System.out.println(maxPathLength(root,0,0).height);
	
	}
	
	
	
	

	private static PairClass maxPathLength(Node<Integer> root, int h, int s) {
		
		if(root==null) {
			PairClass p=new PairClass();
			p.height=h;
			p.sum=s;
			return p;
		}
		
//		int value=root.data+s;
//		h=h+1;
		
		PairClass left= maxPathLength(root.left, h+1,root.data+s );
		PairClass right= maxPathLength(root.right,h+1,root.data+s );
		
		
		
		if(left.height>right.height) {
			//System.out.println(left.height+ " " +left.sum);
			return left;
		}
		else if(left.height<right.height) {
			return right;
		}
		else {
			
			if(left.sum>right.sum) {
				return left;
			}
			else if(left.sum<right.sum) {
				return right;
			}
			else {
				return left;
			}		
		}
		
	}





	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> root= build();
		maxPathLength(root);
		

	}

}
