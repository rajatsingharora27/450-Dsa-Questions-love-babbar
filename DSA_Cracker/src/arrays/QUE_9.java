package arrays;

public class QUE_9 {
	
	public static void DutchFlagAlgo(int arr[]) {
		int mid=0;
		int low=0;
		int high=arr.length-1;
		
		while(mid<=high) {
			if(arr[mid]==0) {
				swap(low,mid,arr);
				mid++;
				low++;
			}
			
			else if(arr[mid]==1) {
				mid++;
			}
			else if(arr[mid]==2) {
				swap(mid,high,arr);
				high--;
			}		
		}
		
	}
	
	
	
	
	

	private static void swap(int i, int j,int arr[]) {
		// TODO Auto-generated method stub
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
		return;	
		
	}






	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
