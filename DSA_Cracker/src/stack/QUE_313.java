package stack;
import java.util.*;
public class QUE_313 {

	public static int validLongestLength(String str) {

		Stack<Character> s=new Stack<>();
		int length=0;
		for(int i=0;i<str.length();i++) {
			int count=0;
			if(str.charAt(i)=='(') {
				s.push(str.charAt(i));
			}
			else {	
				while(str.charAt(i)==')' && !s.isEmpty()) {
					if(s.peek()=='(') {
						s.pop();
						count++;
						i++;
					}
					i--;
				}
				
				length+=2*count;

			}
		}

	
	return length;	

}





public static void main(String[] args) {
	// TODO Auto-generated method stub
	String str=")(";
	System.out.println(validLongestLength(str));

}

}
