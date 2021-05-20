package arrays;

public class QUE_6 {
	
	public static int[] reverse(int arr[]) {
		
		int i=0;
		int j=arr.length-1;
		
		while(i<j) {
			
			int temp =arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
			i++;j--;
		}
		
		return arr;
		
		
		
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {1,2,3,4};
		int a[]=reverse(arr);
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}

	}

}
