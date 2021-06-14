package arrays;

public class QUE_37 {

	public static void ThreeWayPart(int arr[],int a, int b) {
		
		
		int li= dutchalgo(arr,0,0,arr.length-1, a);
		dutchalgo(arr, li+1, li+1, arr.length-1, b );

		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}

	}





	private static int dutchalgo(int[] arr, int low, int mid, int high,int pivot) {
		
		while(mid<=high) {

			if(arr[mid]==pivot) {
				mid++;
			}
			else if(arr[mid]<pivot) {
				swap(low,mid,arr);
				low++;mid++;
			}
			else if(arr[mid]>pivot) {
				swap(mid,high,arr);
				high--;
			}		
		}
		return low;		
	}

	private static void swap(int low, int mid, int[] arr) {

		int temp=arr[low];
		arr[low]=arr[mid];
		arr[mid]=temp;
		return;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= { 76, 8, 75 ,22 ,59 ,96,30 ,38 ,36 };
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		ThreeWayPart(arr, 44, 62);

	}

}
