package arrays;

public class QUE_15 {

	
	
	
	//Recursive
	public static int minJumps(int arr[]) {
		
		return minJumps(arr,0);	
	}
	
	private static int minJumps(int[] arr, int i) {
		// TODO Auto-generated method stub
		
		
		
		if(i>=arr.length) {
			return Integer.MAX_VALUE;
		}
		if(i==arr.length-1) {
			return 0;
		}
		
		
		int minval=Integer.MAX_VALUE;
		int steps=arr[i];
		for(int j=1;j<=steps;j++) {
			minval=Math.min(minval, minJumps(arr, i+j));
		}
		
		return minval+1;
	}

	//DP 
	
	public static int minJumpsDp(int arr[]) {
		
		int dp[]=new int[arr.length];
		
		dp[0]=0;
		
		for(int i=0;i<arr.length;i++) {
			arr[i]=Integer.MAX_VALUE;
		}
		
		
		for(int i=1;i<arr.length;i++) {
			for(int j=0;j<i;j++) {
				
				if(arr[i]+j>=i && dp[j]!=Integer.MAX_VALUE) {
					if(dp[i]>dp[i]+1) {
						dp[i]=dp[j]+1;
					}
				}
			}
		}
		
		return dp[arr.length-1];
	}
	
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {1 ,4 ,3 ,2 ,6 ,7};
		System.out.println(minJumps(arr));
		System.out.println(minJumpsDp(arr));

	}

}
