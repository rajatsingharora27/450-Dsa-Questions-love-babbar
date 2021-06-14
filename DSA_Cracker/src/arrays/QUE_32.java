package arrays;
import java.util.*;
public class QUE_32 {

	public String isSubset( long a1[], long a2[], long n, long m) {

		Set<Long> map=new HashSet<>();
		for(int i=0;i<a1.length;i++){
			if(!map.contains(a1[i])){
				map.add(a1[i]);
			}
		}

		for(int i=0;i<a2.length;i++){
			if(!map.contains(a2[i])){
				return "No";
			}
		}
		return "Yes";
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
