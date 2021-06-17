package matrix;

import java.util.PriorityQueue;

public class QUE_52 {
	
	public static int kthSmallest(int[][]mat,int k)
	{
        //code here.
        int count=0;
        PriorityQueue<HeapNodeSort> heap=new PriorityQueue<>();
        for(int i=0;i<mat.length;i++){
        	HeapNodeSort h=new HeapNodeSort (i,0,mat[i][0]);
            heap.add(h);
        }
        
        int ans=0;
        while(count <k && heap.size()>0){
            
        	HeapNodeSort first=heap.poll();
        	System.out.println(first.data);
            if(first.col+1<mat[0].length){
            heap.add(new HeapNodeSort (first.row,first.col+1,mat[first.row][first.col+1]));
            }
            ans=first.data;
            count++;
            
        }
        
        return ans;
       
        
    }
	
	
	
	
	
	
	
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mat[][] =     {{16, 28, 60, 64},
                {22, 41, 63, 91},
                {27, 50, 87, 93},
                {36, 78, 87, 94 }};
		
		System.out.println(kthSmallest(mat, 3));
		

	}

}
