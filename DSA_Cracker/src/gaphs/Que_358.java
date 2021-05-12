package gaphs;

import java.util.Scanner;

public class Que_358 {
	
	public static int[][] buildGraph(){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of vertex");
		int v = sc.nextInt();
		
		System.out.println("Enter the number of edge");
		int e = sc.nextInt();
		
		int graph[][] =new int[v][v];
		
		for ( int i =0;i<e;i++) {
			System.out.print("Enter the edge v1 and v2: ");
			int v1=sc.nextInt();
			int v2=sc.nextInt();
			
			graph[v1][v2]=1;
			graph[v2][v1]=1;
			
		}
		
		return graph;
		
		
	}
	
	public static void dfs(int graph[][]) {
		boolean flag[]= new boolean [graph.length];
//		for (int i =0;i<graph.length;i++) {}
		dfshelper(graph,flag,1);
	}
	
	

	private static void dfshelper(int[][] graph, boolean[] flag, int si) {
		// TODO Auto-generated method stub
		flag[si]=true;
		for(int i=0 ; i<graph.length ; i++) {
			if(graph[si][i]==1 && !flag[i]) {
				dfshelper(graph, flag, i);
			}
		}
		System.out.print(si+" ");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int graph[][]=buildGraph();
		dfs(graph);
		

	}

}
