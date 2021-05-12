package dynamicProgramming;

public class Staircase {
	
//	A child runs up a staircase with 'n' steps and can 
//	hop either 1 step, 2 steps or 3 steps at a time. 
//	Implement a method to count and 
//	return all possible ways in which the child can run-up to the stairs.
	
	
	
	// Using Recursion
	public static int countRec(int n) {
		
		if(n==0 || n==1) {
			return 1;
		}
		else if(n==2) {
			return 2;
		}
		
		int step1=countRec(n-1);
		int step2=countRec(n-2);
		int step3=countRec(n-3);
		
		return step1+step2+step3;
		
		
	}
	
	//Using DP
	public static int countDP(int n) {
		
		int steps[]=new int [n+1];
		
		steps[0]=1;
		steps[1]=1;
		steps[2]=2;
		
		for(int i=3;i<=n;i++) {
			steps[i]=steps[i-1]+steps[i-2]+steps[i-3];
		}
		
		return steps[n];	
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countRec(4));
		System.out.println(countDP(4));
	}

}
