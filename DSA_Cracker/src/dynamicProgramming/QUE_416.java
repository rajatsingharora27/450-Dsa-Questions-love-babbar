package dynamicProgramming;

public class QUE_416 {

	
	//Using Recursion
	public static int editDistance(String s , String t) {
		
		int m=s.length();
		int n=t.length();
		
		return editDistance(s, t,m,n);
	}
	
	
	
	
	private static int editDistance(String s, String t, int m, int n) {
		
		if(m==0) {
			return n;
		}
		if(n==0) {
			return n;
		}
		
		if(s.charAt(m-1) == t.charAt(n-1)) {
			return editDistance(s, t, m-1, n-1);
		}
		else {
			
			int insert=editDistance(s, t, m-1, n);
			int remove=editDistance(s, t, m, n-1);
			int replace=editDistance(s, t, m-1, n-1);
			
			return 1+Math.min(replace, Math.min(insert, remove));
			
			
		}
		
		
		
		
	}


	//Using DP
	
	public static int editDistanceDp(String s, String t) {
		int m=s.length();
		int n=t.length();
		int dp[][]=new int[m+1][n+1];
		for(int i=0;i<=m;i++) {
			dp[i][0]=i;
		}
		for(int i=0;i<=n;i++) {
			dp[0][i]=i;
		}
		
		for(int i=1;i<=m;i++) {
			for(int j=1;j<=n;j++) {
				
				if(s.charAt(i-1)==t.charAt(j-1)) {
					dp[i][j]=dp[i-1][j-1];
				}
				else {
					dp[i][j]=1+Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
				}
				
			}
		}		
	return dp[m][n];
	}
	
	
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="sunday";
		String t="saturday";
		System.out.println(editDistance(s, t));
		System.out.println(editDistanceDp(s,t));

	}

}
