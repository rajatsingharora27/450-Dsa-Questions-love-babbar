package stack;
import java.util.*;

public class QUE_306 {

	public static String infix2Postfix(String str) {

		Stack<Character> s=new Stack<>();
		String string="";

		for(int i=0;i<str.length();i++) {

			if(str.charAt(i)!='^' && str.charAt(i)!='*'&& str.charAt(i)!='+' && str.charAt(i)!='-' ) {
				string=string+str.charAt(i);
				//System.out.println(string);
			}
			else {
				if(s.size()==0) {
					s.push(str.charAt(i));
				}
				else{
					if(checkPriority(s.peek(),str.charAt(i))){
						//if true means we can add on stack directly
						s.push(str.charAt(i));
					}	
					else {
						string=string+s.pop();
						s.push(str.charAt(i));
					}
				}
			}		
		}	

		while(!s.isEmpty()) {
			string=string+s.pop();
		}
		System.out.println(string);
		return string;


	}

	private static boolean checkPriority(char a, char b) {

		//heighest
		if(a=='^') {
			return false;
		}

		else if((a=='*'|| a=='/') && b=='^') {
			return false;
		}
		else if((a=='*' || a=='/') && (b=='+' || b=='-')) {
			return true;
		}
		else {
			return false;
		}	
	}

	public static void evaluateExpressionOfPostfix(String postfix) {

		Stack <Integer> s=new Stack<>();

		for(int i=0;i<postfix.length();i++) {

			char c=postfix.charAt(i);
			if(c==' ') {
				continue;
			}
			else if(Character.isDigit(c)) {

				int n=0;
				while(Character.isDigit(c)) {
					n=n*10+(int)c-'0';
					i++;
					c=postfix.charAt(i);
				}
				i--;

				s.push(n);	
			}
			else {

				//switch case
				int a=s.pop();
				int b=s.pop();

				switch(postfix.charAt(i)) {

				case  '+':{
					s.push(a+b);
					break;
				}

				case  '*':{
					s.push(a*b);
					break;
				}

				case  '/':{
					s.push(b/a);
					break;
				}

				case  '-':{
					s.push(b-a);
					break;
				}

				case  '^':{
					s.push(b^a);
					break;
				}

				}

			}

		}
		System.out.println(s.pop());





	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String s="2+4*4+6";
		evaluateExpressionOfPostfix( "");

	}

}
