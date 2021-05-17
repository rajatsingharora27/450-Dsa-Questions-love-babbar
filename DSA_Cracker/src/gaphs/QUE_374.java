package gaphs;

import java.util.Scanner;

public class QUE_374 {
	
	public static void Prims(int graph[][]) {
		
		int n=graph.length;
		int parent[]=new int[n];
		boolean visited[]=new boolean [n];
		int distance[]=new int[n];
		
		
		parent[0]=-1;
		for(int i=1;i<n;i++) {
			distance[i]=Integer.MAX_VALUE;
			parent[i]=-1;
		}
		
		for(int i=0;i<n;i++) {
			
			int minVertex=findminVertex(visited,distance);
			visited[i]=true;
			
			
			for(int j=0;j<n;j++) {
				if(graph[minVertex][j]!=0 && !visited[j]) {
					if(graph[minVertex][j]<distance[j]) {
						distance[j]=graph[minVertex][j];
						parent[j]=minVertex;
					}
				}
			}		
		}
		
		for(int i=1;i<n;i++) {
			if(i>parent[i]){
				System.out.println(parent[i]+" "+ i+" "+distance[i]);    
			}
			else{
				System.out.println(i+" "+ parent[i]+" "+distance[i]);

			}
		}	
	}
	
	
	

	private static int findminVertex(boolean[] visited, int[] weight) {
		int minVertex=-1;
		for(int i=0;i<weight.length;i++) {
			if(!visited[i] && (minVertex==-1 || weight[i]<weight[minVertex] )) {
				minVertex=i;
			}
		}
		return minVertex;
	}




	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);		
		int v=sc.nextInt();
		int e=sc.nextInt();

		int graph[][]=new int [v][v];
		//		for(int i=0;i<v;i++) {
		//			for(int j=0;j<v;j++) {
		//				graph[i][j]=Integer.MAX_VALUE;
		//			}
		//		}



		for(int i=0;i<e;i++) {
			//System.out.println((i+1)+"Enter vertex points");
			int fv=sc.nextInt();
			int sv=sc.nextInt();
			//System.out.println((i+1)+"Enter the weight of");
			int w=sc.nextInt();
			graph[fv][sv]=w;
			graph[sv][fv]=w;
		}

		Prims(graph);
	}

}
