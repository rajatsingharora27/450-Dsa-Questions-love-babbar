package gaphs;

import java.util.ArrayList;
import java.util.Scanner;

public class QUE_359 {

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
			//graph[v2][v1]=1;

		}

		return graph;


	}

	public static boolean isCycleDFS(int graph[][]) {

		boolean flag[] = new boolean[graph.length];

		for (int i=0;i<graph.length;i++) {
			boolean ans=isCycleDFS(graph , flag , i);
			if(ans==true) {
				return true;
			}
		}
		return false;


	}

	private static boolean isCycleDFS(int[][] graph, boolean[] flag, int si) {
		flag[si]=true;

		for (int i=0;i<graph.length;i++) {
			if(graph[si][i]==1 && !flag[i]) {
				isCycleDFS(graph,flag,i);
			}
			if(graph[si][i]==1 && flag[i]==true) {
				return true;
			}
		}
		flag[si]=false;
		return false;
	}

	// Using adjancey List
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
			//adj.get(vertex2).add(vertex1);

			count++;
		}

		return adj;

	}

	public static boolean isCycleAdj(ArrayList<ArrayList<Integer>> graph) {

		boolean flag[] = new boolean[graph.size()];

		for(int i=0 ; i<graph.size() ; i++) {

			boolean ans=isCycleAdj(graph,flag,i);
			if(ans==true) {
				return true;
			}
		}

		return false;
	}


	private static boolean isCycleAdj(ArrayList<ArrayList<Integer>> graph, boolean[] flag, int si) {
		// TODO Auto-generated method stub

		flag[si]=true;

		for(int i=0; i<graph.get(si).size();i++) {
			if(graph.get(si)!=null) {
				if(!flag[graph.get(si).get(i)]) {
					isCycleAdj(graph, flag, i);
				}
				if(flag[graph.get(si).get(i)]) {
					return true;
				}
			}
		}
		flag[si]=false;
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int graph[][]=buildGraph();
		//System.out.println( isCycleDFS(graph));

		ArrayList<ArrayList<Integer>> graph= buildAdjGraph();
		System.out.println(isCycleAdj(graph));

	}

}
