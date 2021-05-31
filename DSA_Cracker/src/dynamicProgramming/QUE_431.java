package dynamicProgramming;

public class QUE_431 {
	
	public static int maxSumWo3const(int arr[]) {
		
		int dp[]=new int[arr.length];
		
		for(int i=0;i<arr.length;i++) {
			dp[i]=-1;
		}
		
		return maxSumWo3const(arr,dp,arr.length-1);
		
	}
	
	
	
	
	

	private static int maxSumWo3const(int[] arr, int[] dp, int i) {
		
		if(i==-1) {
			return 0;
		}
		if(i==0) {
			return arr[0];
		}
		if(i==1) {
			return arr[0]+arr[1];
		}
		if(dp[i]!=-1) {
			return dp[i];
		}
		
		int op1=maxSumWo3const(arr, dp, i-2)+arr[i];
		int op2=maxSumWo3const(arr, dp, i-3)+arr[i]+arr[i-1];
		int op3=maxSumWo3const(arr, dp, i-1);
		return dp[i]=Math.max(op1, Math.max(op2, op3));
		
		
	}






	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]={3000, 2000, 1000, 3, 10};
		System.out.println(maxSumWo3const(arr));

	}

}
