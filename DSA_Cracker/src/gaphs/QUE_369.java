package gaphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class QUE_369 {
	
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

	public static int[] printOrder(ArrayList<ArrayList<Integer>> adj) {
		
		int indrgree[]=new int [adj.size()];
		//Getting all the in degree of the vertex
		for(int i=0;i<adj.size();i++) {
			for(int j=0;j<adj.get(i).size();j++) {
				int index=adj.get(i).get(j);
				indrgree[index]++;
			}
		}
		
		//getting the vertex with indegree 0
		int jobs[]=new int[adj.size()];
		Queue<Integer> q= new LinkedList<>();
		
		for(int i=0;i<indrgree.length;i++) {
			if(indrgree[i]==0) {
				jobs[i]=1;
				q.add(i);
			}
		}
		
		// Removing from the queue
		while(!q.isEmpty()) {
			
			int cur= q.poll();
			// go to graph make in degree -1 who's parent is removed
			for(int i=0;i<adj.get(cur).size();i++) {
				indrgree[adj.get(cur).get(i)]--;
				
				if(indrgree[adj.get(cur).get(i)]==0) {
					q.add(indrgree[adj.get(cur).get(i)]);
					jobs[indrgree[adj.get(cur).get(i)]]=jobs[cur]+1;
				}
			}
		}
		
		for( int i=0;i<indrgree.length;i++) {
			System.out.print(indrgree[i]+" ");
		}
		
		System.out.println();
		return jobs;
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> adj=buildAdjGraph();
		
		int array[]=printOrder(adj);
		
		for( int i=0;i<array.length;i++) {
			System.out.print(array[i]+" ");
		}

	}

}
