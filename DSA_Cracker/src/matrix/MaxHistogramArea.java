package matrix;

import java.util.Stack;

public class MaxHistogramArea {

	// Brute Force
	//time complexity is 0(n^2)
	public static int maxArea(int arr[]) {
		int max_area=0;
		for(int current_building=0; current_building<arr.length; current_building++) {
			int left=0;
			int right=0;
			int i=current_building+1;
			int j=current_building-1;
			while(i<=arr.length-1 &&   arr[i]>=arr[current_building]) {
				i++;
				right++;
			}
			while( j>=0  &&  arr[j]>=arr[current_building]) {
				j--;
				left++;
			}
			if(max_area<arr[current_building]*(right-left+1)) {
				max_area=arr[current_building]*(right-left+1);
			}

		}
		return max_area;
	} 

	//Using optamized approach

	public static int maxArea2(int arr[]) {

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

//		System.out.println();
		return max_;



	}





	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {1,1};
		System.out.println(maxArea(arr));
		System.out.println(maxArea2(arr));
	}

}
