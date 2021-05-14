package dynamicProgramming;

public class QUE_417 {
	
	public static boolean isSubset(int arr[] , int n) {
		
		int sum=0;
		
		for (int i=0 ; i <n ; i++) {
			sum+=arr[i];
		}
		
		if(sum%2!=0) {
			return false;
		}
		
		int target=sum/2;
		int ssf=0;
		
		return isSubset(arr,n,ssf,target,0);	
	}
	
	
	

	private static boolean isSubset(int[] arr, int n, int ssf, int target, int i) {
	
		if(ssf==target) {
			return true;
		}
		
		if(i==n && ssf!=target) {
			return false;
		}
		
		if(arr[i]>target) {
			return isSubset(arr, n, ssf, target, i+1);		
			
		}
		
		return isSubset(arr, n, ssf+arr[i], target, i) || isSubset(arr, n, ssf, target, i+1);
	}




	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[]= {3, 1, 5, 9, 12};
		int n=arr.length;
		System.out.println(isSubset(arr, n));

	}

}
