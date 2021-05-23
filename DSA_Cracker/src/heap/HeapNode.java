package heap;




public class HeapNode implements Comparable<HeapNode>{

	int data;
	int col;
	int row;

	public HeapNode(int data,int row,int col) {
		// TODO Auto-generated constructor stub
		this.data=data;
		this.col=col;
		this.row=row;
	}
	@Override
	public int compareTo(HeapNode o) {
		// TODO Auto-generated method stub
		return this.data-o.data;
	}

}




