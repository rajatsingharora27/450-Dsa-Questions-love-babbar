package dynamicProgramming;

public class QUE_451 {


	public static int allPallendromicSubsequence(String str) {

		int li=str.length()-1;
		int si=0;

		return allPallendromicSubsequence(str,si,li);


	}





	private static int allPallendromicSubsequence(String str, int si, int li) {

		if(si==li) {
			return 1;
		}
		if(si>li) {
			return 0;
		}

		if(str.charAt(si)==str.charAt(li)) {
			return 1+ allPallendromicSubsequence(str,si+1,li)+allPallendromicSubsequence(str,si,li-1);
		}

		else {

			return allPallendromicSubsequence(str, si+1, li) +allPallendromicSubsequence(str, si, li-1)-
					allPallendromicSubsequence(str, si+1, li-1);

		}
	}
	
	// Using memoization
	public static int allPallendromicSubsequenceMemo(String str) {

		int li=str.length()-1;
		int si=0;
		int dp[][]=new int [str.length()][str.length()];
		
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp.length;j++) {
				dp[i][j]=-1;
			}
		}
		

		return allPallendromicSubsequenceMemo(str,si,li,dp);

	}

	





	private static int allPallendromicSubsequenceMemo(String str, int si, int li,int dp[][]) {


		if(si==li) {
			return 1;
		}
		if(si>li) {
			return -1;
		}

		if(dp[si][li]!=-1) {
			return dp[si][li];
		}
		
		
		if(str.charAt(si)==str.charAt(li)) {
			return dp[si][li]= 1+ allPallendromicSubsequenceMemo(str,si+1,li,dp)+allPallendromicSubsequenceMemo(str,si,li-1,dp);
		}

		else {

			return dp[si][li]=allPallendromicSubsequenceMemo(str, si+1, li,dp) +allPallendromicSubsequenceMemo(str, si, li-1,dp)-
					allPallendromicSubsequenceMemo(str, si+1, li-1,dp);

		}
		
	}





	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str="abcd";
		System.out.println(allPallendromicSubsequence(str));
		System.out.println(allPallendromicSubsequenceMemo(str));


	}

}
