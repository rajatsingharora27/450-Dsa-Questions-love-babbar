package stack;

import java.util.Stack;

public class QUE_312 {

	public static int maxArea(int arr[]) {


		

		//Getting the left limits i.e next smallest element to left for current element

		int leftLimit[]=new int[arr.length];
		Stack<Integer> st=new Stack<>();
		leftLimit[0]=-1;
		st.push(0);

		for(int i=0;i<arr.length;i++) {
			while(!st.isEmpty() && arr[st.peek()]>arr[i]) {
				st.pop();
			}
			if(st.size()==0) {
				leftLimit[i]=-1;
			}
			else {
				leftLimit[i]=st.peek();
			}
			st.push(i);
		}
		
		
		
		//getting right limit 
		int rightLimit[]=new int[arr.length];
		Stack<Integer> s=new Stack<>();
		rightLimit[arr.length-1]=arr.length;
		st.push(arr.length-1);

		for(int i=arr.length-2;i>=0;i--) {
			while(!st.isEmpty() && arr[st.peek()]>arr[i]) {
				st.pop();
			}
			if(st.size()==0) {
				rightLimit[i]=arr.length;
			}
			else {
				rightLimit[i]=st.peek();
			}
			s.push(i);
		}
		
		
		
		
		





		//after we got limit
		int maxArea=0;
		for(int i=0;i<arr.length;i++) {


			int a=leftLimit[i];
			int b=rightLimit[i];
			int area=(b-a-1)*arr[i];
			System.out.println(area);
			if(area>maxArea) {
				maxArea=area;
			}


		}

		return maxArea;





	}







	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[]= {6,2,5,4,5,1,6};
		System.out.println(maxArea(arr));

	}

}
