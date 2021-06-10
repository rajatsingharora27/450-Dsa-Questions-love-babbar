package stack;
import java.util.*;
public class QUE_309 {

	//Reverse Stack without using loop

	static Stack<Integer> st=new Stack<>();
	public static void revStack() {

		if(!st.isEmpty()) {

			int peek=st.peek();
			st.pop();
			revStack();
			insert_at_bottom(peek);	
		}	
	}







	private static void insert_at_bottom(int x) {

		if(st.isEmpty()) {
			st.push(x);
		}
		else {


			int p=st.peek();
			st.pop();
			insert_at_bottom(x);
			st.push(p);		
		}		
	}







	public static void main(String[] args) {
		// TODO Auto-generated method stub
		st.push(1);
		st.push(2);
		st.push(3);
		st.push(4);
		revStack();

		System.out.println(st);



	}
}
