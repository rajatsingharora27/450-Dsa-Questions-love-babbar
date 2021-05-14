package dynamicProgramming;

public class QUE_425 {

	public static int lis(int arr[]) {

		int n=arr.length;
		int dp[]=new int[n];
		dp[0]=1;

		for(int i=1;i<arr.length;i++) {
			int current_lis=1;
			for(int j=i-1;j>=0;j--) {
				if(arr[i]>arr[j] && current_lis<=dp[j]) {
					current_lis=dp[j]+1;
				}
			}
			dp[i]=current_lis;
		}
		int max=0;
		for(int i=0;i<arr.length;i++) {
			if(max<dp[i]) {
				max=dp[i];
			}
			//System.out.print(dp[i]+" ");
		}
		return max;
	}

	public static int lis2(int arr[]) {
		int max_lenght=0;
		for(int i=0;i<arr.length;i++) {
			int count=0;
			int currentMax=arr[i];
			for(int j=i+1;j<arr.length;j++) {
				if(currentMax<arr[j]) {
					count++;
					currentMax=arr[j];
				}

			}
			if(max_lenght<count) {
				
				max_lenght=count;
				
			}
		}
		
		return max_lenght;
		
		
	}
	
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {10,22,9,33,21,50,41,60};
		//System.out.println(lis(arr));
		System.out.println(lis2(arr));

	}

}
