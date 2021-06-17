package matrix;

public class HeapNodeSort implements Comparable<HeapNodeSort> {
	
	int row;int col;int data;
	
	public HeapNodeSort(int row,int col ,int data) {
		this.row=row;
		this.col=col;
		this.data=data;
	}



	@Override
	public int compareTo(HeapNodeSort o) {
		// TODO Auto-generated method stub
		return this.data-o.data;
	}
	
	

}
