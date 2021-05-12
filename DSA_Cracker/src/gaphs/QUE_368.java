package gaphs;

import java.util.*;
public class QUE_368 {

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

	public static int[] topologicaladj(int v, ArrayList<ArrayList<Integer>> adj) {

		Stack<Integer> stack= new Stack<>();
		boolean vistied[] = new boolean[v];

		for(int i=v-1;i>=0;i--) {
			if(!vistied[i]) {
				topologicalUtiladj(v,adj,vistied,stack,i);
			}
		}

		int ans[]=new int[v];
		int i=0;
		while(!stack.isEmpty()) {
			ans[i]=stack.pop();
			i++;
		}

		return ans;
	}
	
	private static void topologicalUtiladj(int v, ArrayList<ArrayList<Integer>> adj, boolean[] visited,Stack<Integer> stack,int si) {

		visited[si]=true;
		
		for(int i=0;i<adj.get(si).size();i++) {
			//System.out.println(adj.get(si).get(i));
			if(!visited[adj.get(si).get(i)])
				topologicalUtiladj(v, adj, visited, stack, adj.get(si).get(i));
		}
		stack.push(si);
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
			//graph[v2][v1]=1;
			
		}
		
		return graph;	
	}
	
	public static int[] topological(int v,int [][] adj) {

		Stack<Integer> stack= new Stack<>();
		boolean vistied[] = new boolean[v];

		for(int i=0;i<v;i++) {
			if(!vistied[i]) {
				topologicalUtil(v,adj,vistied,stack,i);
			}
		}

		int ans[]=new int[v];
		int i=0;
		while(!stack.isEmpty()) {
			ans[i]=stack.pop();
			i++;
		}

		return ans;
	}

	private static void topologicalUtil(int v, int [][]adj, boolean[] visited,
			Stack<Integer> stack,int si) {

		visited[si]=true;

		for(int i=0;i<v;i++) {
			if(adj[si][i]==1 && !visited[i])
				topologicalUtil(v, adj, visited, stack, i);
		}
		stack.push(si);
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ArrayList<ArrayList<Integer>> graph= buildAdjGraph();
		//int graph[][]=buildGraph();
		//int array[]=topological(graph.length,graph);
		
//		System.out.println(graph.length);
//		for(int i=0;i<array.length;i++) {
//			System.out.print(array[i]+" ");
//		}
		
		ArrayList<ArrayList<Integer>> adj=buildAdjGraph();
		int ans[]=topologicaladj(adj.size(),adj);
		
		System.out.println(ans.length);
		for(int i=0;i<ans.length;i++) {
			System.out.print(ans[i]+" ");
		}
		
		

	}

}
