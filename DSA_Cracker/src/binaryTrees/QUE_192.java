package binaryTrees;

import java.util.*;
public class QUE_192 {
	
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
	
	public static ArrayList<Integer> boundryTravell(Node<Integer> root){
		
		ArrayList<Integer> arr=new ArrayList<>();
 		moveleft(root,arr);
 		getLeaves(root.left,arr);
 		getLeaves(root.right,arr);
 		moveright(root,arr);
 		return arr;
	}

	private static void getLeaves(Node<Integer> root, ArrayList<Integer> arr) {
		// TODO Auto-generated method stub
		
		if(root==null) {
			return;
		}
		
		getLeaves(root.left, arr);
		if(root.left==null && root.right==null) {
			arr.add(root.data);
		}	
		getLeaves(root.right, arr);
		
		
		
	}

	private static void moveright(Node<Integer> root, ArrayList<Integer> arr) {
		// TODO Auto-generated method stub
		if(root==null) {
			return;
		}
		
		if(root.right!=null) {
			arr.add(root.data);
			moveright(root.right,arr);
		}
		
		else if(root.left!=null) {
			
			moveright(root.left, arr);
			arr.add(root.data);
		}
		
	}

	private static void moveleft(Node<Integer> root, ArrayList<Integer> arr) {
		// TODO Auto-generated method stub
		if(root==null) {
			return;
		}
		
		if(root.left!=null) {
			arr.add(root.data);
			moveleft(root.left,arr);
		}
		
		else if(root.right!=null) {
			arr.add(root.data);
			moveleft(root.right, arr);
		}	
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> root=build();
		ArrayList<Integer> arr=boundryTravell(root);
		for(Integer ele:arr) {
			System.out.print(ele+" ");
		}
		
		
		
		
	}

}
