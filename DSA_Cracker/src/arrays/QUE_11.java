package arrays;

public class QUE_11 {
	
	public static void union(int arr1[], int arr2[]) {
		
		int i=0,j=0;
		int arr3[]=new int[arr1.length + arr2.length];
		int k=0;
		while(i<arr1.length &&  j<arr2.length) {
			
			if(arr1[i]<arr2[j]) {
				arr3[k]=arr1[i];
				k++;i++;
			}
			
			else if(arr1[i]>arr2[j]) {
				
				arr3[k]=arr2[j];
				j++;
				k++;
				
			}
			
			else if(arr1[i]==arr2[j]) {
				arr3[k]=arr1[i];
				i++;
				j++;
				k++;
			}
			
		}
		
		
		if(i<arr1.length) {
			
			while(i<arr1.length) {
				arr3[k]=arr1[i];
				i++;
				k++;
			}
		}
		
		else {
			
			while(j<arr2.length) {
				arr3[k]=arr2[j];
				j++;
				k++;
			}
			
		}
		
		for(int l=0;l<arr3.length;l++) {
			System.out.print(arr3[l]+" ");
		}
		
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr1[]= {11,15,20,23,40};
		int arr2[]= {9,10,13,17,21,34};
		union(arr1,arr2);

	}

}
