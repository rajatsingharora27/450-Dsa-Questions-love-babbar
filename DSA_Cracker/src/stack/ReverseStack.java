package stack;

import java.util.Stack;

public class ReverseStack {
	
	public static String reverseString(String s) {
		
		 Stack <Character> st=new Stack<>();
	        int i=0;
	        while(i<s.length()){
	            st.push(s.charAt(i));
	            i++;
	        }
	        String str="";
	        while(!st.isEmpty()){
	            str+=st.pop();
	        }
	        
	        return str;
	        
	    }
		
		
		
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverseString("Rajat"));

	}

}
