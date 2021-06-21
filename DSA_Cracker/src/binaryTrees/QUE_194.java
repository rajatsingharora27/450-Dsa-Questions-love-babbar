package binaryTrees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class QUE_194 {

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

	public static Node<Integer> bToDLL(Node<Integer> root)
	{
		//  Your code here	
		Node<Integer> head=null;
		Node<Integer> prev=null;
		int flag=0;
		solve (root,head,prev,flag);
		return head;
	}

	public static void solve(Node<Integer> root , Node<Integer> head, Node<Integer> prev, int flag){

		if(root==null){
			return;
		}

		solve(root.left,head,prev,flag);

		if(flag==0){
			flag=1;
			head=root;
			prev=root;
		}
		else{
			prev.right=root;
			prev.right.left=prev;
			prev=prev.right;
		}
		System.out.print(root.data+" ");
		solve(root.right,head,prev,flag);
	}

	public static void print(Node<Integer> head) {
		
		Node<Integer> ptr=head;
		
		while(ptr!=null) {
			System.out.println(ptr.data);
			ptr=ptr.right;
		}		
	}
	




	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> root=build();
		print(bToDLL(root));
		

	}

}
