package dynamicProgramming;


public class QUE_448 {





	// Recursion
	public static int longestIndependentSet( node root) {

		if(root==null) {
			return 0;
		}


		int exclude=longestIndependentSet(root.left)+longestIndependentSet(root.right);

		int include=1;

		if(root.left!=null) {
			include+=longestIndependentSet(root.left.left)+longestIndependentSet(root.left.right);
		}
		if(root.right!=null) {
			include+=longestIndependentSet(root.right.left)+longestIndependentSet(root.right.right);
		}

		return Math.max(exclude, include);




	}

	static node newNode( int data )
	{
		node temp =new node();
		temp.data = data;
		temp.left = temp.right = null;
		return temp;
	}
	
	static NodeLisMemo newNodememo( int data )
	{
		NodeLisMemo temp =new NodeLisMemo();
		temp.data = data;
		temp.left = temp.right = null;
		temp.liss=0;
		return temp;
	}
	
	

	//Using memoization

	public static int lisMemo(NodeLisMemo root) {


		if (root==null) return 0;
		if(root.liss!=0) return root.liss;
		if(root.left==null && root.right==null) return root.liss=1;

		// Excluding

		int exclude=lisMemo(root.left)+lisMemo(root.right);

		int include=1;

		if(root.left!=null) {
			include+=lisMemo(root.left.left)+lisMemo(root.left.right);
		}

		if(root.right!=null) {
			include+=lisMemo(root.right.right)+lisMemo(root.right.left);
		}

		return Math.max(exclude, include);

	}






	public static void main(String[] args) {
		// TODO Auto-generated method stub
		node root = newNode(20);
		root.left = newNode(8);
		root.left.left = newNode(4);
		root.left.right = newNode(12);
		root.left.right.left = newNode(10);
		root.left.right.right = newNode(14);
		root.right = newNode(22);
		root.right.right = newNode(25);

		System.out.println("Size of the Largest"
				+ " Independent Set is "
				+ longestIndependentSet(root));
		
		
		NodeLisMemo root1 = newNodememo(20);
		root1.left = newNodememo(8);
		root1.left.left = newNodememo(4);
		root1.left.right = newNodememo(12);
		root1.left.right.left = newNodememo(10);
		root1.left.right.right = newNodememo(14);
		root1.right = newNodememo(22);
		root1.right.right = newNodememo(25);
		
		
		
		
		
		System.out.println("Size of the Largest"
				+ " Independent Set is "
				+ lisMemo(root1));
		
		
		
		
	}

	

	
}





