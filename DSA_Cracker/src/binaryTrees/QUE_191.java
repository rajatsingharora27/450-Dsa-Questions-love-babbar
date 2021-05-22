package binaryTrees;
import java.util.*;
public class QUE_191 {
	
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
	
	
	public static void diagnolprint(Node<Integer>root) {
		
		HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();
		diagnolPrintUtil(root,0,map);
		
//		Set<Integer> setKeys = map.keySet();
//		for(Integer key : setKeys){
//		    System.out.println( key );
//		}
		
		Collection<ArrayList<Integer>> values = map.values();
		for(ArrayList<Integer> value : values){
		    System.out.println( value );
		}
		
		
		
	}
	

	private static void diagnolPrintUtil(Node<Integer> root, int i, HashMap<Integer, ArrayList<Integer>> map) {
		
		if(root==null) {
			return;
		}
		
		ArrayList<Integer> k= map.get(i);
		
		if(k==null) {
			ArrayList<Integer> arr=new ArrayList<Integer>();
			arr.add(root.data);
			map.put(i, arr);
			
		}
		
		else {
			map.get(i).add(root.data);
		}
		
		
		diagnolPrintUtil(root.left, i+1, map);
		diagnolPrintUtil(root.right, i, map);
		return;
		
		
	}




	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node <Integer> root=build();
		diagnolprint(root);

	}

}
