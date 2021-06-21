package greedy;

import java.util.ArrayList;
import java.util.Arrays;

public class QUE_247 {

	public static ArrayList<Integer> candyShop(int arr[],int N, int K){

		Arrays.sort(arr);
		ArrayList<Integer>a=new ArrayList<Integer>();
		if(arr.length==0){
			return  a;
		}
		int min=0;
		int min_can_get=0;
		
		int l=0;
		for(int i=0;i<arr.length;i++){
			if(min_can_get>=N-l){
				a.add(min);
				break;
			}
			else{
				min_can_get+=K;
				min+=arr[i];
			}
			l++;
		}

		int max=0;
		int max_can_get=0;
		//int totalCandies=N;
		int j=0;
		for(int i=arr.length-1;i>=0;i--){
			if(max_can_get>=N-j){
				a.add(max);
				break;
			}
			else{
				max_can_get+=K;
				max+=arr[i];
			}
			j++;
		}

		return a;



	}




	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
