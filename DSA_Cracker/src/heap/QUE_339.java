package heap;
import java.util.*;
public class QUE_339 {

	public static int [] Klargest(int arr[],int k) {
		
		PriorityQueue<Integer> minHeap=new PriorityQueue<>();
		
		
		for(int i=0;i<k;i++) {
			minHeap.add(arr[i]);
		}
		
		for(int i=k;i<arr.length;i++) {
			if(arr[i]>minHeap.peek()) {
				minHeap.poll();
				minHeap.add(arr[i]);
			}
		}
		ArrayList<Integer>array=new ArrayList<>();
		while(minHeap.size()!=0) {
			array.add(0,minHeap.poll());
		}
		
		int a[]=new int [array.size()];
		for(int l=0;l<array.size();l++) {
			a[l]=array.get(l);
		}
		
		return a;
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {1,23,12,9,30,2,50};
		int a[]=Klargest(arr, 3);
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
	}

}
