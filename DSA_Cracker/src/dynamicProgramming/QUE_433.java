package dynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

class Pair implements Comparable<Pair>{
	int first;
	int second;

	public Pair(int first,int second) {

		this.first=first;
		this.second=second;
	}
	@Override
	public int compareTo(Pair o) {
		return this.first-o.first;
	}
}



public class QUE_433 {



	public static Pair[] pairArray() {

		Scanner sc=new Scanner(System.in);
		System.out.println("Enter size of Pair Array");
		int size=sc.nextInt();
		Pair arr[]=new Pair[size];
		for(int i=0;i<size;i++) {
			System.out.println("Enter first and second number with space");
			int f=sc.nextInt();
			int s=sc.nextInt();
			Pair p=new Pair(f,s);
			arr[i]=p;
		}
		sc.close();
		return arr;

	}

	public static int maxPairLength(Pair arr[],int n) {

		//sorting the Pair array wrt to first element;
		Arrays.sort(arr);

//		for(int i=0;i<arr.length;i++) {
//			System.out.print(arr[i].first +" "+arr[i].second +" , ");
//		}

		int first_[]=new int[n];
		int second_[]=new int[n];

		for(int i=0;i<arr.length;i++) {
			first_[i]=arr[i].first;
			second_[i]=arr[i].second;
		}

		int dp[]=new int [n];
				for(int i=0;i<arr.length;i++) {
					dp[i]=1;
					
				}

		for(int i=1;i<arr.length;i++) {
			//int curret_max=dp[i];
			for(int j=i-1;j>=0;j--) {

				if(first_[i]>second_[j]) {
					if(dp[j]+1>dp[i]) {
						dp[i]=dp[j]+1;
					}
				}
			}
			//dp[i]=curret_max+1;
		}


//		for(int i=0;i<dp.length;i++) {
//			System.out.print(dp[i]+" ");
//		}
		return dp[n-1];

	}







	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pair arr[]=pairArray();
		//System.out.println(arr.length);
		System.out.println(maxPairLength(arr, arr.length));

	}

}
