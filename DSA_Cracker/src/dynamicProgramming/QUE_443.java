package dynamicProgramming;

public class QUE_443 {
	
	
	 static final int MOD = 1000000007;
	    static long countBT(int h){
	        long[] dp = new long[h + 1];
	         
	        // base cases
	        dp[0] = 1;
	        dp[1] = 1;
	         
	        for(int i = 2; i <= h; ++i)
	            dp[i] = (dp[i - 1] * ((2 * dp [i - 2])% MOD + dp[i - 1]) % MOD) % MOD;
	             
	            return dp[h];
	    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
