package gaphs;
import java.util.*;
public class CourseScheduling {

	public static boolean canFinish(int numCourses, int[][] prerequisites) {

		ArrayList<ArrayList<Integer>> array= new ArrayList<>();
		for(int i=0;i<numCourses;i++) {
			array.add(new ArrayList<>());
		}

		for(int i=0;i<prerequisites.length;i++) {
			int first=prerequisites[i][0];
			int second=prerequisites[i][1];
			array.get(second).add(first);		
		}



		// detecting cycle 

		
		boolean visited[]=new boolean[numCourses];
		
		for(int i=0;i<visited.length;i++) {

			if(!visited[i]) {
				boolean ans=dfs(visited,array,i);
				if(ans==true) {
					return false;
				}
			}	 
		}

		return true;

	}





	private static boolean dfs(boolean[] visited, ArrayList<ArrayList<Integer>> graph, int si) {

		visited[si]=true;

		for(int i=0;i<graph.get(si).size();i++) {
			if(graph.get(si)!=null) {
				if(!visited[graph.get(si).get(i)]) {
					dfs(visited,graph,graph.get(si).get(i));
				}
				if(visited[graph.get(si).get(i)]) {
					return true;
				}
			}
		}
		visited[si]=false;
		return false;
	}






	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int pre[][]= {{0,1}};
		System.out.println(canFinish(2, pre));

	}

}
