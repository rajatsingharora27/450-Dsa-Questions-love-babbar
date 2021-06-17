package matrix;

public class QUE_47 {

	
	
	//Time complexity O(row*logn)
	public static int max1Inmateix(int matrix[][]) {

		int min=Integer.MAX_VALUE;
		int rowIndex=0;
		int index=0;
		int colIndex=matrix[0].length-1;
		
		for(int i=0;i<matrix.length;i++) {
			index=bs(matrix,i,0,colIndex);
			//System.out.println(index);
			if(index!=-1 && index<min) {
				min=index;
				colIndex=index;
			}
			//System.out.println(colIndex);
			if(colIndex==0) break;
		}
		return matrix[0].length-colIndex;
	}




	private static int bs(int[][] matrix, int index, int si, int li) {

		while(si<=li) {

			int mid=si+(li-si)/2;
			//System.out.println(mid);
			if(matrix[index][mid]==1 && (mid==0 || matrix[index][mid-1]==0)) {
				return mid;
			}
			else if(matrix[index][mid]==1) {
				li=mid-1;
			}
			else {
				si=mid+1;
			}		
		}

		return -1;

	}


	// time complexity O(m+n)
	//i.e O(max(m,n))
	
	public static int maxNoOf1s(int matrix[][]) {
		
		int i=0,j=matrix.length-1;
		int no_of_1=0;
		int max=0;
		while(true) {
			//System.out.println(i+" "+j);
			if(j<0 || i>=matrix.length) {
				break;
			}
			if(matrix[i][j]==1) {
				j--;
				no_of_1++;
			}
			else if(matrix[i][j]==0) {
				i++;
			}
			if(max<no_of_1) {
				max=no_of_1;
			}
			
		}
		
		return max;
		
	}
	
	
	
	
	
	
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mat[][] = { 
				{ 0, 0 },
				{ 1,1}};
				//{ 0, 1, 1, 1 },
				//{ 0, 0, 1, 1 } };
		System.out.println("Index of row with maximum 1s is "
				+ maxNoOf1s(mat));

	}

}
