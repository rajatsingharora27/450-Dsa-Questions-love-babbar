package dynamicProgramming;

// Longest Pallendromic Substring

public class QUE_452 {


	// recursion/
	public static int longestPallendromicSubstring(String str) {

		int si=0,li=str.length()-1;
		return longestPallendromicSubstring(str,si,li);
	}



	private static int longestPallendromicSubstring(String str, int si, int li) {

		if(si==li) {
			return 1;
		}

		if(si>li) {
			return 0;
		}

		if(str.charAt(si)==str.charAt(li)) {

			//internal length of remaining string
			int lengthOfRem=li-si-1;
			if(lengthOfRem==longestPallendromicSubstring(str, si+1, li-1)) {
				return lengthOfRem+2;
			}
		}

		return Math.max(longestPallendromicSubstring(str, si+1, li), longestPallendromicSubstring(str, si, li-1));	

	}


	// Using DP

	public static int LongetPallendromicSubstringDP(String str) {


		int dp[][]=new int[str.length()][str.length()];


		for(int i=0;i<str.length();i++) {
			dp[i][i]=1;
		}

		for(int i=0;i<str.length();i++) {
			if(i+1<str.length()) {
				if( str.charAt(i)==str.charAt(i+1)) {
					dp[i][i+1]=1;
				}
				else {
					dp[i][i+1]=0;
				}
			}
		}

		
		for (int k = 3; k <= dp.length; ++k) {
			
			for (int i = 0; i < dp.length - k + 1; ++i) {
				
				
				int j=k+i-1;
				
				if(str.charAt(i)==str.charAt(j)) {
					if(dp[i+1][j-1]==1) {
						dp[i][j]=1;
					}
					else {
						dp[i][j]=0;
					}
				}
			
			}
			
		}
		
		int start=0;
	
		
		for(int i=0;i<dp.length;i++) {
			if(dp[i][dp.length-1]==1) {
				start=i;
				break;
			}
		}
		
		System.out.println(str.substring(start,dp.length));
		
		







		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp.length;j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}

		return 0;

	}














	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="aaaabbaa";

		//System.out.println(longestPallendromicSubstring(str));
		System.out.println(LongetPallendromicSubstringDP(str));



	}

}
