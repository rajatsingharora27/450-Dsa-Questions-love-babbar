package gaphs;
import java.util.*;
public class ReconstructItinerary {


	public static void  reconstructItinerary(List<List<String>> tickests) {

		HashMap<String,PriorityQueue<String>> map=new HashMap<>();

		for(int i=0;i<tickests.size();i++) {
			List<String>  first=  tickests.get(i);
			String source=first.get(0);
			String destination=first.get(1);

			if(!map.containsKey(source)) {
				PriorityQueue<String> heap=new PriorityQueue<>();
				heap.add(destination);
				map.put(source,heap);
			}
			else {
				PriorityQueue<String> h=map.get(source);
				h.add(destination);
				map.put(source,h);
			}		
		}

		//
		if(!map.containsKey("JFK")) return;

		else {
			PriorityQueue<String> pq=map.get("JFK");
			Stack<String> s=new Stack<>();
			dfs("JFK",pq,map,s);
//			while(!s.isEmpty()) {
//				System.out.print(s.pop()+" ");
//			}

		}
	}






	private static void dfs(String origin,PriorityQueue<String> src, HashMap<String, PriorityQueue<String>> map, Stack<String> s) {

		if(src==null) {
			return;
		}
		
		int n=src.size();
		s.push(origin);
		System.out.print(origin+" ");
		for(int i=0;i<n;i++) {
			
			
			PriorityQueue<String> heap= map.get(origin);
			origin=heap.peek();
			s.push(origin);
			String front=heap.poll();
			
			
			
			dfs(origin,map.get(front),map,s);
		}
		return;
		
		
	}






	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		List<List<String>> tickets=new ArrayList<>();

		for(int i=0;i<5;i++) {

			List<String> l=new ArrayList<>();
			System.out.println("Enter source and destinations");
			String f=sc.next();
			String s=sc.next();

			l.add(f);
			l.add(s);

			tickets.add(l);	
		}

		reconstructItinerary(tickets);

	}

}
