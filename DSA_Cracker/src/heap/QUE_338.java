package heap;
import java.util.*;
public class QUE_338 {

	
	public static ArrayList<Integer> getMaxInK(int arr[],int k){
		
		PriorityQueue<Integer> heap=new PriorityQueue<>(Collections.reverseOrder());
		ArrayList<Integer> ans=new ArrayList<>();
		for(int i=0;i<=arr.length-k;i++) {
			
			int j=i;
			
			while(j-i<k) {
				heap.add(arr[j]);
				j++;
			}
			int a=heap.poll();
			ans.add(a);	
			
			while(heap.size()!=0) {
				heap.poll();
			}
			
			
		}
		return ans;
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[]= { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		ArrayList<Integer>arr=getMaxInK(array,10);
		for (Integer ele:arr) {
			System.out.print(ele+" ");
		}

	}

}
