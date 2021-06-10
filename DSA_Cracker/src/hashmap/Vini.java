package hashmap;

import java.util.*;

public class Vini {

	public static int diff(List<Integer> arr) {

		int indicator1=indi1(arr);
		int indicator2=indi2(arr);
		System.out.println(indicator1);
		System.out.println(indicator2);
		return indicator1-indicator2;


	}

	private static int indi2(List<Integer> arr) {
		Stack<Integer> s=new Stack<>();
		List<Integer> nums=new ArrayList<>();
		List<Integer> freq=new ArrayList<>();

		for(int i=0;i<arr.size();i++) {

			if(i+1==arr.get(i) ||  (!s.isEmpty() &&  s.peek()==arr.get(i))) {
				s.push(arr.get(i));
				
			}
			if(s.isEmpty()) {
				continue;
			}
			
			int p=s.peek();
			

			if(i+1<arr.size() && arr.get(i+1)!=p && !s.isEmpty()) {

				int count=0;
				while(!s.isEmpty()) {
					count++;
					s.pop();
				}

				nums.add(p);
				freq.add(count);
			}

		}
		int c=0;
		HashMap<Integer,Integer>map=new HashMap<>();
		
		if(s.isEmpty()) {
			for(int i=0;i<nums.size();i++) {

				if(nums.get(i)==freq.get(i)) {
					if(!map.containsKey(nums.get(i))) {
						map.put(nums.get(i),freq.get(i));
					}
				}
			}
			return map.size();
			
		}
		int p=s.peek();
		
		while(!s.isEmpty()) {
			c++;
			s.pop();	
		}
		nums.add(p);
		freq.add(c);
		
		

		
		for(int i=0;i<nums.size();i++) {

			if(nums.get(i)==freq.get(i)) {
				if(!map.containsKey(nums.get(i))) {
					map.put(nums.get(i),freq.get(i));
				}
			}


		}
		return map.size();




	}

 

private static int indi1(List<Integer> arr) {

	Stack<Integer> s=new Stack<>();
	List<Integer> nums=new ArrayList<>();
	List<Integer> freq=new ArrayList<>();

	for(int i=0;i<arr.size();i++) {

		s.push(arr.get(i));
		int p=s.peek();

		if(i+1<arr.size() && arr.get(i+1)!=p ) {

			int count=0;
			while(!s.isEmpty()) {
				count++;
				s.pop();
			}

			nums.add(p);
			freq.add(count);
		}

	}
	int c=0;
	int p=s.peek();
	while(!s.isEmpty()) {
		c++;
		s.pop();	
	}
	nums.add(p);
	freq.add(c);

	HashMap<Integer,Integer>map=new HashMap<>();
	for(int i=0;i<nums.size();i++) {

		if(nums.get(i)==freq.get(i)) {
			if(!map.containsKey(nums.get(i))) {
				map.put(nums.get(i),freq.get(i));
			}
		}


	}
	return map.size();


}






public static void main(String[] args) {
	// TODO Auto-generated method stub
	List<Integer>arr=new ArrayList<>();
	arr.add(1);
	arr.add(2);
	arr.add(2);
	arr.add(4);
	arr.add(4);
	arr.add(4);
	arr.add(4);
	arr.add(5);
	arr.add(5);
	arr.add(5);
	arr.add(5);
	arr.add(5);
	arr.add(8);
	//arr.add(4);
	//arr.add(4);
	//arr.add(2 );
	System.out.println(diff(arr));

}

}
