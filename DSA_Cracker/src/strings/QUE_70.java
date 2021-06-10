package strings;

import java.util.Arrays;

public class QUE_70 {

	public static int nextPermute(int arr[]) {

		int i=0;
		int j=arr.length-1;
		int min=Integer.MAX_VALUE;
		int number_to_return=-1;

		// combine the array to the number
		
		String s1="";
		for(int k=0;k<arr.length;k++){
			s1+=arr[k];
		}
		
		int num=Integer.parseInt(s1);

		while(i<j) {
			
			arr=swap(i,j,arr);

			//changing a[] to complete integer
			
			String s2="";
			for(int k=0;k<arr.length;k++){
				s2+=arr[k];
			}
			
			
			int convertedNum=Integer.parseInt(s2);
			int diff=convertedNum-num;
			arr=swap(i,j,arr);
			if(diff<0) {

				if(diff<min) {

					diff=min;
					number_to_return=convertedNum;
				}
				i++;
			}
			else {
				j--;

			}
			System.out.println(num+" "+convertedNum);
		}
		return number_to_return;

	}







	private static int[] swap(int i, int j,int arr[]) {
		int arr_return[]=arr;

		int temp=arr_return[i];
		arr_return[i]=arr_return[j];
		arr_return[j]=temp;

		return arr_return;
	}







	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {3,2,1};
		System.out.println(nextPermute(arr));

	}

}
