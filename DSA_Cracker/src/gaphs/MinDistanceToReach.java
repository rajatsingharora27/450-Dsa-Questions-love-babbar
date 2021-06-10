package gaphs;
import java.util.*;

public class MinDistanceToReach {

	public static int minDistance(int mat[][]) {

		int row[]= {-1,0,1,0};
		int col[] ={0,-1,0,1};



		boolean visited[][]=new boolean[mat.length][mat[0].length];
		point firstCell=new point(0,0);
		queueNode firstNode=new queueNode(firstCell,0);

		Queue<queueNode> q=new LinkedList<>();
		q.add(firstNode);
		visited[firstCell.x][firstCell.y]=true;

		while(!q.isEmpty()) {

			queueNode front=q.poll();

			//			if(mat[front.p.x][front.p.y]==9) {
			//				return front.distance+1;
			//			}

			for(int i=0;i<row.length;i++) {
				int r=row[i]+front.p.x;
				int c=col[i]+front.p.y;

				if(isValid(r,c,visited,mat)) {
					if(mat[r][c]==9) {
						return front.distance+1;

					}


					visited[r][c]=true;
					point pt=new point(r, c);
					queueNode child=new queueNode(pt, front.distance+1);
					q.add(child);
				}	
			}	
		}
		return -1;	
	}

	private static boolean isValid(int r, int c, boolean[][] visited, int[][] mat) {

		if(r<0 || r>=mat.length|| c<0 || c>=mat[0].length||mat[r][c]==0|| visited[r][c]==true) {
			return false;
		}
		return true;	
	}

	//with List

	public static int mindistanceList(List<List<Integer>> mat) {

		int row[]= {-1,0,1,0};
		int col[] ={0,-1,0,1};

		boolean visited[][]=new boolean[mat.size()][mat.get(0).size()];
		point firstCell=new point(0,0);
		queueNode firstNode=new queueNode(firstCell,0);

		Queue<queueNode> q=new LinkedList<>();
		q.add(firstNode);
		visited[firstCell.x][firstCell.y]=true;

		while(!q.isEmpty()) {

			queueNode front=q.poll();



			for(int i=0;i<row.length;i++) {
				int r=row[i]+front.p.x;
				int c=col[i]+front.p.y;

				if(isValidList(r,c,visited,mat)) {
					if(mat.get(r).get(c)==9) {
						return front.distance+1;

					}


					visited[r][c]=true;
					point pt=new point(r, c);
					queueNode child=new queueNode(pt, front.distance+1);
					q.add(child);
				}	
			}	
		}
		return -1;

	}


	private static boolean isValidList(int r, int c, boolean[][] visited, List<List<Integer>> mat) {
		if(r<0 || r>=mat.size()|| c<0 || c>=mat.get(r).size()||mat.get(r).get(c)==0|| visited[r][c]==true) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//int mat[][]= {{1,0,0},{1,0,0},{1,9,1}};
		//System.out.println(minDistance(mat));
		List<List<Integer>> matLis=new ArrayList<List<Integer>>();
		
		for(int i=0;i<3;i++) {
			List<Integer> lis=new ArrayList<>();
			for(int j=0;j<3;j++) {
				System.out.println("Enter the number ");
				lis.add(sc.nextInt());
			}
			matLis.add(lis);
		}
		System.out.println(mindistanceList(matLis));
		
		

	}

}
