package heap;
import java.util.*;

public class AmazonShipment {
	
	public static int totalTime(int arr[]) {
		
		int time=0;
		PriorityQueue<Integer> heap=new PriorityQueue<>();
		for(int i=0;i<arr.length;i++) {
			heap.add(arr[i]);
		}
	
		while(heap.size()!=1) {
			
			int a=heap.poll();
			int b=heap.poll();
			time+=a+b;
			heap.add(a+b);
		}
		
		return time;
	}
	
	
	
	public static void main(String[] args) {
		
		int arr[]= {8,4,6};
		System.out.println(totalTime(arr));
		
		
	}
	
	

}
