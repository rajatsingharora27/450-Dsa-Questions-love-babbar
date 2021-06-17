package matrix;

public class QUE_45 {

	//Brute Force time complexity O(m*n)
	public boolean searchMatrix1(int[][] matrix, int target) {

		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[0].length;j++) {
				if(matrix[i][j]==target) {
					return true;
				}
			}
		}
		return false;		 
	}

	// using liner search
	// time to find range O(row)
	// time to linearly travel O(col)
	// O(m+n)

	public boolean searchMatrix(int[][] matrix, int target) {

		int left=0;
		int right=matrix[0].length-1;
		int index=-1;

		for(int i=0;i<matrix.length;i++) {
			if(matrix[i][left]<=target && target<=matrix[i][right]) {
				index=i;
			}
		}

		if(index==-1) {
			return false;
		}

		//linear Search
		for(int i=0;i<matrix[0].length;i++) {
			if(matrix[index][i]==target) {
				return true;
			}
		}
		return false;

	}



	//using binary search
	// time complexity O(row +logn)
	public static boolean searchMatrix3(int[][] matrix, int target) {

		int left=0;
		int right=matrix[0].length-1;
		int index=-1;

		for(int i=0;i<matrix.length;i++) {
			if(matrix[i][left]<=target && target<=matrix[i][right]) {
				index=i;
			}
		}

		if(index==-1) {
			return false;
		}

		//binary search
		return bs(matrix ,index,0,matrix[0].length-1,target);

	}


	private static boolean bs(int[][] matrix, int index ,int si , int li,int x) {
		
		while(si<=li) {
			
			int mid=si+(li-si)/2;
			
			if(matrix[index][mid]==x) {
				return true;
			}
			
			else if(matrix[index][mid]>x) {
				li=mid-1;
			}
			else {
				si=mid+1;
			}
			
		}
		return false;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int matrix[][]= {{1,3,5,7},{10,11,16,20},{23,30,44,60}};
		System.out.println(searchMatrix3(matrix,45));

	}

}
