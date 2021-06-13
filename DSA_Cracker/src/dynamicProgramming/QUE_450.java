package dynamicProgramming;

import java.lang.reflect.Array;
import java.util.Arrays;

public class QUE_450 {
	
	public static int LargetPallendromicSubsequence(String str) {
		int si=0;
		int li=str.length()-1;
		
		return LargetPallendromicSubsequence(str,si,li);
	
	}
	
	
	

	private static int LargetPallendromicSubsequence(String str, int si, int li) {
		
		if(si==li) return 1;
		if(si>li) return 0;
		
		// when both are same
		
		if(str.charAt(si)==str.charAt(li)) {
			return 2+LargetPallendromicSubsequence(str, si+1, li-1);
		}
		
		else {
			
			int op1=LargetPallendromicSubsequence(str, si+1, li);
			int op2=LargetPallendromicSubsequence(str, si, li-1);
			
			return Math.max(op1, op2);	
		}
	}


	//memoization
	
	public static int LargertPallenDromicSubMemo(String str) {
		
		
		int dp[][]=new int [str.length()][str.length()];
		
		int si=0;
		int li=str.length()-1;
		
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp.length;j++) {
				dp[i][j]=-1;
			}
		}
		
		return LargertPallenDromicSubMemo(str,si,li,dp);
		
	}
	
	
	
	
	

 
	private static int LargertPallenDromicSubMemo(String str, int si, int li, int[][] dp) {
		
		if(si==li) {
			return dp[si][li]=1;
		}
		if(si>li) {
			return dp[si][li]=-1;
		}
		if(dp[si][li]!=-1) {
			return dp[si][li];
		}
		if(str.charAt(si)==str.charAt(li)) {
			return 2+LargertPallenDromicSubMemo(str, si+1, li-1, dp);
		}
		else {
			
			int op1=LargetPallendromicSubsequence(str, si+1, li);
			int op2=LargetPallendromicSubsequence(str, si, li-1);
			
			return dp[si][li]=Math.max(op1, op2);	
			
			
			
		}
		
		
		
		
		
		
	}




	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="GEEKSFORGEEKS";
		System.out.println(LargetPallendromicSubsequence(str));
		System.out.println(LargertPallenDromicSubMemo(str));

	}

}
