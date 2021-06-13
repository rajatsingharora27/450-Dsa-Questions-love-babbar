package gaphs;
import java.util.*;
public class QUE_386 {
	
	public static int JourneyToMoon(List<List<Integer>> astronaut,int n) {
		
		int parent[]=new int [n];
		
		for(int i=0;i<n ;i++) {
			parent[i]=i;
		}
		
		for(int i=0;i<astronaut.size();i++) {
			int sourceParent=findParent(parent,astronaut.get(i).get(0));
			int destiParent=findParent(parent,astronaut.get(i).get(1));
			parent[destiParent]= sourceParent  ;
		}
		
		
		for(int i=0;i<parent.length;i++) {
			System.out.print(parent[i]+" ");
		}
		
		HashMap<Integer,Integer> map=new HashMap<>();
		
		for(int i=0;i<parent.length;i++) {
			int ele=parent[i];
			if(!map.containsKey(ele)) {
				map.put(ele, 1);
			}
			else {
				map.put(ele, map.get(ele)+1);
			}
		}
		
		int size[]=new int[map.size()];
		int prefix[]=new int [map.size()];
		int i=0;
		Set<Integer> keys=map.keySet();
		
		for(Integer ele:keys) {
			size[i]=map.get(ele);
			i++;
		}
		
		for(int j=prefix.length-1;j>=0;j--) {
			
			if(j!=prefix.length-1) {
			prefix[j]=size[j+1]+size[j];
			//System.out.println(prefix[j]);
			
			}
			prefix[j]=size[j];
		}
		
		int ans=0;
		for(int l=0;l<size.length-2;l++) {
			ans+=size[l]*prefix[l+1];
		}
		
		System.out.println();
		for(int l=0;l<size.length;l++) {
			System.out.print(size[l]+" ");
		}
		
		System.out.println();
		for(int l=0;l<prefix.length;l++) {
			System.out.print(prefix[l]+" ");
		}
		
		
		
		
		
		System.out.println();
		return ans;
		
		
		
		
		
		
		
		
	}
	

	private static int findParent(int[] parent, int i) {
		
		if(parent[i]==i) {
			return i;
		}
		return findParent(parent, parent[i]);
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		List<List<Integer>> astronaut=new ArrayList<>();
		System.out.println("Enter total  number of astronaut");
		int nums=sc.nextInt();
		
		System.out.println("Enter number of pairs");
		int pair=sc.nextInt();
		
		for(int i=0;i<pair;i++) {
			System.out.println("Enter first and second element");
			int first=sc.nextInt();
			int second=sc.nextInt();
			
			List<Integer> p=new ArrayList<>();
			
			p.add(first);
			p.add(second);
			
			astronaut.add(p);
			
			
		}
		
	System.out.println(JourneyToMoon(astronaut,nums));
		
		
		
		
		
		
		

	}

}
