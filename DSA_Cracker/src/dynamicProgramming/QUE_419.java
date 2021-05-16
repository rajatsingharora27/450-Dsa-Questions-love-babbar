package dynamicProgramming;

public class QUE_419 {


	public static void mine(int mine[][]) {

		int dp[][]=new int[mine.length][mine[0].length];

		for(int i=0;i<mine.length;i++) {
			dp[i][0]=mine[i][0];
		}

		for(int col=1; col<mine[0].length;col++) {
			for(int row=0;row<mine.length;row++) {

				int max=Integer.MIN_VALUE;

				if(isValid(row,col-1,mine)) {
					int check1=dp[row][col-1]+mine[row][col];
					if(check1>max) {
						max=check1;
					}	
				}

				if(isValid(row-1,col-1,mine)) {
					int check2=dp[row-1][col-1]+mine[row][col];
					if(check2>max) {
						max=check2;
					}	
				}

				if(isValid(row+1,col-1,mine)) {
					int check3=dp[row+1][col-1]+mine[row][col];
					if(check3>max) {
						max=check3;
					}	
				}
				dp[row][col]=max;	
			}

		}
		
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		
	int max_profit=0;	
	for (int i=0;i<dp.length;i++) {
		if(dp[i][dp[0].length-1]>max_profit) {
			max_profit=dp[i][dp[0].length-1];
		}
	}	
	System.out.println(max_profit);	
		
		
	}


	private static boolean isValid(int i, int j,int mine[][]) {
		
		if(i<0 || j>=mine.length || i>=mine.length) {
			return false;
		}
		return true;	
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mat[][] = {	{1, 3, 1, 5},
                		{2, 2, 4, 1},
                		{5, 0, 2, 3},
                		{0, 6, 1, 2}};
		
		mine(mat);
		
		
		
		
		
	}

}
