package stack;
import java.util.*;

public class QUE_311 {

	public static int [][]overlapping(int interval[][]){

		ArrayList<Small_interval> array=new ArrayList<>();
		Stack<Small_interval> st=new Stack<>();

		for(int i=0;i<interval.length;i++) {

			Small_interval si=new Small_interval(interval[i][0], interval[i][1]);
			array.add(si);
		}
		Collections.sort(array);



		st.push(array.get(0));

		for(int i=1;i<array.size();i++) {

			Small_interval ele=st.pop();
			if(ele.second>array.get(i).first) {
				Small_interval combo=new Small_interval(ele.first, array.get(i).second);
				st.push(combo);
			}
			else {
				st.push(ele);
				st.push(array.get(i));
			}		
		}


	

		System.out.println(st);




		int result[][]=new int[st.size()][2];
		int i=0;
		while(!st.isEmpty()) {
			
			Small_interval p=st.peek();
			result[i][0]=p.first;
			result[i][1]=p.second;
			st.pop();
			i++;

		}

		return result;


	}





	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int mat[][]={{1,3},{2,4},{6,8},{9,10}};


		int ans[][]=overlapping(mat);

		for(int i=ans.length-1;i>=0;i--) {
			System.out.println(ans[i][0]+" "+ans[i][1]);
		}
		
		
		
	}

}
