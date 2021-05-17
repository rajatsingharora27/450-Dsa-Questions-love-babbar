package gaphs;

import java.util.Arrays;
import java.util.Scanner;

//class Edge implements Comparable<Edge>  {
//
//	int source;
//	int dest;
//	int weight;
//
//	@Override
//	public int compareTo(Edge o) {
//		
//		return this.weight-o.weight;
//
//	}
//}

public class QUE_373 {

	private static void kruskals(Edge[] input, int n) {
		Edge[] output = new Edge[n-1];
		int[] parent = new int[n];
		for(int i=0;i<parent.length;i++) {
			parent[i] = i;
		}
		int count =0;
		int i=0;
		while(count<n-1) {
			
			int parentSource = findParent(parent,input[i].source);
			int parentDest = findParent(parent,input[i].destination);
			
			if(parentDest == parentSource) {
				i++;
				continue;
			}
			output[count] = input[i];
			parent[parentSource] = parentDest;
			count++;
			i++;
		}
		
		for(Edge edge : output) {
			if(edge.source < edge.destination)
			System.out.println( edge.source +" "+ edge.destination+" "+ edge.weight);
			else {
				System.out.println(edge.destination+" "+ edge.source+" " + edge.weight);
			}	
		}
		
	}
	public static int findParent(int[] parent, int i) {
		if(parent[i] == i) {
			return i;
		}
		return findParent(parent, parent[i] );
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		kruskals(input,v);

	}
}
