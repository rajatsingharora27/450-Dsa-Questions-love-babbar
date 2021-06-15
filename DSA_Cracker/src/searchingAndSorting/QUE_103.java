package searchingAndSorting;

public class QUE_103 {

	
	// time is (o(log n)) but more traversal is there
	
	public static int searchInRotatedArray(int arr[],int x) {

		int pivot=breakPoint(arr,0,arr.length-1);
		System.out.println(pivot);

		//now do binary search from[0..pivot] and [pivot+1..li]

		int left=-1;
		int right=-1;



		left=bs(arr,0,pivot,x);

		right=bs(arr,pivot+1,arr.length-1,x);




		if(left>0) {
			return left;
		}
		else if(right>0) {
			return right;
		}
		else {
			return -1;
		}
	}


	private static int bs(int[] arr, int si, int li, int x) {



		while(si<=li) {
			int mid=si+(li-si)/2;
			if(arr[mid]==x) {
				return mid;
			}
			else if(arr[mid]>x) {
				li=mid;
			}
			else {
				si=mid+1;
			}
		}
		return -1;

	}


	private static int breakPoint(int[] arr, int si, int li) {

		int mid=si+(li-si)/2;

		if(li<si || mid<=0) {
			return -1;
		}

		if(arr[mid]>arr[mid-1] && arr[mid+1]<arr[mid]) {
			return mid;
		}
		else if(arr[mid]>arr[si]) {
			return breakPoint(arr, mid+1, li);
		}
		else {
			return breakPoint(arr, si, mid-1);
		}


	}


	// with only one traversal and tme logn
	
	public static int searchInRotatedArray2(int arr[],int x) {
		
		int si=0;
		int li=arr.length-1;
		
		while(si<=li) {
			
			int mid=si+(li-si)/2;
			
			if(arr[mid]==x) {
				return mid;
			}
			
			//increasing sequence
			else if(arr[mid]>=arr[si]) {
				if(arr[mid]>=x && arr[si]<=x) {
					li=mid-1;
				}
				else {
					si=mid+1;
				}
			}
			else {
				if(arr[mid]<=x && arr[si]>=x) {
					si=mid+1;
				}
				else {
					li=mid-1;
				}
			}
		}
		return -1;
	}
	
	
	
	
	



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {5,1,3};
		System.out.println(searchInRotatedArray(arr, 5));
		System.out.println(searchInRotatedArray2(arr,5));
	}

}
