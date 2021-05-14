package dynamicProgramming;

public class QUe_410 {

	// recursive solution
	
	public static void coinChangeRec(int amount,int coin[]) {
		System.out.println(combo(amount,coin,0));
	}
	
	public static int combo(int amount,int coins[], int currentCoin){
		
		if( amount == 0)
			return 1;
		
		if( amount < 0)
			return 0;
		
		int nCombos = 0;
		for( int coin = currentCoin; coin < coins.length; coin++){
			nCombos += combo(amount - coins[coin],coins,coin);
		}
		
		return nCombos;
	}
	
	
	
	//Dynamic solution
	public static int coinChange(int coin[],int n, int m) {
		
		//n total amount;
		//m size of array
		
		int dp[][]=new int[m+1][n+1];
		
		for(int i=1;i<=m;i++) {
			for(int j=1;j<=n;j++) {
				
				if(j-coin[i-1]<0) {
					dp[i][j]=dp[i-1][j];
				}
				else if(j-coin[i-1]>0) {
					dp[i][j]=dp[i-1][j]+dp[i][j-coin[i-1]];
				}
				else {
					dp[i][j]=dp[i-1][j]+1;
				}
			}
		}
		
		return dp[m][n];
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int coin []= {1,2,3};
		int m=coin.length;
		int n=5;
		System.out.println(coinChange(coin,n,m));
		coinChangeRec(n,coin);

	}

}
