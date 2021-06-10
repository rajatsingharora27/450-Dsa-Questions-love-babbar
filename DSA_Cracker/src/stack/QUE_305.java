package stack;

import java.util.Stack;

public class QUE_305 {

	public static int celebrityProblem(int mat[][]) {
		Stack <Integer> s=new Stack<>();

		int len=mat.length;
		for(int i=0;i<len;i++) {
			s.push(i);
		}
		while(s.size()!=1) {

			int first=s.pop();
			int second=s.pop();

			if(mat[first][second]==1) {
				s.push(second);
			}
			else {
				s.push(first);
			}
		}
		int p=s.peek();
		System.out.println(p);
		for(int row=0;row<len;row++) {
			if(p!=row) {
				if(mat[row][p]==0) {
					return -1;
				}
				if(mat[p][row]==1) {
					return -1;
				}
			}
		}
		return p;


	}





	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int M[][] = {{0 ,0 ,1,0},
				{0 ,0 ,1,0}, 
				{0, 0, 0,0},
				{0,0,1,0}};

		System.out.println(celebrityProblem(M));



	}

}
