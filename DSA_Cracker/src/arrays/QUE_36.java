package arrays;

public class QUE_36 {

	public static long sb(long a[], long n, long x) {
		
		long curr_sum=0;
		long start=0;
		long end=0;
		long len=Long.MAX_VALUE;
		while(end<a.length) {
			
//			curr_sum+=a[(int) end];
//			if(curr_sum<x) {
//				end++;
//			}
			
			while(curr_sum<=x && end<a.length) {
				curr_sum+=a[(int)end++];
			}
			
			
			
			while(curr_sum>x && start<n) {
				if(end-start<len) {
					len=end-start-1;
				}
				curr_sum=curr_sum-a[(int)start++];
			}	
		}
		return len;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long arr[]= {1, 10, 5, 2, 7};
		System.out.println(sb(arr, arr.length, 9));

	}

}
