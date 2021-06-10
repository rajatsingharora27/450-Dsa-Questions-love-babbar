package stack;

public class Small_interval implements Comparable<Small_interval> {
	
	int first;
	int second;
	
	public Small_interval(int first,int second) {
		// TODO Auto-generated constructor stub
		this.first=first;
		this.second=second;
		
		
	}

	@Override
	public int compareTo(Small_interval o) {
		// TODO Auto-generated method stub
		return this.first-o.first;
	}
	
	

}
