package greedy;

public class Meeting implements Comparable<Meeting> {

	int start;
	int end;
	int pos;

	public Meeting(int start ,int end,int pos) {
		// TODO Auto-generated constructor stub
		this.start=start;
		this.end=end;
		this.pos=pos;
	}

	@Override
	public int compareTo(Meeting o) {
		// TODO Auto-generated method stub
		return this.end-o.end;
	}
}





