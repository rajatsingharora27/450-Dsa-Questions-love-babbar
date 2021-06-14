package arrays;

public class QUE_34 {

	public static int TrappingWater(int arr[]) {
		// Brute fore method
		// for every point i will
		//check max on left and max on right
		//sum=min(max left,max right)-arr[i]
		// this approach take o(n^2)
		// and o(1) space

		int sum=0;

		for(int i=0;i<arr.length;i++) {

			int max_left=0;
			int max_right=0;

			//for max left
			for(int l=i-1;l>=0;l--) {

				if(arr[l]>arr[i] && max_left<arr[l]) {
					//System.out.println("l");
					max_left=arr[l];
				}
			}

			// for max right
			for(int r=i+1;r<arr.length;r++) {
				if(arr[r]>arr[i] && max_right<arr[r] ) {
					//System.out.println("r");
					max_right=arr[r];
				}

			}

			int a=Math.min(max_left, max_right)-arr[i];
			if(a>0) {
				sum+=a;
			}
			//
		}
		return sum;


	}



	// better approach with space o(n) time and space
	
	public static int TrappingWater2(int arr[]) {
		
		
		int prefix[]=new int [arr.length];
		int suffix[]=new int [arr.length];
		
		// pre processing 
		int maxLeft=arr[0];
		prefix[0]=arr[0];
		for(int i=1;i<arr.length;i++){
			if(arr[i]>prefix[i-1]) {
				maxLeft=arr[i];
				prefix[i]=maxLeft;
			}
			else {
				prefix[i]=prefix[i-1];
			}
			
		}
		suffix[arr.length-1]=arr[arr.length-1];
		int maxRight=arr[arr.length-1];
		for(int i=arr.length-2;i>=0;i--){
			if(arr[i]>suffix[i+1]) {
				maxRight=arr[i];
				suffix[i]=maxRight;
			}
			else {
				suffix[i]=suffix[i+1];
			}
		}
		
		int sum=0;
		for(int i=0;i<arr.length;i++) {
			
			int s=Math.min(prefix[i],suffix[i])-arr[i];
			sum+=s;	
		}

		return sum;
		
		
		
	}

	// best approach with o(1) space and o(n) time
	public static int TrappingWater3(int arr[]) {
		
		int leftMax=0;
		int rightMax=0;
		int l=0;
		int r=arr.length-1;
		//int i=0;
		int sum=0;
		while(l<=r) {
			
			if(arr[l]<=arr[r]) {
				if(leftMax<=arr[l]) {
					leftMax=arr[l];
				}
				else {
					sum+=leftMax-arr[l];
				}
				l++;
			}
			
			else {
				
				if(rightMax<=arr[r]) {
					rightMax=arr[r];
				}
				else {
					sum+=rightMax-arr[r];
				}
				r--;
			}
			
			
		}
		return sum;
			
	}
	
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		//System.out.println(TrappingWater(arr));
		
		System.out.println(TrappingWater2(arr));
		System.out.println(TrappingWater3(arr));
	}

}
