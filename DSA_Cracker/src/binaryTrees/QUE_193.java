package binaryTrees;

public class QUE_193 {

	public static Node<Integer> string2Tree(String str){

		return helper(str,0);

	}


	private static Node<Integer> helper(String str, int si) {

		if(str.length()==0 || si>=str.length()) {
			return null;
		}

		// making the number from each Character
		boolean neg=false;

		if(str.charAt(si)=='-') {
			si++;
			neg=true;
		}
		int num=0;
		while(si<str.length() && Character.isDigit(str.charAt(si))) {

			int digit=str.charAt(si)-'0';
			num=num*10+digit;
			si++;

		}

		if(neg) num=-num;


		// Start making tree

		Node <Integer> root=new Node<Integer>(num);
		if(si>=str.length()) {
			return null;
		}

		if(str.charAt(si)=='('  && si<str.length()) {
			return root.left=helper(str , si+1);
		}
		if(str.charAt(si)==')' && si<str.length()) {
			return root=helper(str, si+1);
		}
		return root;

	}

	public static void print(Node<Integer> root) {
		if(root==null) {
			return;
		}
		
		print(root.left);
		System.out.print(root.data+" ");
		print(root.right);
		
		
	}
	



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "4(2(3)(1))(6(5))";
		Node <Integer> r=string2Tree(str);
		print(r);
		

	}

}
