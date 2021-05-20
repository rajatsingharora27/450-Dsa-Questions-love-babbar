package arrays;

public class QUE_8 {
	static int count=0;
	public static int KthSmallest(int arr[], int k) {

		return KthSmallest(arr,k,0,arr.length-1);


	}






	private static int KthSmallest(int[] arr, int k, int si, int ei) {


		if(si>=ei) {
			return -1;
		}
		int partIndex=partition(arr,si,ei);
		System.out.println("PartIndex "+partIndex);

		if(partIndex==k) {
			return arr[partIndex];
		}

		if(partIndex>k) {
			return KthSmallest(arr, k,si,partIndex-1);
		}
		else{
			return KthSmallest(arr, k, partIndex+1, ei);
		}


	}






	private static int partition(int[] arr, int si, int ei) {

		int pivot=arr[si];
		int count=0;
		for(int i=si+1;i<=ei;i++) {
			if(arr[i]<=pivot) {
				count++;
			}
		}

		//swap the element
		int pos=si+count;
		int temp=arr[si];
		arr[si]=arr[pos];
		arr[pos]=temp;


		int i=si,j=ei;
		
		while(i<pos && pos<j) {
			
			if(arr[i]>arr[pos] && arr[j]<arr[pos] ) {
				int temp1=arr[i];
				arr[i]=arr[j];
				arr[j]=temp1;
				i++;
				j--;
			}
			else if(arr[i]<arr[pos]) {
				i++;
			}
			else if(arr[j]>arr[pos]) {
				j--;
			}
		}
		
		for(int k=0;k<arr.length;k++) {
			System.out.print(arr[k]+" ");
		}
		System.out.println();
		
		return pos;
		



	}






	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {5,3,2,4,8,1};
		System.out.println(KthSmallest(arr,4));
		

	}

}
