package arrays;

public class QUE_31 {

	
	public static int maxProfit(int arr[]) {
		
		// form left to right max profit
		//if we buy today and sell in future 
		//for profit
		
		int mpif[]=new int[arr.length];
		int maxProfit=0;
		int minCurrent=Integer.MAX_VALUE;
		
		
		for(int i=0;i<mpif.length;i++) {
			
			if(arr[i]<minCurrent) {
				minCurrent=arr[i];
			}
			if(arr[i]-minCurrent>maxProfit) {
				int tempProfit=arr[i]-minCurrent;
				maxProfit=Math.max(maxProfit, tempProfit);
				mpif[i]=maxProfit;
			}
			else {
				mpif[i]=Math.max(maxProfit, arr[i]-minCurrent);
			}
		}
		
		
		
		int mpat=0;
		int currentMAx=arr[arr.length-1];
		int mpbf[]=new int[arr.length];
		for(int i=arr.length-2;i>=0;i--) {
			if(arr[i]>currentMAx) {
				currentMAx=arr[i];
			}
			if(currentMAx-arr[i]>mpat) {
				int temp=currentMAx-arr[i];
				mpat=Math.max(mpat, temp);
				mpbf[i]=mpat;
			}
			else {
				mpbf[i]=Math.max(mpat, currentMAx-arr[i]);
			}
		}
		
		
		int ans[]=new int[arr.length];
		int max_=0;
		for(int i=0;i<ans.length;i++) {
			int sum=mpbf[i]+mpif[i];
			ans[i]=sum;
			if(sum>max_) {
				max_=sum;
			}
		}
		
		for(int i=0;i<ans.length;i++) {
			System.out.print(mpif[i]+" ");
		}
		System.out.println();
		
		for(int i=0;i<ans.length;i++) {
			System.out.print(mpbf[i]+" ");
		}
		System.out.println();
		
		
		
		for(int i=0;i<ans.length;i++) {
			System.out.print(ans[i]+" ");
		}
		
		System.out.println();
		
		return max_;
		
		
		
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		int arr[]= {90, 80, 70, 60, 50};
		System.out.println(maxProfit(arr));
		
	}
	
	
	
	
}
