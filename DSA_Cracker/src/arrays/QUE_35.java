package arrays;
import java.lang.reflect.Array;
import java.util.*;

public class QUE_35 {

	public static long findMinDiff(ArrayList<Long> a, long n,long m) {

		Collections.sort(a);

		long diff=Long.MAX_VALUE;

		if(a.size()<m){
			return 0;
		}

		int  i=0;
		long j=i+m-1;

		while(j<a.size()){
			long d=a.get((int) j)-a.get(i);
			if(diff>d){
				diff=d;
			}
			j++;
			i++;
		}

		return diff;

	}






	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Long>arr=new ArrayList<>();
		//3, 4, 1, 9, 56, 7, 9, 12
		arr.add((long) 3);
		arr.add((long) 4);
		arr.add((long) 1);
		arr.add((long) 9);
		arr.add((long) 56);
		arr.add((long) 7);
		arr.add((long) 9);
		arr.add((long) 12);
		System.out.println(findMinDiff(arr, arr.size(), 5));
	}

}
