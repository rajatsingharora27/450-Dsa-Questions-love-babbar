package dynamicProgramming;

public class QUE_218 {

	public static int friendParing(int n) {

		if(n==0 || n==1 || n==2) {
			return n;
		}

		return friendParing(n-1)+ (n-1)*friendParing(n-2);	
	}


	public static int friendParingDP(int n) {

		int dp[]=new int[n+1];

		for (int i=0;i<=n;i++) {

			if(i<=2) {
				dp[i]=i;
			}
			else {
				dp[i]=dp[i-1]+(i-1)* dp[i-2];
			}
		}

		return dp[n];


	}





	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(friendParing(3));
		System.out.println(friendParingDP(3));

	}

}
