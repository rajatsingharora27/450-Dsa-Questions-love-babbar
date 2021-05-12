package bst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class QUE_224 {

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

	public static void mergeBST(BstNode<Integer> root1 , BstNode<Integer> root2){

		ArrayList<Integer> arr1=new ArrayList<Integer>();
		ArrayList<Integer> arr2=new ArrayList<Integer>();
		inorder(root1,arr1);
		inorder(root2,arr2);	

		// merging two arrays
		ArrayList<Integer> arr3=new ArrayList<>();
		merge(arr1,arr2,arr3);
		
		BstNode<Integer> rootAns=null;

		rootAns=allToBst(0,arr3.size()-1,rootAns,arr3);
		
		printLevelOrder(rootAns);

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
	
	private static BstNode<Integer> allToBst(int si, int li, BstNode<Integer> rootAns,ArrayList<Integer> arr) {
		
		if(si>li) {
			return null;
		}
		
		int mid=(si+li)/2;
		
		rootAns=new BstNode<Integer>(arr.get(mid));
		
		rootAns.left=allToBst(si, mid-1, rootAns, arr);
		rootAns.right=allToBst(mid+1, li, rootAns, arr);
		
		return rootAns;
		
	}

	private static void merge(ArrayList<Integer> arr1, ArrayList<Integer> arr2,ArrayList<Integer> arr3) {

		int i=0,j=0;

		while(i<arr1.size() && j<arr2.size()) {

			if(arr1.get(i)<arr2.get(j)) {
				arr3.add(arr1.get(i));
				i++;
			}

			else if(arr1.get(i)>arr2.get(j)) {
				arr3.add(arr2.get(j));
				j++;
			}
			else {
				arr3.add(arr1.get(i));
				i++;
				j++;
			}
		}

		if(i<arr1.size() && j==arr2.size()) {
			while(i<arr1.size()){	
				arr3.add(arr1.get(i));
				i++;
			}
		}
		else if(i==arr1.size() && j<arr2.size()) {
			while(j<arr2.size()){	
				arr3.add(arr2.get(j));
				j++;
			}
			
		}



	}

	public static void inorder(BstNode<Integer>root,ArrayList<Integer>arr) {

		if(root==null) {
			return;
		}

		inorder(root.left,arr);
		arr.add(root.data);
		inorder(root.right,arr);	
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BstNode<Integer> root1=buildbst();
		BstNode<Integer> root2=buildbst();
		mergeBST(root1,root2);

	}

}
