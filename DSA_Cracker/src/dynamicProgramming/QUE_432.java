package dynamicProgramming;

public class QUE_432 {
	
	public static int eggDrop(int n,int k) {
		
		int dp[][]=new int [n+1][k+1];
		
		for(int i=0;i<dp.length;i++) {
			
			for(int j=0;j<dp[0].length;j++) {
				
				if(i==0) {dp[i][j]=0;continue;}
				
				if(j==0) continue;
				
				if(i==1) {dp[i][j]=j;continue;}
				
				if(j==1) {dp[i][j]=1;continue;}
				
				dp[i][j]=Integer.MAX_VALUE;
				
				for(int f=1;f<=j;f++) {
					int breaked=dp[i-1][f-1];
					int survived=dp[i][j-f];
					int res=1+Math.max(breaked, survived);
					if(res<dp[i][j]) {
						dp[i][j]=res;
					}
				}			
			}
		}
		
		return dp[n][k];
		
	}
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(eggDrop(3, 5));
	}

}
