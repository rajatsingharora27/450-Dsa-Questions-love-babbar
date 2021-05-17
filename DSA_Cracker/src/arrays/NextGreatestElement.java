package arrays;

import java.util.*;


public class NextGreatestElement {

	public static long[] nextGreatestElement(long[] arr, int n) {

		Stack<Integer> stack=new Stack<>();
		long[] nge=new long [n];

		stack.push(0);

		for(int i=1;i<n;i++) {

			if(arr[i]<arr[stack.peek()]) {
				stack.push(i);
			}
			else {
				while( !stack.isEmpty() && arr[i]>arr[stack.peek()] ) {
					nge[stack.peek()]=arr[i];
					stack.pop();
				}
				stack.push(i);
			}
		}

		while(!stack.isEmpty()) {

			nge[stack.peek()]=-1;
			stack.pop();	
		}

		return nge;


	}




	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long[] arr= {4, 5, 2, 25, 10};
		long a[]=nextGreatestElement(arr,arr.length);
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}


	}

}
