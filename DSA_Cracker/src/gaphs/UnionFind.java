package gaphs;
import java.util.*;

class Edge implements Comparable<Edge>  {

	int source;
	int destination;
	int weight;

	@Override
	public int compareTo(Edge o) {
		
		return this.weight-o.weight;

	}
}


public class UnionFind {
	

	public static void unionFind() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Number Edges and Number of Vertix");
		int e=sc.nextInt();
		int v=sc.nextInt();
		Edge input[]=new Edge[e];
		for(int i=0;i<e;i++) {
			System.out.println("Enter v1 , v2 and weight");
			int v1=sc.nextInt();
			int v2=sc.nextInt();
			int w=sc.nextInt();

			Edge edge=new Edge();
			edge.source=v1;
			edge.destination=v2;
			edge.weight=w;

			input[i]=edge;

		}
		Arrays.sort(input);

		// to detect cycle

		int Parent[] =new int[v];
		for(int i=0;i<v;i++) {
			Parent[i]=i;
		}

		for(int i=0;i<e;i++) {
			int parentSource=findParent(Parent,input[i].source);
			int parentDestination=findParent(Parent,input[i].destination);

			if(parentSource==parentDestination) {
				System.out.println("Cycle");
				return;
			}
			Parent[parentSource]=parentDestination;
		}
		System.out.println("No Cycle");
		return;
	}

	private static int findParent(int[] parent, int i) {
		
		if(parent[i]==i) {
			return i;
		}
		return findParent(parent,parent[i]);
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		unionFind();

	}

}
