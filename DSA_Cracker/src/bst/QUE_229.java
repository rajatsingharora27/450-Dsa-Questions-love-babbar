package bst;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class QUE_229 {

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
	
	public static int countInRange(BstNode<Integer> root, int l, int h) {
		
		BstNode<Integer> cur=root;
		
		int count=0;
		
		while(cur!=null) {
			
			if(cur.left==null) {
				
				if(l<=cur.data && cur.data<=h) {
					count++;
				}
				cur=cur.right;
			}
			
			else {
				
				BstNode<Integer> pred=cur.left;
				while(pred.right!=null && pred.right!=cur) {
					pred=pred.right;
				}
				
				if(pred.right==null) {
					pred.right=cur;
					cur=cur.left;
				}
				else {
					pred.right=null;
					if(l<=cur.data && cur.data<=h) {
						count++;
					}
					cur=cur.right;	
				}
			}
				
		}
		return count;	
	}
	
	public static int countInRangeRecursive(BstNode<Integer> root, int l, int h) {
		
		if(root==null) {
			return 0;
		}
		
		
		//if at root the data is in the range
		// we add 1 to answer and pass the call to left and  right of the tree
		
		if(l<=root.data  && root.data<=h) {
			
			return 1+countInRangeRecursive(root.left, l, h)+countInRangeRecursive(root.right, l, h);
			
		}
		// if root.data < l  means the all the 
		// node data on the left of root is less than l
		// no need to go left now
		// recursive call to right
		else if(root.data<l) {
			return countInRangeRecursive(root.right, l, h);
		}
		
				// if root.data > h  means the all the 
				// node data on the right of root is greater than h
				// no need to go right now
				// recursive call to left
		else {
			return countInRangeRecursive(root.left, l, h);
		}		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BstNode<Integer> root= buildbst();
		//System.out.println(countInRange(root,5,45));
		System.out.println(countInRangeRecursive(root, 5, 45));

	}

}
