package stack;
import java.util.*;

public class QUE_310 {

	public static Stack<Integer> sort(Stack<Integer> s){
		
		if(!s.isEmpty()) {
			
			int peek=s.peek();
			s.pop();
			sort(s);
			insert_inplace(s,peek);
		}
		return s;
	}
	
	
	
	
	
	private static void insert_inplace(Stack<Integer>st, int peek) {
		
		if(st.isEmpty()) {
			st.push(peek);
		}
		
		else if(st.peek()>peek) {
			int p=st.peek();
			st.pop();
			insert_inplace(st, peek);
			st.push(p);
		}
		else {
			st.push(peek);
		}
	}





	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer>s=new Stack<>();
		
		s.push(30);
        s.push(-5);
        s.push(18);
        s.push(14);
        s.push(-3);
        
        Stack<Integer> st=sort(s);
        System.out.println(st.peek());
        System.out.println(st);
        
        

	}

}
