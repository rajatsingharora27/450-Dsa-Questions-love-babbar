package arrays;
import java.util.*;
public class QUE_29 {

	public static int longestConsicutiveSeries(int arr[]) {
		int largetLen=0;
		HashSet<Integer> map=new HashSet<>();
		for(int i=0;i<arr.length;i++) {
			map.add(arr[i]);
		}

		for(int i=0;i<arr.length;i++) {

			//if predecessor is there
			//we want smallest start point
			//no use in this case just continue
			if(map.contains(arr[i]-1)) {
				continue;
			}
			else {
				int count=1;
				int predecessor=arr[i];
				while(map.contains(predecessor+1)) {
					count++;
					predecessor=predecessor+1;
				}
				if(count>largetLen) {
					largetLen=count;
				}		
			}		
		}

		return largetLen;
	}





	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {102,4,100,1,101,3,2};
		System.out.println(longestConsicutiveSeries(arr));


	}

}
