package binaryTrees;
import java.util.*;


public class VerticalTraversl {
	
	
	public static List<List<Integer>> vertical(Node<Integer> root){
		
		//Hash map
		HashMap<Integer,List<Integer>> map=new HashMap<>();
		
		//Answer list
		List<List<Integer>>ans =new ArrayList<>();
		vPair pair=new vPair();
		Queue<vPair> q=new LinkedList<>();
		
		int minh=0;
		int maxh=0;
		
		
		
		pair.level=0;
		pair.node=root;
		
		q.add(pair);
		
		
		while(!q.isEmpty()) {
			
			int size=q.size();
			
			while(size-- >0) {
				
				vPair firstPair=q.poll();
				
				minh=Math.min(firstPair.level, minh);
				maxh=Math.max(firstPair.level, maxh);
				
				map.putIfAbsent(firstPair.level, new ArrayList<>());
				map.get(firstPair.level).add(firstPair.node.data);
				
				if(firstPair.node.left!=null) {
					vPair leftSide=new vPair();
					leftSide.level=firstPair.level-1;
					leftSide.node=firstPair.node.left;
					q.add(leftSide);
				}
				
				if(firstPair.node.right!=null) {
					vPair rightSide=new vPair();
					rightSide.level=firstPair.level+1;
					rightSide.node=firstPair.node.right;
					q.add(rightSide);
				}			
			}
		}
		
		
		for(int i=minh;i<=maxh;i++) {
			ans.add(map.get(i));
		}
		
		return ans;
		
		
		
		
		
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
