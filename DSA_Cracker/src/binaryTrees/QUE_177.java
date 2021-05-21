package binaryTrees;
import java.util.*;
public class QUE_177 {

	public static ArrayList<Integer> levelOrde(Node<Integer> root) {
		 if(root==null) {
				return null ;
			}
			
			Queue<Node<Integer> >q=new LinkedList<>();
			
			ArrayList<Integer> arr=new ArrayList<>();
			
			q.add(root);
			
			while(!q.isEmpty()) {
				
				Node<Integer> front=q.poll();
				//System.out.print(front.data+" ");
				arr.add(front.data);
				if(front.left!=null) {
					q.add(front.left);
				}
				
				if(front.right!=null) {
					q.add(front.right);
				}
			}
	        return arr;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
