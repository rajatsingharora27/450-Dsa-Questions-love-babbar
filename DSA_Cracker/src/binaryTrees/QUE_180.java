package binaryTrees;

class pair<T,V>{
	
	T first;
	V second;

}

public class QUE_180 {
	
	
	public static int diameter(Node<Integer>root) {
		return diameterHeight(root).second;
	}
	
	public static pair<Integer,Integer> diameterHeight(Node<Integer> root) {
		if(root==null) {
			pair<Integer,Integer> ans=new pair<>();
			ans.first=0;
			ans.second=0;
			return ans;
		}
		pair<Integer,Integer>lo=diameterHeight(root.left);
		pair<Integer,Integer>ro=diameterHeight(root.right);
		
		int height=1+Math.max(lo.first, ro.first);
		int op1=lo.first+ro.first;
		int op2=lo.second;
		int op3=ro.second;
		
		int diameter=Math.max(op1, Math.max(op2,op3));
		
		pair<Integer,Integer> ans=new pair<>();
		ans.first=height;
		ans.second=diameter;
		return ans;
			
	}
	

	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
