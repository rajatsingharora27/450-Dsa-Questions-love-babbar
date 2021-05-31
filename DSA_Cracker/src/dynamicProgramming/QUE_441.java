package dynamicProgramming;

public class QUE_441 {
	
	//Recursion
	public static int longestCommonStr(String s1,String s2,int m,int n) {
		
		if(n==0||m==0) {
			return 0;
		}
		
		if(s1.charAt(n-1)==s2.charAt(m-1)) {
			return 1+longestCommonStr(s1, s2, m-1, n-1);
		}
		
		else {
			
			int op1=longestCommonStr(s1, s2, m-1, n);
			int op2=longestCommonStr(s1, s2, m, n-1);
			return Math.max(op1, op2);
			
		}		
	}
	//DP
	public static int longestCommonStrDP(String S1,String S2, int m, int n) {
		
		int dp[][]=new int[n+1][m+1];

		for(int i=0;i<=n;i++) {

			for(int j=0;j<=m;j++) {


				if(i==0||j==0) {
					dp[i][j]=0;
				}

				else if(S1.charAt(i-1)==S2.charAt(j-1)&&(i-1<=0 || j-1<=0)) {
					dp[i][j]=1;
				}


				else if(S1.charAt(i-1) ==S2.charAt(j-1) && S1.charAt(i-2) ==S2.charAt(j-2) ) {
					dp[i][j]=1+dp[i-1][j-1];
				}

				else if(S1.charAt(i-1) ==S2.charAt(j-1) && S1.charAt(i-2) !=S2.charAt(j-2) ) {	
					dp[i][j]=1;
				}

				else {

					dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
				}

			}
		}
		
// 		for( int i =0;i<=n;i++) {
// 			for ( int j=0;j<=m;j++) {
// 				System.out.print(dp[i][j]+" ");
// 			}
// 			System.out.println();
// 		}
            int max=Integer.MIN_VALUE;
		for( int i =0;i<=n;i++) {
			for ( int j=0;j<=m;j++) {
				if(max<dp[i][j]) {
					max=dp[i][j];
				}
			}
		}


		return max;

		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1="ABCDGH";
		String s2="ACDGHR";
		System.out.println(longestCommonStr(s1, s2, s1.length(), s2.length()));

	}

}
