package matrix;
import java.util.*;
public class QUE_48 {
	
	public static void sortSortedMAterix(int mat[][]) {
		
		PriorityQueue<HeapNodeSort> heap=new PriorityQueue<>();
		
		for(int i=0;i<mat.length;i++) {
			HeapNodeSort h=new HeapNodeSort(i, 0, mat[i][0]);
			heap.add(h);
		}
		
		int ans[][]=new int[mat.length][mat[0].length];
		
		while(heap.size()>0) {
			
			HeapNodeSort first=heap.poll();
			
			
			
			
			
			
			
			System.out.print(first.data+" ");
			if(first.col+1<mat[0].length) {
				heap.add(new HeapNodeSort(first.row, first.col+1, mat[first.row][first.col+1]));
			}	
			
			
				
			
			
			
		}	
	}
	
	
	

	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int Mat[][]= {{10,20,30,40},
		     {15,25,35,45}, 
		     {27,29,37,48}, 
		     {32,33,39,50}};
		
		sortSortedMAterix(Mat);

	}

}
