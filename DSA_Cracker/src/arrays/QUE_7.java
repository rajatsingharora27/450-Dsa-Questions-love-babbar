package arrays;

public class QUE_7 {
	
	public static void minmax(int arr[]) {
		
		if(arr.length==0) {
			return ;
		}
		
		int min=arr[0];
		int max=arr[1];
		
		for(int i=1;i<arr.length;i++) {
			
			if(min>arr[i]) {
				min=arr[i];
			}
			if(max<arr[i]) {
				max=arr[i];
			}
			
			
		}
		
		System.out.print(min+" "+max);
		
		
		
		
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {1000, 11, 445, 1, 330, 3000};
		minmax(arr);
	}

}
