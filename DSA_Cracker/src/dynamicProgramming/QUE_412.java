package dynamicProgramming;

public class QUE_412 {

	//Recursive solution

	public static int binomial(int n,int r) {
		if(r==0 ||n==r ) {
			return 1;
		}
		if(n<r) {
			return 0;
		}

		int val1=binomial(n-1, r-1);
		int val2=binomial(n-1,r);

		return val1+val2;
	}

	//Using DP

	public static int binomialDP(int n,int r) {

		int mod=(int) (Math.pow(10,9)+7);
		int dp[][]=new int[r+1][n+1];

		for (int i=0;i<=n;i++) {
			dp[0][i]=1;
		}

		for(int i=1;i<=r;i++) {
			for (int j=1;j<=n;j++) {
				if(i>j) {
					dp[i][j]=0;
				}
				else if(i==j) {
					dp[i][j]=1;
				}
				else {
					int val1=dp[i-1][j-1];
					int val2=dp[i][j-1];
					dp[i][j]=(val1+val2)%mod;		
				}
			}
		}

		


		return dp[r][n];
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(binomial(6,4));
		System.out.println(binomialDP(30,15));

	}

}
