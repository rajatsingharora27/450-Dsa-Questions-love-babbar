package heap;
import java.util.*;
public class QUE_344 {






	public static String rearrange(String str) {

		HashMap<Character,Integer> map= new HashMap<>();

		//Making the hash map to get the frequency
		for(int i=0;i<str.length();i++) {

			if(map.containsKey(str.charAt(i))) {
				map.put(str.charAt(i), map.get(str.charAt(i))+1);
			}
			else {
				map.put(str.charAt(i),1);
			}



		}
		PriorityQueue<HashNode> heap=new PriorityQueue<>(map.size() , new NodeComparator());

		System.out.println(map);



		// Converting each occurrence to heap

		Set<Character> keys=map.keySet();
		for(Character c : keys) {
			HashNode node= new HashNode(c,map.get(c));
			heap.add(node);
		}


		// Rearranging
		String s="";
		HashNode prev=new HashNode('#',-1);
		while(!heap.isEmpty())
		{
			HashNode k=heap.peek();

			if(k.freq > Math.ceil(str.length()/2) ) {
				return "";
			}
		
		heap.poll();
		s+=k.c;

		if(prev.freq>0) {
			heap.add(prev);
		}

		k.freq--;
		prev=k;

	}
	return s;

}




public static void main(String[] args) {
	// TODO Auto-generated method stub
	System.out.println(rearrange("aabc"));

}

}
