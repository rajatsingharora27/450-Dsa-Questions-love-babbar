package arrays;
import java.util.*;
public class QUE_26 {

	public static boolean subArraySumZero(int arr[]) {
		
		HashMap<Integer,Integer> map=new HashMap<>();
		int s=0;
		for(int i=0;i<arr.length;i++) {
			
			//First Condition/
			if(arr[i]==0) {
				return true;
			}
			
			s=s+arr[i];
			int ele=s;
			//second Condition
			if(ele==0) {
				return true;
			}
			
			
			
			// Third Condition
			
			if(!map.containsKey(ele)) {
				map.put(ele, 1);
			}
			else {
				map.put(ele, map.get(ele)+1);
				if(map.get(ele)==2) {
					return true;
				}
			}	
		}
		
		return false;
		
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int arr[]= {4,2,-3,1,6};
		 System.out.println(subArraySumZero(arr));
		
		
		
	}

}
