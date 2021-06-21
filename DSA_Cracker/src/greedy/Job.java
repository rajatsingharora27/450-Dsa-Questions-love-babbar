package greedy;

public class Job implements Comparable<Job> {

	int id;
	int deadline;
	int profit;

	public Job(int id,int deadline,int profit) {

		this.id=id;
		this.deadline=deadline;
		this.profit=profit;	
	}

	@Override
	public int compareTo(Job o) {
		return o.profit-this.profit;
	}

//		if(this.deadline>o.deadline) {
//			return -1;
//		}
//		else if(this.deadline<o.deadline) {
//			return 1;
//		}
//		else {
//			return o.profit-this.profit;
//		}	
//	}
}
