package matrix;

import java.util.Stack;

public class QUE_49 {


	public static int maxAreaofRectangle(int mat[][]) {

		int arr[]=new int[mat[0].length];
		int max_=0;

		for(int i=0;i<mat.length;i++) {

			int j=0;
			while(j<mat[0].length) {

				if(mat[i][j]!=0) {
					arr[j]+=mat[i][j];
				}
				else {
					arr[j]=0;
				}
				j++;
			}	
			
//			for(int k=0;k<arr.length;k++) {
//				System.out.print(arr[k]+" ");
//			}
//			System.out.println();
			
			

			int area=getMaxhistArea(arr);
			if(area>max_) {
				max_=area;
			}
		}
		return max_;
	}




	private static int getMaxhistArea(int[] arr) {
		
		Stack<Integer> s=new Stack<>();

		//left side
		int left[]=new int[arr.length];

		for(int i=0;i<arr.length;i++) {
			if(s.isEmpty()) {
				s.push(i);
				left[i]=0;
			}
			else {
				while(!s.isEmpty() && arr[s.peek()]>=arr[i]) {
					s.pop();
				}
				left[i]=s.isEmpty()?0:s.peek()+1;
				s.push(i);
			}
		}



		while(!s.isEmpty()) {
			s.pop();
		}


		// right side;
		int right[]=new int[arr.length];

		for(int i=arr.length-1;i>=0;i--) {

			if(s.size()==0) {
				s.push(i);
				right[i]=arr.length-1;
			}
			else {
				while(!s.isEmpty() && arr[s.peek()]>=arr[i]) {
					s.pop();
				}
				right[i]=s.isEmpty()?arr.length-1:s.peek()-1;
				s.push(i);
			}
		}
		int max_=0;
		for(int i=0;i<arr.length;i++) {

			if(max_<arr[i]*(right[i]-left[i]+1)) {
				max_=arr[i]*(right[i]-left[i]+1);
			}

		}
//		for(int i=0;i<arr.length;i++) {
//			System.out.print(left[i]+ " " );
//		}
//		System.out.println();
//		for(int i=0;i<arr.length;i++) {
//			System.out.print(right[i]+ " " );
//		}
		

		//System.out.println();
		return max_;
		
		
		
	}




	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int M[][] = {
				{1, 1 ,1 ,1 ,1},
				{0 ,1 ,0 ,0 ,0}};
		
		System.out.println(maxAreaofRectangle(M));
		
		
		
	}

}
