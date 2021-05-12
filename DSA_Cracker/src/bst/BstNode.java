package bst;

public class BstNode<T> {

	T data;
	BstNode<T> left;
	BstNode<T> right;
	
	public BstNode(T data) {
		this.data=data;
		left=null;
		right=null;
	}

}
