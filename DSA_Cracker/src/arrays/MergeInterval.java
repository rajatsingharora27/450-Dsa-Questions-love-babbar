package arrays;
import java.util.*;
public class MergeInterval {

	public static void mergeInterval(int [][] interval){
		
		ArrayList<ArrayList<Integer>>mainList=new ArrayList<>();
		ArrayList<Integer>first = new ArrayList<>();
		
		Arrays.sort(interval,(a,b)-> a[0]-b[0]);
		first.add(interval[0][0]);
		first.add(interval[0][1]);

		
		int i=0;
		while(i<interval.length) {
			
			if(first.get(1)>=interval[i][0]) {
				ArrayList<Integer>merge=new ArrayList<>();
				merge.add(first.get(0));
				int max_=Math.max(first.get(1), interval[i][1]);
				merge.add(max_);
				first=merge;
				//mainList.add(merge);
				i++;
			}
			else {
				mainList.add(first);
				
				ArrayList<Integer>merge=new ArrayList<>();
				merge.add(interval[i][0]);
				merge.add(interval[i][1]);
				i++;
				first=merge;
				
			}		
		}
		
		if(first!=null) {
			mainList.add(first);
		}
		System.out.println(mainList);
		
		
		return;
		
		
		
		
		
		
//		for(int i=0;i<interval.length;i++) {
//			for(int j=0;j<interval[0].length;j++) {
//				System.out.print(interval[i][j]+" ");
//			}
//			System.out.println();
//		}
			
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] interval= {{1,3},{2,4},{2,6},{8,9},{8,10},{9,11},{15,18},{16,17}};
		mergeInterval(interval);
		

	}

}
