 package stack;

import java.util.Stack;

public class NextGreatestElement {

	public static void nextGrestestlelement(int arr[]) {
		
		int ans[]=new int[arr.length];
		//ans[0]=-1;
		Stack <Integer> s=new Stack<>();
		for(int i=arr.length-1;i>=0;i--) {
		
			while(!s.isEmpty() && s.peek()<=arr[i]) {
				s.pop();
			}
			if(s.isEmpty()) {
				ans[i]=-1;
			}
			else {
				ans[i]=s.peek();
			}		
			s.push(arr[i]);
		}
		for(int i=0;i<ans.length;i++) {
			System.out.print(ans[i]+" ");
		}
		
		
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {4, 5, 2, 25};
		nextGrestestlelement(arr);

	}

}
