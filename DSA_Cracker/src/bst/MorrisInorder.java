package bst;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MorrisInorder {

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

	public static void morrisInorder(BstNode<Integer> root) {

		BstNode<Integer> cur=root;

		while(cur!=null) {
			
			if(cur.left==null) {
				System.out.print(cur.data+" ");
				cur=cur.right;
			}
			else {
				
				BstNode<Integer> predecessor=cur.left;
				while(predecessor.right!=null && predecessor.right!=cur) {
					predecessor=predecessor.right;
				}
				if(predecessor.right==null) {
					predecessor.right=cur;
					cur=cur.left;
				}
				else {
					predecessor.right=null;
					System.out.print(cur.data+" ");
					cur=cur.right;
					
				}	
			}
		}
	}





	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BstNode<Integer>root=buildbst();
		morrisInorder(root);
	}

}
