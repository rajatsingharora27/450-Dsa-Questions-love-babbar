package arrays;
import java.util.*;
public class QUE_23 {

	public static int countPairs(int arr[],int k) {
		
		int count=0;
		HashMap<Integer,Integer> map=new HashMap<>();
		
		for(int i=0;i<arr.length;i++) {
			
			if(!map.containsKey(arr[i])) {
				map.put(arr[i],1);
			}
			else {
				map.put(arr[i],map.get(arr[i])+1);
			}	
		}	
		
		for(int i=0;i<arr.length;i++) {
			
			if(map.get(k-arr[i])!=null) {
				count+=map.get(k-arr[i]);
			}
			if(k-arr[i]==arr[i]) {
				count--;
			}	
		}
		return count/2;
	}
	
	public static void countPairsAllPrint(int arr[],int k) {
		
		
		
		int l=0;
		int r=arr.length-1;
		
		Arrays.sort(arr);
		while(l<r) {
			if(arr[l]+arr[r]>k) {
				r--;
			}
			else if(arr[l]+arr[r]<k) {
				l++;
				
			}
			else {
				
				System.out.println(arr[l]+","+arr[r] );
				
				r--;
				l++;
			}	
		}
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {1,5,7,-1,5};
		System.out.println(countPairs(arr, 6));
		countPairsAllPrint(arr, 6);

	}

}
