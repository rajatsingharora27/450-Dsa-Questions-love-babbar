package Practice;

public class coinChangeUnbounded {
	
	//Using Recursion
	//It is application of 0/1 knapsack
	
	public static int coinChange(int coins[],int amt) {
		
		
		return coinChange(coins ,amt,0);
		
		
	}


	private static int coinChange(int[] coins, int amt, int si) {
		
		if(amt<0) {
			return 0;
		}
		if(amt==0) {
			return 1;
		}
		
		int nCombos=0;
		for(int i=si;i<coins.length;i++) {
			int include=coinChange(coins, amt-coins[si],si);
			int exclude=coinChange(coins, amt, si+1);
			nCombos=include+exclude;
		}
		return nCombos;
		
	}









	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int coins[]= {2,5,3,6};
		int amt=10;
		System.out.println(coinChange(coins, amt));
	
	}

}
