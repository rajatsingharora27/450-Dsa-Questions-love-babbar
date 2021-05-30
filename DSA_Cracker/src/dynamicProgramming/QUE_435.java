package dynamicProgramming;


import java.util.Arrays;


public class QUE_435 {
	
	public static int maxSumPairWithDifferenceLessThanK(int arr[],int N,int k) {
		
		
		Arrays.sort(arr);
		
		int l=0;
		int r=arr.length-1;
		while(l<r) {
			
			int temp=arr[l];
			arr[l]=arr[r];
			arr[r]=temp;
			r--;
			l++;
		}
		
		int i=1;
		int sum=0;
		while(i<arr.length) {
			int x=Math.abs(arr[i]-arr[i-1]);
			if(x<k) {
				sum+=arr[i]+arr[i-1];
				i=i+2;
			}
			else {
				i++;
			}
		}
		
//		for(int p=0;p<arr.length;p++) {
//			System.out.print(arr[p]+" ");
//		}
		
		return sum;	
	}
	
	
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {3};
		System.out.println(maxSumPairWithDifferenceLessThanK(arr, arr.length, 4));

	}

}
