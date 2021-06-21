package binaryTrees;

public class ConvertStringToTree {

	public static String String2Tree(Node <Integer> root){

		StringBuilder res=new StringBuilder();
		helper(root,res);
		return res.toString();

	}





	private static void helper(Node<Integer> root, StringBuilder res) {
		res.append(root.data);

		if(root.left==null && root.right==null) {
			return;
		}

		res.append('(');
		if(root.left!=null) {
			helper(root.left, res);
		}
		res.append(')');

		if(root.right!=null) {
			res.append('(');
			helper(root.right, res);
			res.append(')');
		}

		return;

	}





	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
