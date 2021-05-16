package dynamicProgramming;

public class QUE_422 {

	public static int maximizeCut(int n , int  x , int  y , int z ) {
		int dp[]=new int [n+1];
		for(int i=0;i<=n;i++) {
			dp[i]=-1;
		}
		int a=maximizeCut(n,x,y,z,dp);
		if(a<0) {
			return 0;
		}
		return a;
	}


	public static int maximizeCut(int n, int x , int y ,int z,int dp[]) {


		int cut_x=Integer.MIN_VALUE;
		int cut_y=Integer.MIN_VALUE;
		int cut_z=Integer.MIN_VALUE;
		
		if(n==0) {
			return 0;
		}

		if(n<0) {
			return 0;
		}


		if(dp[n]!=-1) {
			return dp[n];
		}


		if(n>=x) {
			cut_x=maximizeCut(n-x, x, y, z,dp);
		}
		if(n>=y) {
			cut_y=maximizeCut(n-y, x, y, z,dp);
		}
		if(n>=z) {
			cut_z=maximizeCut(n-z, x, y, z,dp);
		}
		return dp[n]=Math.max(cut_y,Math.max(cut_x, cut_z))+1;

	}


	public static int maxCutDP(int n , int  x, int y ,int z) {

		int dp[]=new int [n+1];

		for(int i=1;i<=n;i++) {

			//int max=Integer.MIN_VALUE;
			int check1=0,check2=0,check3=0;

			if(x>i) {
				check1=0;
			}
			else {
				if(x==i) {
					check1=1;
				}
				else {
					check1=dp[i-x]+1;
				}
			}



			if(y>i) {
				check2=0;
			}
			else {
				if(y==i) {
					check2=1;
				}
				else {
					check2=dp[i-y]+1;
				}
			}



			if(z>i) {
				check3=0;
			}
			else {
				if(z==i) {
					check3=1;
				}
				else {
					check3=dp[i-z]+1;
				}
			}

			dp[i]=Math.max(check1, Math.max(check2, check3));
		}

		for(int i=0;i<dp.length;i++) {
			System.out.print(dp[i]+" ");
		}
		System.out.println();

		return dp[n];
	}





	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maximizeCut(9999, 94, 20, 244));
		//System.out.println(maxCutDP(7, 2, 5, 5));

	}

}
