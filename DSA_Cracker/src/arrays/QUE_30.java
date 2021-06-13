package arrays;
import java.util.*;
public class QUE_30 {
	
	
	//Using hash map
	public static int countNBYk(int arr[]) {
		HashMap<Integer,Integer>map=new HashMap<>();
		for(int i=0;i<arr.length;i++) {
			
			if(map.containsKey(arr[i])) {
				map.put(arr[i],map.get(arr[i])+1);
			}
			else {
				map.put(arr[i], 1);
			}
		}
		
		int count=0;
		int compareWith=arr.length/4;
		Set<Integer> keys=map.keySet();
		for(Integer ele:keys) {
			if(map.get(ele)>compareWith) {
				System.out.print(ele+" ");
				count++;
			}
		}
		System.out.println();
		return count;
	}
	
	// Moore's Algorithm Very important
	
	public static int moorseAlgo(int arr[]) {
		
		int count=0;
		int ele=0;
		
		for(int i=0;i<arr.length;i++) {
			
			if(count==0) {
				ele=arr[i];
			}
			if(ele==arr[i]) {
				count++;
			}
			else {
				count--;
			}
		}
		
		int c=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==ele) {
				c++;
			}
		}
		
		if(c>=arr.length/2) {
			return ele;
		}
		return 0;
		
				
				
				
	
		
		
		
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]={3, 2, 2, 2, 1, 2, 3, 3};
		//System.out.println(countNBYk(arr));
		System.out.println(moorseAlgo(arr));

	}

}
