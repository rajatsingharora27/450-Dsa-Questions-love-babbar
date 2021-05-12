package bst;

class Node<T>{
	T data;
	Node<T>left;
	Node<T>right;
	Node<T>next;
	public Node(T data) {
		// TODO Auto-generated constructor stub
		this.data=data;
	}
	
	
}


public class QUE_219 {
	static Node<Integer>prev=null;
	public static void populate(Node<Integer> root){
		
		if(root==null) {
			return ;
		}
		
		populate(root.left);
		
		if(prev!=null) {
			prev.next=root;
		}
		prev=root;
		populate(root.right);
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
