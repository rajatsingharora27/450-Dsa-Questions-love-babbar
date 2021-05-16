package dynamicProgramming;

public class QUE_423 {
	
	//  Recursive LCS
	
	public static int LCS(String str1, String str2) {
		
		return LCS(str1, str2,0,0);
		
	}
	
	private static int LCS(String str1, String str2, int i, int j) {
		// TODO Auto-generated method stub
		if(i==str1.length() || j==str2.length()) {
			return 0;
		}
		
		if(str1.charAt(i)==str2.charAt(j)) {
			return 1+LCS(str1,str2,i+1,j+1);
		}
		
		int op1=LCS(str1,str2,i,j+1);
		int op2=LCS(str1,str2,i+1,j);
		return Math.max(op1, op2);
	}


	// Using DP
	
	public static int LCSDp(String str1, String str2) {
		int row=str1.length();
		int col=str2.length();
		int dp[][]=new int [str1.length()+1][str2.length()+1];
		
		for(int i=0;i<=row;i++) {
			dp[i][0]=0;
		}
		for(int j=0;j<=col;j++) {
			dp[0][j]=0;
		}
		
		
		for(int i=1;i<=row;i++) {
			for(int j=1;j<=col;j++) {
				
				if(str1.charAt(i-1)==str2.charAt(j-1)) {
					dp[i][j]=1+dp[i-1][j-1];
				}
				else {
					int op1=dp[i-1][j];
					int op2=dp[i][j-1];
					dp[i][j]=Math.max(op1, op2);
				}
			}
		}
		return dp[row][col];
		
	}
	
	
	



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(LCS("AGGTAB" , "GXTXAYB"));
		System.out.println(LCSDp("AGGTAB" , "GXTXAYB"));

	}

}
