package greedy;

import java.util.ArrayList;
import java.util.Collections;

public class QUE_238 {
	// Activity Selection 
	
	
	public static int NMeetingInRoom(int s[],int f[]) {
		
		ArrayList<Meeting> array=new ArrayList<>();
		
		for(int i=0;i<s.length;i++) {
			Meeting m=new Meeting(s[i],f[i],i+1);
			array.add(m);
		}
		int count=1;
		Collections.sort(array);
		
		for(Meeting m:array) {
			System.out.println(m.start+" "+m.end+" "+m.pos);
		}
		//return 0;
		//int i=0;
		
		Meeting first=array.get(0);
		
		for(int i=1;i<array.size();i++) {
			if(first.end<array.get(i).start) {
				count++;
				first=array.get(i);
			}
			
			
		}
		return count;
		
	
	}
	
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int S[] = {1,3,8,5,0,5};
		int F[] = {2,4,9,7,6,9};
		
		System.out.println(NMeetingInRoom(S, F));
		

	}

}
