package gaphs;

import java.util.LinkedList;
import java.util.Queue;

class coordinates{

	int first;
	int second;

	coordinates(int first, int second){
		this.first=first;
		this.second=second;
	}
}


public class QUE_363 {


	public static int [][] floodColor(int img[][] ,  int sc , int sr , int newcolor){

		int dx[]= {1,0,-1,0};
		int dy[]= {0,1,0,-1};

		int old=img[sr][sc];

		boolean check[][] = new boolean[img.length+1][img[0].length+1];

		Queue<coordinates> q= new LinkedList<>();
		q.add(new coordinates(sc,sr));

		img[sr][sc]=newcolor;
		while(!q.isEmpty()) {

			coordinates t=q.poll();
			for(int i=0 ; i <4; i++) {

				int x=dx[i]+t.first;
				int y=dy[i]+t.second;

				if(isSafe(x,y,img,old) && !check[x][y]) {
					check[x][y]=true;
					img[x][y]=newcolor;
					q.add(new coordinates(x,y));
				}
			}		
		}
		
		for(int i=0;i<img.length;i++) {
			for(int j=0;j<img[0].length;j++) {
				System.out.print(img[i][j]+" ");
			}
			System.out.println();
		}

		return img;
	}





	private static boolean isSafe(int x, int y, int img[][], int old) {
		int n=img[0].length;
		int m=img.length;
		return (x >=0 && x < m && y >= 0 && y < n && img[x][y] == old);
	}





	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int img[][]= {	{1,2,1,1},
						{2,1,1,2},
						{1,0,1,0}};
		
		img=floodColor(img,1,2,3);

//		for(int i=0;i<img.length;i++) {
//			for(int j=0;j<img.length;j++) {
//				System.out.print(img[i][j]+" ");
//			}
//			System.out.println();
//		}

	}

}
