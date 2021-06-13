package Practice;

public class SecondLargest {

	
	public  static int secondLargest(int arr[]) {
		int first=Integer.MAX_VALUE;
		int second=Integer.MAX_VALUE;
		
		for(int i=0;i<arr.length;i++) {
			
//			if(arr[i]>first && arr[i]>second) {
//				
//			}
			
			if(arr[i]<first && arr[i]<second && second!=arr[i]) {
				first=second;
				second=arr[i];
			}
			else if(arr[i]<first && arr[i]>second) {
				first=arr[i];
			}
		}
		return first;
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		int arr[]= {12, 13, 1, 10, 34, 1};
		System.out.println(secondLargest(arr));
		
		
	}

}
