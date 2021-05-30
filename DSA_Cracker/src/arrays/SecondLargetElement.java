package arrays;
import java.util.*;
public class SecondLargetElement {

	
	public static int secondLargest(int arr[]) {
		
		
		PriorityQueue<Integer> minHeap= new PriorityQueue<>();
		
		if(arr.length==2) {
			return Math.min(arr[0], arr[1]);
		}
		else if(arr.length<2 && arr.length!=0){
			return arr[0];
		}
		
		else {
			
			
			//making initial required initializations
			minHeap.add(arr[0]);
			int second=0;
			if(minHeap.peek()<arr[1]) {
				second=arr[1];
			}
			else {
				second=minHeap.peek();
			}
			minHeap.add(arr[1]);
			int i=2;
			while(i<arr.length) {
				
				
				if(minHeap.peek()!=arr[i] &&  second!=arr[i]) {
					
					if(minHeap.size()==2) {
						
						minHeap.poll();
						minHeap.add(arr[i]);
						
						if(arr[i]>second) {
							second=arr[i];
						}	
					}
				}
				i++;
			}
			//System.out.println(minHeap.peek());
			//minHeap.poll();
			return minHeap.peek();
			
		}
	}
	
	public static int secondlargest2Pointer(int arr[]) {
		
		if(arr.length<1) {
			return -1;
		}
		
		
		if(arr.length==2) {
			return Math.min(arr[0], arr[1]);
		}
		
		int first=arr[0];
		int second=Integer.MIN_VALUE;
		int i=1;
		
		while(i<arr.length) {
			
			if(arr[i]==first || arr[i]==second) {
				i++;
			}
			
			else if (arr[i]>first){
				int temp=first;
				first=arr[i];
				second=temp;
			}
			else if(arr[i]<first && arr[i]>second) {
				second=arr[i];
			}
			i++;
		}
		
		return second;
		
	}
	
	
	
	
	public static void main(String[] args) {
		
		int arr[]= {12, 35, 1, 10, 34, 1};
		
		//System.out.println(secondLargest(arr));	
		System.out.println(secondlargest2Pointer(arr));	

	}

}
