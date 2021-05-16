package dynamicProgramming;

public class QUE_428 {

	public static int maxsumIs(int n,int arr[]) {


		int dp[]=new int [n];
		
		for(int i=0;i<n;i++) {
			dp[i]=arr[i];
		}
		
//		for(int i=0;i<n;i++) {
//			System.out.print(dp[i]+" ");
//		}
		
		
		
		for(int i=1;i<n;i++) {
			int max=arr[i];
			for(int j=i-1;j>=0;j--) {
				
				if(arr[i]>arr[j]) {
					int tempmax=dp[j]+arr[i];
					if(max<tempmax) {
						max=tempmax;
					}
				}
			}
			dp[i]=max;
		}
		
		int m=0;
		for(int i=0;i<n;i++) {
			if(m<dp[i]) {
				m=dp[i];
			}
			System.out.print(dp[i]+" ");
		}
		
		return m;
	}




	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {1, 101, 2, 3, 100};
		int n=arr.length;
		maxsumIs(n,arr);
		

	}

}
