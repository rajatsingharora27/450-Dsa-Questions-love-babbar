package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class QUE_239 {

	public static int jobSequencing(Job arr[],int n) {
		
		Arrays.sort(arr);
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i].id+" "+arr[i].deadline+" "+arr[i].profit);
		}
		
		int array[]=new int [arr.length];
		
		for(int i=0;i<array.length;i++) {
			array[i]=-1;
		}
		
		int count=0;
		for(int i=0;i<arr.length;i++) {
			if(array[arr[i].deadline-1]==-1) {
				array[arr[i].deadline-1]=arr[i].profit;
				count+=arr[i].profit;
			}
			else {
				//
				int j=arr[i].deadline-2;
				while(j>=0) {
					if(array[j]==-1) {
						array[j]=arr[i].profit;
						count+=arr[i].profit;
						break;
					}
					j--;
				}
				
				
				
			}
		}
		
		return count;
		
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Job arr[]=new Job[5];
		for(int i=0;i<arr.length;i++) {
			System.out.println("Enter id , deadline,  profit  "+i+": ");
			Job j=new Job(sc.nextInt(),sc.nextInt(),sc.nextInt());
			arr[i]=j;
		}
		 
		
		System.out.println(jobSequencing(arr, 5));
		

	}

}
