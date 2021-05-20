package arrays;

public class QUE_10 {

	public static void rearrange(int arr[]) {
		
		int i=0;
		int j=arr.length-1;
		
		while(i<j) {
			
			if(arr[i]<0 &&  arr[j]<0) i++;
			else if(arr[i]>0 &&  arr[j]>0) j--;
			else if(arr[i] > 0 && arr[j] < 0) {
				int temp = arr[i];
	            arr[i] = arr[j];
	            arr[j] = temp;
	            i++;
	            j--;
			}
			else {
				i++;
				j--;
			}	
		}
		
		for(int k=0;k<arr.length;k++) {
			System.out.print(arr[k]+" ");
		}
		
		
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = { -12, 11, -13, -5,
                6, -7, 5, -3, 11 };
		rearrange(arr);

	}

}
