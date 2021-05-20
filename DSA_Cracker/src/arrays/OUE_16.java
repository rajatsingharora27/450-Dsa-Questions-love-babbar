package arrays;

import java.util.HashMap;
import java.util.Map.Entry;

public class OUE_16 {

	//By taking extra space that is hashmap

	public static int findDuplicate(int arr[]) {

		HashMap<Integer, Integer>map=new HashMap<>();

		for(int i=0;i<arr.length;i++) {

			if(!map.containsKey(arr[i])) {
				map.put(arr[i], 1);
			}
			else {
				map.put(arr[i], map.get(arr[i])+1);
			}
		}		

		for(HashMap.Entry<Integer, Integer> ele : map.entrySet()) {
			if(ele.getValue()==2) {
				return ele.getKey();
			}
			
		}

	return -1;
}






public static void main(String[] args) {
	// TODO Auto-generated method stub
	int arr[]= {1,3,4,2,2};
	System.out.println(arr);


}

}
