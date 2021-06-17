package matrix;

public class QUE_51 {
	
	// first transpose O(n^2)
	// the reverse O(n^2)
	// time O(n^2)
	
	
	
	
	public static void Rotate90(int mat[][]) {
		
		
		// Transpose the matrix
		for(int i=0;i<mat.length;i++) {
			for(int j=0;j<i;j++) {
				int temp=mat[i][j];
				mat[i][j]=mat[j][i];
				mat[j][i]=temp;
			}
		}
		
		// reverse each row
		for(int i=0;i<mat.length;i++) {
			reverse(mat[i]);
		}
		
		
		for(int i=0;i<mat.length;i++) {
			for(int j=0;j<mat.length;j++) {
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	

	private static void reverse(int[] arr) {
		
		int i=0;
		int j=arr.length-1;
		while(i<j) {
			int temp=arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
			i++;
			j--;
		}
		return;
		
		
	}






	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][] = {
				{ 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
			Rotate90(arr);

	}

}
