package matrix;

public class QUE_50 {
	public static int maxDiff(int mat[][]) {



		// get the index value 

		int max=Integer.MIN_VALUE;
		int row=0;
		int col=0;
		//O(n^2)
		System.out.println("hello");
		for(int i =0;i<mat.length;i++) {
			for(int j=0;j<mat[0].length;j++) {
				if(mat[i][j]>max) {
					max=mat[i][j];
					row=i;col=j;
				}
			}
		}
		int min=Integer.MAX_VALUE;

		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if(mat[i][j]<min) {
					min=mat[i][j];
				}
			}
		}

		System.out.println(max+" "+min);

		return max-min;









	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mat[][] = {
				{-1 ,-2 ,-3},
				{-4 ,-5, -6},
				{-7 ,-8 ,-9}
		};

		System.out.print("Maximum Value is " + maxDiff(mat));

	}

}
