package binaryTrees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class QUE_200 {



	static HashMap<String,Integer> map=new HashMap<>();


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



	public static int dupSub(Node<Integer> root) {
		// code here 
		solve(root);
		System.out.println(map);
		Set<String> keys=map.keySet();
		for(String ele:keys){
			if(map.get(ele)>=2) return 1;
		}
		
		return 0;       

	}

	public static String solve(Node<Integer> root){

		if(root==null) return "$";
		String s="";
		if(root.left==null && root.right==null){
			s=root.data+"";
			return s;
		}

		s=s+root.data+"";
		s=s+solve(root.left);
		s=s+solve(root.right);

		if(map.containsKey(s)){
			map.put(s,map.get(s)+1);
		}
		else{
			map.put(s,1);
		}
		return s;
	}







	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> root= build();
		System.out.println(dupSub(root));

	}

}
