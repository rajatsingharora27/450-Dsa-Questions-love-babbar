package gaphs;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
public class QUE_357 {

	

	
	
	
	//Using arraylist i.e adjacent list
	public static ArrayList<ArrayList<Integer>> buildAdjGraph(){
		Scanner sc=new Scanner(System.in);
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		System.out.println("Enter number of Vertex");
		int v=sc.nextInt();
		for(int i=0;i<v;i++) {
			adj.add(new ArrayList<Integer>());
		}
		
		System.out.println("Enter total edges");
		int e=sc.nextInt();
		int count=0;
		while(count<e) {
			
			System.out.print("Enter the edge between vertex v1 and v2: ");
			int vertex1=sc.nextInt();
			int vertex2=sc.nextInt();
			
			adj.get(vertex1).add(vertex2);
			adj.get(vertex2).add(vertex1);
			
			count++;
		}
		
		return adj;
			
	}
	
	
	public static void adjbfs(ArrayList<ArrayList<Integer>> adj) {
		
		boolean [] flag = new boolean [adj.size()];
		
		for( int i=0; i < adj.size() ; i++) {
			
			if(!flag[i]) {
				adjBfshelper(adj , i , flag);
			}	
		}	
	}
	
	
	private static void adjBfshelper(ArrayList<ArrayList<Integer>> adj, int si, boolean[] flag) {
		
		Queue<Integer> q = new LinkedList<>();
		q.add(si);
		flag[si]=true;
		
		while(!q.isEmpty()) {
			
			int fv = q.poll();
			System.out.print(fv+" ");
			
			for(int i = 0 ;i<adj.get(fv).size(); i++ ) {
				
				if(flag[adj.get(fv).get(i)]==false) {
					q.add(adj.get(fv).get(i));
					flag[adj.get(fv).get(i)]=true;
				}
				
			}
		}		
	}


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
	
	public static void bfs(int graph[][]) {
		
		boolean flag[]=new boolean[graph.length];
		for (int i=0;i<graph.length;i++) {
			if(!flag[i]) {
				bfshelper(graph,i,flag);
			}
		}	
	}
	
	public static void bfshelper(int graph[][] , int si , boolean[] flag) {
		
		Queue<Integer> q = new LinkedList<>();
		q.add(si);
		flag[si]=true;
		while(!q.isEmpty()) {
			
			int fv=q.poll();
			System.out.print(fv+" ");
			
			for (int i=0 ;i < graph.length;i++) {
				
				if(graph[fv][i]==1 && flag[i]==false) {
					q.add(i);
					flag[i]=true;
				}
				
				
			}
			
		}
		
		
		
		
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int graph[][]=buildGraph();
		//bfs(graph);
		
		ArrayList<ArrayList<Integer>> adjGraph= buildAdjGraph();
		adjbfs(adjGraph);
		
		

	}

}
