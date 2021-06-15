package searchingAndSorting;
import java.util.*;
public class QUE_102 {
	  ArrayList<Integer> valueEqualToIndex(int arr[], int n) {
	        // code here
	        ArrayList<Integer> a=new ArrayList<>();
	        for(int i=0;i<arr.length;i++){
	            if(arr[i]==i+1){
	                a.add(arr[i]);
	            }
	        }
	        return a;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
