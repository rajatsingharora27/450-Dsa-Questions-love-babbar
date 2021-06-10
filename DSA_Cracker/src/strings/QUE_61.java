package strings;

public class QUE_61 {

	
	public static boolean validShuffle(String s1,String s2,String res) {
		
		
		int s1len=s1.length();
		int s2len=s2.length();
		if(res.length()!=s1len+s2len) {
			return false;
		}
		
		else {
		
			int k=0,i=0,j=0;
		
			while(k<res.length()) {
				
				if(i<s1.length() && s1.charAt(i)==res.charAt(k)) {
					i++;
					k++;
				}
				else if(j<s2.length() && s2.charAt(j)==res.charAt(k))
				{
					j++;
					k++;
				}
				else {
					return false;
					
				}	
			}
			
			return true;
		
			
		}
		
		
		
		
		
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s1="xy";
		String s2="12";
		String res="x12y";
		System.out.println(validShuffle(s1, s2, res));
		
		
	}

}
