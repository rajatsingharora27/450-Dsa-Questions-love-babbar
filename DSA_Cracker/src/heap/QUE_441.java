package heap;


import java.util.*;


public class QUE_441 {
	


	public static ArrayList<Integer> Kmerge(int arr[][],int k){
		
		PriorityQueue<HeapNode> heap=new PriorityQueue<>();
		ArrayList<Integer> array = new ArrayList<>();
		for(int i=0;i<arr.length;i++) {
			
			HeapNode node=new HeapNode (arr[i][0],i,0);
			heap.add(node);
		}
		
		while(heap.size()!=0) {
			
			HeapNode node=heap.remove();
			array.add(node.data);
			
			if(node.col+1<arr[node.row].length) {
				HeapNode element=new HeapNode(arr[node.row][node.col+1],node.row,node.col+1);
				heap.add(element);
			}		
		}
		
		for(Integer ele : array) {
			System.out.print(ele+" ");
		}
		
		return array;
		
		
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][]= {{1,2,3},{4,5,6},{7,8,9}};
		Kmerge(arr, 3);
		

	}

}
