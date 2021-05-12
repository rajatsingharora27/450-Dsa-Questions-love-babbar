package gaphs;

import java.util.ArrayList;

public class Que_361 {

	static ArrayList<String> ans= new ArrayList<>();

	public static ArrayList<String> findPath(int m[][] ,int n){
		boolean check[][] =new boolean[m.length][m.length];
		solvemaze(m ,n ,check , 0 , 0,"");
		return ans;
	}



	private static void solvemaze(int[][] m, int n ,boolean[][] check, int x, int y,String str) {
		

		if(x==n-1 && y==n-1) {
			if(m[x][y]==1 ) {
				//System.out.println(str);
				ans.add(str);
				
			}
			
			
		}
		
		check[x][y]=true;


		if(isSafe(m,n, check, x, y+1 )) {
			str+="R";
			check[x][y+1]=true;
			solvemaze(m , n , check , x ,y+1, str);
			str=str.substring(0, str.length()-1);	
		}

		if(isSafe(m,n, check, x, y-1 )) {
			str+="L";
			check[x][y-1]=true;
			solvemaze(m , n , check , x ,y-1, str);
			str=str.substring(0, str.length()-1);	
		}
		if(isSafe(m,n, check, x+1, y )) {
			str+="D";
			check[x+1][y]=true;
			solvemaze(m , n , check , x+1 ,y, str);
			str=str.substring(0, str.length()-1);	
		}
		if(isSafe(m,n, check, x-1, y )) {
			str+="U";
			check[x-1][y]=true;
			solvemaze(m , n , check , x-1 ,y, str);
			str=str.substring(0, str.length()-1);	
		}
			
		check[x][y]=false;	

	}



	private static boolean isSafe(int[][] m, int n,boolean[][] check, int row, int col) {
		// TODO Auto-generated method stub
		if (row == -1 || row == n || col == -1 ||col == n || check[row][col] ||m[row][col] == 0){
		return false;
		}
		
		
		return true;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m1[][] = {	{ 1, 0, 0, 0, 0 },
						{ 1, 1, 1, 1, 1 },
						{ 1, 1, 1, 0, 1 },
						{ 0, 0, 0, 0, 1 },
						{ 0, 0, 0, 0, 1 } };
		
		int m[][]= {{1 ,0 ,0 ,0},
					{1, 1, 0, 1},
					{1, 1, 0, 0},
					{0, 1, 1, 1}};
		
		
		//int n = m.length;

		findPath(m1,m1.length);
		
		findPath(m,m.length);
		System.out.println();
		
		for(int i=0;i<ans.size();i++) {
			System.out.println(ans.get(i));
		}

	}

}
