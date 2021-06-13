package dynamicProgramming;

public class QUE_449 {
	
	//Using Recursion
	
	
	public  static boolean PartitionEqualSubsetSum(int arr[],int n) {
		
		// similar to bounded knapSack Problem
		

		
		//getting the knapsack size
		int sum=0;
		for(int i=0;i<arr.length;i++) {
			sum+=arr[i];
		}
		if(sum%2!=0) {
			return false;
		}
		
		
		
		
		int ks=sum/2; // knapsack size
		
		return partition(arr,ks,0,n);
		
	}
	
	

	private static boolean partition(int[] arr, int ks, int si, int n) {
		
		if(ks!=0 && si==n) {
			return false;
		}
		
		if(ks==0) {
			return true;
		}
		
		if(ks<arr[si]) {
			return partition(arr, ks, si+1, n);
		}
		
		boolean include=partition(arr, ks-arr[si], si+1, n);
		boolean exclude=partition(arr, ks, si+1, n);
		
		return(include|| exclude);
		
		
	}


	// Using DP

	public static boolean partitionDP(int arr[],int n) {
		
		int sum=0;
		for(int i=0;i<arr.length;i++) {
			sum+=arr[i];
		}
		
		if(sum%2!=0) {
			return false;
		}
		int ks=sum/2;
	
		boolean dp[][]=new boolean[arr.length+1][ks+1];
		
		for(int i=1;i<=ks;i++) {
			dp[0][i]=false;
		}
		
		for(int i=0;i<=arr.length;i++) {
			dp[i][0]=true;
		}
		
		for(int i=1;i<=arr.length;i++) {
			for(int j=1;j<=ks;j++) {
				
				if(j<arr[i-1]) {
					dp[i][j]=dp[i-1][j];
				}
				else if(j==arr[i-1]) {
					dp[i][j]=true;
				}
				
				
				else if(j>arr[i-1]) {
					dp[i][j]=(dp[i-1][j-arr[i-1]] || dp[i-1][j]);
				}
			}
		}
		
		return dp[arr.length][ks];
		
		
	}
	
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n=4;
		int arr[]= {1,2,11,4};
		System.out.println(PartitionEqualSubsetSum(arr,n));
		System.out.println(partitionDP(arr,n));
		
		

	}

}
