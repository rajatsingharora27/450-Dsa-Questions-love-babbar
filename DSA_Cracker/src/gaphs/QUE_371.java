package gaphs;

public class QUE_371 {
	
	
	public static int countIsland(int mat[][]) {
		
		boolean check[][] = new boolean[mat.length][mat[0].length];
		int count=0;
		for(int i=0;i<mat.length;i++) {
			for (int j=0; j<mat[0].length;j++) {
				if(mat[i][j]==1 && !check[i][j]) {
					dfs(mat,check,i,j);
					count++;
				}
			}
		}
		return count;		
	}
	
	

	private static void dfs(int[][] mat, boolean[][] check, int x, int y) {
		// TODO Auto-generated method stub
		int dx[]={ -1, -1, -1, 0, 0, 1, 1, 1 };
        int dy[]={ -1, 0, 1, -1, 1, -1, 0, 1 };
        
        check[x][y]=true;
        for( int i=0;i<8;i++) {
        	int posx=x+dx[i];
        	int posy=y+dy[i];
        	
        	if(isValid(posx,posy,mat)  && !check[posx][posy] && mat[posx][posy]==1) {
        		dfs(mat,check,posx,posy);
        	}	
        }		
	}



	private static boolean isValid(int x, int y, int[][] mat) {
		// TODO Auto-generated method stub
		
		if(x<0 || x>=mat.length || y<0 || y>=mat[0].length) {
			return false;
		}
		return true;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int Mat[][]={ 	{ 1, 1, 0, 0, 0 },
						{ 0, 1, 0, 0, 1 },
						{ 1, 0, 0, 1, 1 },
						{ 0, 0, 0, 0, 0 },
						{ 1, 0, 1, 0, 1 } };
		System.out.println(countIsland(Mat));

	}

}
