package dynamicProgramming;

public class QUE_446 {

	public static int knapSack(int N, int W, int val[], int wt[]) {
		return knapSack(N, W, val, wt,0);
	}



	private static int knapSack(int n, int w, int[] val, int[] wt, int si) {

		if(w==0||w<0||si==n) {
			return 0;
		}



		//int include=0,exclude=0;


		if(wt[si]>w) {
			return knapSack(n, w, val, wt,si+1);
		}
		

		int include=knapSack(n, w-wt[si], val, wt,si)+val[si];
		int exclude=knapSack(n, w, val, wt,si+1);




		return Math.max(include, exclude);






	}




	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N = 4, W = 8;

		int val[] = {1, 4, 5, 7};
		int wt[] = {1, 3, 4, 5};

		System.out.println(knapSack(N, W, val, wt));


	}

}
