package gaphs;

import java.util.Scanner;

public class QUE_367 {

	public static int[][] buildGraph(){
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the number of vertex");
		int v = sc.nextInt();

		System.out.println("Enter the number of edge");
		int e = sc.nextInt();

		
		
		int graph[][] =new int[v][v];

		for ( int i =0;i<e;i++) {
			System.out.print("Enter the edge v1 and v2  and weight: ");
			int v1=sc.nextInt();
			int v2=sc.nextInt();
			int weight=sc.nextInt();
			
			graph[v1][v2]=weight;
			graph[v2][v1]=weight;

		}

		return graph;


	}

	private static void dijkstra(int[][] adjacencyMatrix) {
		int v = adjacencyMatrix.length;
		boolean visited[] = new boolean[v];
		int distance[] = new int[v];
		distance[0] = 0;
		for(int i = 1; i < v; i++){
			distance[i] = Integer.MAX_VALUE;
		}

		for(int i = 0; i < v - 1; i++){
			// Find Vertex with Min distance
			int minVertex = findMinVertex(distance, visited);
			visited[minVertex] = true;
			// Explore neighbors
			for(int j = 0; j < v; j++){
				if(adjacencyMatrix[minVertex][j] != 0 && !visited[j] && distance[minVertex] != Integer.MAX_VALUE){
					int newDist = distance[minVertex] + adjacencyMatrix[minVertex][j];
					if(newDist < distance[j]){
						distance[j] = newDist;
					}
				}
			}
		}

		// Print
		for(int i = 0; i < v; i++){
			System.out.println(i + " "+ distance[i]);
		}

	}

	private static int findMinVertex(int[] distance, boolean visited[]) {

		int minVertex = -1;
		for(int i = 0; i < distance.length; i++){
			if(!visited[i]  && (minVertex == -1 || distance[i] < distance[minVertex])){
				minVertex = i;
			}
		}
		return minVertex;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int graph[][]=buildGraph();
		
		dijkstra(graph);
		
		
		
	}

}
