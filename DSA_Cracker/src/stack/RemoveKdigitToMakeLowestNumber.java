package stack;
import java.util.*;
public class RemoveKdigitToMakeLowestNumber {


	public static int lowestNumber(int num,int k) {

		//converting num to the array

		String nums=""+num;
		System.out.println(nums);
		int arr[]=new int[nums.length()];

		for(int i=0;i<arr.length;i++) {
			arr[i]=nums.charAt(i)-'0';
		}

		//make a stack
		Stack<Integer> s=new Stack<>();


		int i=0;
		while(i<arr.length) {

			if(s.isEmpty()){
				s.push(arr[i]); continue;
			}

			else if(!s.isEmpty() && arr[i]>s.peek() && k>0) {
				s.push(arr[i]);continue;
			}
			else {
				while(k>0 && arr[i]<s.peek()) {

					s.pop();
					k--;
					if(s.isEmpty()) {
						s.push(arr[i]);
						break;
					}	
					else if(!s.isEmpty() && arr[i]<s.peek()) {
						continue;
					}

				}
				s.push(arr[i]);
			}

			i++;		
		}


		if(k==0 && i<arr.length) {
			while(i<arr.length) {
				s.push(arr[i]);
				i++;
			}
		}

		while(!s.isEmpty()) {
			System.out.print(s.pop()+" ");
		}
		return 0;

	}






	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num=14301620;
		lowestNumber(num, 4);

	}

}
