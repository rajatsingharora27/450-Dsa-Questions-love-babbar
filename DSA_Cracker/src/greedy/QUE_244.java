package greedy;

public class QUE_244 {

	
	public static String SwapSmall(String str) {
		
		
		// get first two minimums
		int first=Integer.MAX_VALUE;
		int second=Integer.MAX_VALUE;
		for(int i=0;i<str.length();i++) {
			
			if(str.charAt(i)-0<first) {
				second=first;
				first=str.charAt(i);
			}
			else if(str.charAt(i)-0<second && str.charAt(i)-0!=first){
				second=str.charAt(i);
			}
		}
		char f=(char) first;
		char s=(char) second;
		
		for(int i=0;i<str.length();i++) {
			
			if(str.charAt(i)==f) {
				
			}
			
			
			
		}
		
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwapSmall("ccad");

	}

}
