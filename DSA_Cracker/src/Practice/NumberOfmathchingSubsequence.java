package Practice;

import java.util.HashSet;
import java.util.Set;

public class NumberOfmathchingSubsequence {

	
	
	public static void substring(String str) {
		HashSet<String> map=new HashSet<>();
		sub(str,"",0,map);	
		System.out.println(map);
		
	}
	
	
	
	
	private static void sub(String str,String ans,int si,HashSet<String> map) {
		
		if(str.length()==si) {
			map.add(ans);
			return;
		}
		
		sub(str,ans+str.charAt(si),si+1,map);
		sub(str,ans,si+1,map);
		
	}




	public static void main(String[] args) {
		substring("aabc");
		
	}
	
}
