package binaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class QUE_209 {
	
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
	
	
	// time complex- O(n)
	//Space complex O(n)
	
	
	public static int Kancestor(Node<Integer> root,int k,int num) {
		
		// Taking all the element of the tree in array
		ArrayList<Integer>arr= new ArrayList<>();
		Queue<Node<Integer>> q= new LinkedList<>();
		
		if(root==null) {
			return -1;
		}
	
		q.add(root);
		
		while(!q.isEmpty()) {
			
			Node <Integer> first=q.poll();
			
			if(first==null) {
				arr.add(-1);
				continue;
			}
			
			
			
			arr.add(first.data);
			if(first.left!=null) {
				q.add(first.left);
			}
			else {
				q.add(null);
			}
			
			if(first.right!=null) {
				q.add(first.right);
			}
			else {
				q.add(null);
			}		
		}
		
		for(int i=0;i<arr.size();i++) {
			System.out.print(arr.get(i)+" ");
		}
		
		
		// find the element
		int pos=-1;
		for(int i=0;i<arr.size();i++) {
			if(arr.get(i)==num) {
				pos=i;
			}
		}
		if(pos==-1) {
			return -1;
		}
		
		
		// making recursion calls to get the ancestor
		System.out.println();
		return ancestor(arr,pos,k);
	
	}
	


	private static int ancestor(ArrayList<Integer> arr, int pos, int k) {
		
		if(pos<0) {
			return -1;
		}
		
		
		if(k==0) {
			return arr.get(pos);
		}
		
		return ancestor(arr, (pos-1)/2, k-1);
	
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> root= build();
		System.out.println(Kancestor(root, 2, 8));

	}

}
