package searchingAndSorting;
import java.util.*;
public class QUE_101 {

	//using recursion  time o(log n) space o(log n)
	public static  ArrayList<Long> find(long arr[], int n, int x)
	{

		int first=bsfirst(arr,x,0,arr.length-1);
		int second=bssecond(arr,x,0,arr.length-1);

		ArrayList<Long> a=new ArrayList<>();
		a.add((long) first);
		a.add((long) second);
		return a;	 
	}


	private static int bssecond(long[] arr, int x, int si, int li) {

		if(si<=li) {
			int mid=si+(li-si)/2;
			if((arr[mid]== x )   && ( mid==arr.length-1 || arr[mid+1]>x ) )
				return mid; 

			else if(arr[mid]>x) 
				return bssecond(arr, x, si, mid-1);

			else 
				return bssecond(arr, x, mid+1, li);

		}
		return -1;

	}


	private static int bsfirst(long[] arr, int x,int si,int li) {


		if(si<=li) {
			int mid=si+(li-si)/2;
			if((arr[mid]== x )   && ( mid==0 || arr[mid-1]<x ) )
				return mid; 

			else if(arr[mid]>x) 
				return bsfirst(arr, x, si, mid-1);

			else  
				return bsfirst(arr, x, mid+1, li);

		}
		return -1;

	}


	// Using Iterative method

	public static ArrayList<Long> find2(long arr[], int n, int x){
		int f=first(arr,x,arr.length-1);
		int s=last(arr,x,arr.length-1);

		ArrayList<Long> a=new ArrayList<>();
		a.add((long) f);
		a.add((long) s);
		return a;	 
		



	}
	
	
	public static int first(long[] arr,int x, int n)
	{
		int low = 0, high = n - 1,
				res = -1;
		while (low <= high)
		{
			// Normal Binary Search Logic
			int mid = (low + high) / 2;
			if (arr[mid] > x)
				high = mid - 1;
			else if (arr[mid] < x)
				low = mid + 1;

			else
			{
				res = mid;
				high = mid - 1;
			}
		}
		return res;
	}

	
	static int last(long arr[], int x, int n)
	{
		int low = 0, high = n - 1,
				res = -1;
		while (low <= high)
		{
			// Normal Binary Search Logic
			int mid = (low + high) / 2;
			if (arr[mid] > x)
				high = mid - 1;
			else if (arr[mid] < x)
				low = mid + 1;

		
			else
			{
				res = mid;
				low = mid + 1;
			}
		}
		return res;

	}







		public static void main(String[] args) {
			// TODO Auto-generated method stub


			long arr[]={ 1, 3, 5, 5, 5, 5, 67, 123, 125 };
			//System.out.println(find(arr, arr.length, 5));
			System.out.println(find2(arr, arr.length, 5));


		}

	}
