package Practice;

public class MinimumCostPAth {


	public static int minimiCostPath(int mat[][]) {

		
		System.out.println(mat.length+" "+mat[0].length);
		
		return minimiCostPath(mat,0,0);
	}




	private static int minimiCostPath(int[][] mat, int i, int j) {

		
		
		if(i==mat.length-1 && j==mat[0].length-1) {
			return mat[i][j];
		}
		
		if(!isValid(mat,i,j)) {
			return 0;
		}


		


		return  mat[i][j]+ Math.min(minimiCostPath(mat,i,j+1),minimiCostPath(mat,i+1,j));

	}




	private static boolean isValid(int[][] mat, int i, int j) {
		
		if(i==mat.length  || j==mat[0].length) {
			return false;
		}
		return true;
		
	}



	//Using dp
	
	public static int minPathDp(int mat[][]) {
		
		int dp[][]=new int[mat.length][mat[0].length];
		
		dp[0][0]=mat[0][0];
		
		for(int i=1;i<mat.length;i++) {
			dp[0][i]=dp[0][i-1]+mat[0][i];
		}
		
		for(int i=1;i<mat[0].length;i++) {
			dp[i][0]=dp[i-1][0]+mat[i][0];
		}
		
		
		for(int i=1;i<mat.length;i++) {
			for(int j=1;j<mat[0].length;j++) {
				dp[i][j]=Math.min(dp[i-1][j], dp[i][j-1])+mat[i][j];
			}
		}
		return dp[mat.length-1][mat[0].length-1];
		
		
		
		
		
		
	}
	
	
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int mat[][]= {	{1,3,1},
						{2,3,2},
						{4,3,1}};
		System.out.println(minimiCostPath(mat));
		System.out.println(minPathDp(mat));
		
		
		
		

	}

}
