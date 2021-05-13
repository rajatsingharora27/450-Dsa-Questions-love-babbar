package dynamicProgramming;

public class CoinChangeWithoutRepetetion {

	public static void coinChange(int arr[],int target) {
		String asf="";
		int ssf=0;
		coinChange(arr,target,ssf,asf,0);
		
	}
	
	
	
	
	
	private static void coinChange(int[] arr, int target, int ssf, String asf,int i) {
		// TODO Auto-generated method stub
		
		if(i==arr.length) {
			if(ssf==target) {
				System.out.println(asf);
			}
		return;
		}
		coinChange(arr,target,ssf+arr[i],asf+arr[i]+"-",i+1);
		coinChange(arr,target,ssf+0,asf,i+1);
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {2,3,5,6,7};
		coinChange(arr,12);

	}

}
