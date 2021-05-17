package dynamicProgramming;

public class QUE_430 {

	public static int longestSubseqWithDiffOne(int arr[]) {
		
		int n=arr.length;
		
		int dp[] = new int[n];
		dp[0]=1;
		
		for(int i=1;i<n;i++) {
			
			for(int j=i-1;j>=0;j--) {
				
				int diff=arr[i]-arr[j];
				
				if(Math.abs(diff)==1) {
					
					if(dp[j]==0 && dp[i]==0) {
						dp[i]=2;
					}
					
					else {
						if(dp[j]>dp[i])
						dp[i]=dp[j]+1;
					}
					
				}
			}
		}
		
		int m=Integer.MIN_VALUE;
		for(int i=0;i<n;i++) {
			if(m<dp[i]) {
				m=dp[i];
			}
			System.out.print(dp[i]+" ");
		}
		System.out.println();
		
		
		return m;
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {9, 10, 4 ,5 ,4 ,8, 6};
		
		System.out.println(longestSubseqWithDiffOne(arr));

	}

}
