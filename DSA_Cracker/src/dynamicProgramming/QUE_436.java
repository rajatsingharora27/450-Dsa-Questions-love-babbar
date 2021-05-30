package dynamicProgramming;

public class QUE_436 {
	
	public static int maxPath(int mat[][]) {
		
		int dp[][]=new int [mat.length][mat[0].length];
		
		for(int i=0;i<mat[0].length;i++) {
			dp[0][i]=mat[0][i];
		}
		
		int max=Integer.MIN_VALUE;
		for(int i=1;i<mat.length;i++) {
			
			for(int j=0;j<mat[0].length;j++) {
				
				int op1=0,op2=0,op3=0;
				if(isSafe(i-1,j-1,mat)) {
					op1=dp[i-1][j-1];
				}
				
				if(isSafe(i-1,j,mat)) {
					op2=dp[i-1][j];
				}
				
				if(isSafe(i-1,j+1,mat)) {
					op3=dp[i-1][j+1];
				}
				
				int max_of_three=Math.max(op1, Math.max(op2, op3));
				
				dp[i][j]=max_of_three+mat[i][j];
				
				if(max<dp[i][j]) {
					max=dp[i][j];
				}
			}
		}
		
//		for(int i=0;i<mat.length;i++) {
//			for(int j=0;j<mat[0].length;j++) {
//				System.out.print(dp[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		
		
		
		return max;
	}
	
	


	private static boolean isSafe(int i, int j,int mat[][]) {
		if(i<0 || j<0 || i>=mat.length || j>=mat[0].length) {
			return false;
		}
		return true;
	}






	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int mat[][] = { { 10, 10, 2, 0, 20, 4 },
                 { 1, 0, 0, 30, 2, 5 },
                 { 0, 10, 4, 0, 2, 0 },
                 { 1, 0, 2, 20, 0, 4 }
             };
		 System.out.println(maxPath(mat));
		
		

	}

}
