package bst;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class QUe_230 {

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

	public static void replace(int arr[],int n) {

		BstNode<Integer> root=null;
		BstNode<Integer> succ=null;

		for(int i=n-1;i>=0;i--) {
			
			root=insert(arr[i],root,succ);
			
			if(succ!=null) {
				arr[i]=succ.data;
				
			}
			else {
				arr[i]=-1;
			}	
		}
		
		for(int i=0;i<n;i++) {
			System.out.print(arr[i]+" ");
		}
	}



	private static BstNode<Integer> insert(int data, BstNode<Integer> root, BstNode<Integer> succ) {

		if(root==null) {
			root=new BstNode<Integer>(data);
			return root;
		}
		
		if(data<root.data) {
			succ=root;
			root.left=insert(data,root.left,succ);
		}
		else if(data>root.data) {
			root.right=insert(data,root.right,succ);
		}

		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//BstNode<Integer> root=buildbst();
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int arr[]=new int[n];
		for(int i=0;i<arr.length;i++ ) {
			System.out.println("Enter the element");
			arr[i]=sc.nextInt();
		}
		replace(arr,n);

	}

}
