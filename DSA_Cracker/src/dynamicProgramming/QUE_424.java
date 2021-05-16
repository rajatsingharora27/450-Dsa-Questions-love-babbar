package dynamicProgramming;

public class QUE_424 {

	public static int LongestRepeatingSubsequence(String str)
	{
		// code here
		int row=str.length();
		int col=str.length();
		int dp[][]=new int [str.length()+1][str.length()+1];

		for(int i=1;i<=row;i++){
			for(int j=1;j<=col;j++){
				if(str.charAt(i-1)==str.charAt(j-1) && (i-1)!=(j-1)){
					dp[i][j]=1+dp[i-1][j-1];
				}
				else{
					dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
				}
			}
		}
		return dp[row][col];	    
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(LongestRepeatingSubsequence("aab"));

	}

}
