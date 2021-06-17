package matrix;
import java.util.*;
public class QUE_53 {
	
	public static void commonElements(int mat[][]) {
		
		HashMap<Integer,Integer> map=new HashMap<>();
		
		for(int i=0;i<mat[0].length;i++) {
			if(!map.containsKey(mat[0][i])) {
				map.put(mat[0][i], 1);
			}
		}
		
		
		for(int i=1;i<mat.length;i++) {
			for(int j=0;j<mat[0].length;j++) {
				 
				if(map.containsKey(mat[i][j]) && (map.get(mat[i][j]))==i) {
					
					map.put(mat[i][j], map.get(mat[i][j])+1);
					
				}
			}
		}
		
		System.out.println(map);
		
		Set<Integer> keys=map.keySet();
		for(Integer ele : keys) {
			if(map.get(ele)==mat.length) {
				System.out.print(ele);
			}
			//System.out.print(ele+" ");
		}
		
		
		
		
		
		
		
	}
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int mat[][] =
		    {
		        {1, 2, 3, 7, 8},
		        {3, 7, 3, 5, 1},
		        {8, 7, 7, 3, 1},
		        {4, 4, 4, 7, 4},
		        
		    };
		
		commonElements(mat);
		
	}

}
