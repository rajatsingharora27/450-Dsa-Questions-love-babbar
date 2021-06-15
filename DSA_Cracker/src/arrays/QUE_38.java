package arrays;

public class QUE_38 {
	
	
	// time complexity is O(nK) and space complexity is O(1)
	//we are traversing each element in array 
	//in window and in the window we are chceking 
	//the number > k 
	
	public static int minSwaps(int arr[],int k) {
		int windowSize=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]<=k) {
				windowSize++;
			}
		}
		
		int i=0,j=windowSize-1;
		int min_Swaps=windowSize;
		
		while(j<arr.length) {
			
			int l=i;
			int swapInWindndow=0;;
			while(l<=j) {
				if(arr[l]>k) {
					swapInWindndow++;
				}
				l++;
			}
			if(swapInWindndow<min_Swaps) {
				min_Swaps=swapInWindndow;
			}
			i++;j++;
		}
		return min_Swaps;	
	}
	
	
	// better method is O(n)
	public static int minSwaps2(int arr[] ,int k) {
		
		int windowSize=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]<=k) {
				windowSize++;
			}
		}
		int i=0,j=windowSize-1;
		int good=windowSize, bad=0;
		int mi=Integer.MAX_VALUE;
		
		for(;i<=j;i++) {
			if(arr[i]>=k) {
				bad++;
			}
			else {
				good++;
			}
		}
		
		j=windowSize;
		i=1;
		while(j<arr.length) {
			mi=Math.min(mi, bad);
			if(j<arr.length &&  arr[j]>k) bad++;
			else {
				bad--;
			}
			
			if(arr[i]>k)bad++;
			else {
				bad--;
			}
			i++;
			j++;
			
		}
		if(mi==Integer.MAX_VALUE) {
			return 0;
		}
		return mi;
		
	}
	
	
	
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {2, 7, 9, 5, 8, 7, 4};
		System.out.println(minSwaps(arr, 6));
		System.out.println(minSwaps2(arr, 6));
		}

	}


