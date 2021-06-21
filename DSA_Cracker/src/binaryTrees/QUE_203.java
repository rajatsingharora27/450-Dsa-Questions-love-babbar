package binaryTrees;
import java.util.*;
public class QUE_203 {

	
	public static boolean isTree(ArrayList<ArrayList<Integer>> graph) {
		
		// check if there is a cycle present in the graph
		
		boolean cycle=unionFind(graph);
		if(cycle) {
			return false;
		}
		
		// checking if all there is single component of  graph
		
		boolean single=component(graph);
		if(single) {
			return true;
		}
		return false;
	}
	
	

	
	private static boolean component(ArrayList<ArrayList<Integer>> graph) {
		
		boolean visited[]=new boolean[graph.size()];
		int component=0;
		for(int i=0;i<graph.size();i++) {
			
			if(!visited[i]) {
				component++;
				dfs(visited,graph,i);
				if(component>1) {
					return false;
				}	
			}
		}
		return true;
	}




	private static void dfs(boolean[] visited, ArrayList<ArrayList<Integer>> graph,int si) {
		
		
		visited[si]=true;
		for(int i=0;i<graph.get(si).size();i++) {
			if(!visited[graph.get(si).get(i)])
			dfs(visited,graph,graph.get(si).get(i));
		}	
	}




	private static boolean unionFind(ArrayList<ArrayList<Integer>> graph) {
		
		int parent[]=new int[graph.size()];
		for(int i=0;i<parent.length;i++) {
			parent[i]=i;
		}
		
		for(int i=0;i<graph.size();i++) {
			for(int j=0;j<graph.get(i).size();j++) {
				int v1=i;
				int v2=graph.get(i).get(j);
				boolean ans=cycle(parent,v1,v2);
				if(ans==true) {
					return true;
				}
			}
		}
		return false;	
		
	}

	
	private static boolean cycle(int[] parent, int v1, int v2) {

		int source=findParent(parent,v1);
		int destination = findParent(parent,v2);
		if(source==destination) {
			return true;
		}
		else {
			parent[destination]=source;
		}
		return false;
		
		
	}


	private static int findParent(int[] parent, int si) {
		
		if(parent[si]!=si) {
			findParent(parent, parent[si]);
		}
		return si;	
	}




	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
