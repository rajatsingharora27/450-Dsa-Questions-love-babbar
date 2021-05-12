package gaphs;

import java.util.*;

class coordinate{

	int first;
	int second;
	int dis;

	coordinate(int first,int second,int dis){
		this.first=first;
		this.second=second;
		this.dis=dis;
	}
}




public class QUE_362 {

	public static int minDistanceKnight(int KnigtPos[],int TargetPos[],int N) {

		int dx[] = { -2, -1, 1, 2, -2, -1, 1, 2 };
		int dy[] = { -1, -2, -2, -1, 1, 2, 2, 1 };

		Queue<coordinate> q=  new LinkedList<>();

		q.add(new coordinate(KnigtPos[0], KnigtPos[1], 0));

		boolean check[][] =new boolean[N+1][N+1];
		check[KnigtPos[0]][KnigtPos[1]]=true;
		while(!q.isEmpty()) {

			coordinate t=q.poll();
			if(t.first==TargetPos[0] && t.second==TargetPos[1]) {
				return t.dis;
			}

			for(int i=0; i<8 ;i++) {
				int x=t.first+dx[i];
				int y=t.second+dy[i];
				if(isSafe(x,y,N) && !check[x][y]) {
					check[x][y]=true;
					q.add(new coordinate(x, y, t.dis+1));
				}
			}
		}
		return Integer.MAX_VALUE;
	}






	private static boolean isSafe(int x, int y, int n) {
		// TODO Auto-generated method stub
		
		if(x<0 || x>n || y<0 || y>n) {
			return false;
		}	
		return true;
	}






	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int N = 30;
	        int knightPos[] = { 1, 1 };
	        int targetPos[] = { 30, 30 };
	        System.out.println(minDistanceKnight(knightPos, targetPos, N));

	}

}
