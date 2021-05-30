package dynamicProgramming;

public class QUE_434 {

	public static int max_one_in_sq(int arr[][]) {
		
		int dp[][]=new int [arr.length][arr[0].length];
		int max=Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				
				if(i==0) {
					dp[i][j]=arr[i][j];
					continue;
				}
				
				if(j==0) {
					dp[i][j]=arr[i][j];
					continue;
				}
				
				if(arr[i][j]==1) {
					dp[i][j]=Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]))+1;
					
				}
				else {
					dp[i][j]=0;
				}
				
				if(max<dp[i][j]) {
					max=dp[i][j];
				}
			}
		}
		
		return max;
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int M[][] = {{0, 1, 1, 0, 1},
                 {1, 1, 0, 1, 0},
                 {0, 1, 1, 1, 0},
                 {1, 1, 1, 1, 0},
                 {1, 1, 1, 1, 1},
                 {0, 0, 0, 0, 0}};
		 System.out.println(max_one_in_sq(M));

	}

}
