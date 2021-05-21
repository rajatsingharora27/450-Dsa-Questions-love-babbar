package binaryTrees;
import java.util.*;
public class QUE_189 {
	
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
	
	
	

	public static ArrayList<Integer> zigzag(Node<Integer> root){

		if(root==null){
			return null;
		}

		Stack<Node<Integer>> s1=new Stack<>();
		Stack<Node<Integer>> s2=new Stack<>();
		ArrayList<Integer> ans=new ArrayList<>();
		s1.push(root);

		while(true){


			if(s1.isEmpty() &&  s2.isEmpty()){
				break;
			}

			while(!s1.isEmpty()){
				Node<Integer> first=s1.pop();
				ans.add(first.data);
				if(first.left!=null){
					s2.push(first.left);
				}
				if(first.right!=null){
					s2.push(first.right);
				}
			}
			while(!s2.isEmpty()){
				Node<Integer> first=s2.pop();
				ans.add(first.data);
				if(first.right!=null){
					s1.push(first.right);
				}
				if(first.left!=null){
					s1.push(first.left);
				}
			}
		}
		return ans;

	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node <Integer> root=build();
		ArrayList<Integer>ans=zigzag(root);
		System.out.println(ans);
	}

}
