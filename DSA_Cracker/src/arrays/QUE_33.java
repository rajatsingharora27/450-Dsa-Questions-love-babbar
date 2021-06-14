package arrays;

import java.util.Arrays;

public class QUE_33 {
	
	public static boolean tripletSum(int arr[],int X) {
		Arrays.sort(arr);
		for(int i=0;i<arr.length;i++) {
			
			int j=i+1;int sum=arr[i];
			int k=arr.length-1;
			
			while(j<k) {
				int s=arr[j]+arr[k];
				if(sum+s==X) {
					return true;
				}
				else if(sum+s>X) {
					k--;
				}
				else {
					j++;
				}
			}
		}
		return false;
		
		
	}
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {1, 4 ,45, 6 ,10 ,8};
		System.out.println(tripletSum(arr, 13));

	}

}
