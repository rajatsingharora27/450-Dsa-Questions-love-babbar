package dynamicProgramming;

public class QUE_427 {

	
	// Using Recursion
	public static int LCSof3Rec(String str1,String str2,String str3) {
		
		return LCSof3Rec(str1,str2,str3,0,0,0);
	}
	
	
	
	private static int LCSof3Rec(String str1, String str2, String str3, int i, int j, int k) {
		// TODO Auto-generated method stub
		
		if(i==str1.length() || j==str2.length() || k==str3.length()) {
			return 0;
		}
		
		else if(str1.charAt(i)==str2.charAt(j) &&  str2.charAt(j)==str3.charAt(k)) {
			return 1+LCSof3Rec(str1, str2, str3, i+1, j+1, k+1);
		}
		else {
			
			int op1=LCSof3Rec(str1, str2, str3, i+1, j, k);
			int op2=LCSof3Rec(str1, str2, str3, i, j+1, k);
			int op3=LCSof3Rec(str1, str2, str3, i, j, k+1);
		
			return(Math.max(op1, Math.max(op2, op3)));
			
		}
	}



	// Using DP
	public static int LCSof3(String str1,String str2,String str3) {
		
		int m=str1.length();
		int n=str2.length();
		int r=str3.length();
		
		int dp[][][]=new int[m+1][n+1][r+1];
		
		for(int i=0;i<=m;i++) {
			for(int j=0;j<=n;j++) {
				for(int k=0;k<=r;k++) {
					
					if(i==0 || j==0 || k==0) {
						dp[i][j][k]=0;
					}
					
					else if(str1.charAt(i-1)==str2.charAt(j-1) &&  str2.charAt(j-1)==str3.charAt(k-1)) {
						
						dp[i][j][k]=1+dp[i-1][j-1][k-1];
					}
					else {
						dp[i][j][k]=Math.max(dp[i-1][j][k], Math.max(dp[i][j-1][k], dp[i][j][k-1]));
					}
					
					
				}
			}
		}
		
		return dp[m][n][r];
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(LCSof3Rec("AGGT12","12TXAYB","12XBA"));
		System.out.println(LCSof3("AGGT12","12TXAYB","12XBA"));

	}

}
