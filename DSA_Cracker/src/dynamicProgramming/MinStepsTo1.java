package dynamicProgramming;

//Given a positive integer 'n', 
//find and return the minimum number of steps 
//that 'n' has to take to get reduced to 1. 
//You can perform any one of the following 3 steps:
//
//	1.) Subtract 1 from it. (n = n - ­1) ,
//	2.) If its divisible by 2, divide by 2.( if n % 2 == 0, then n = n / 2 ) ,
//	3.) If its divisible by 3, divide by 3. (if n % 3 == 0, then n = n / 3 ).  

public class MinStepsTo1 {

	public static int countToMin1(int n) {
		
		if(n==1) {
			return 0;
		}
		
		int op1=countToMin1(n-1);
		int minsteps=op1;
		
		if(n%2==0) {
			int op2=countToMin1(n/2);
			if(op2<minsteps) {
				minsteps=op2;
			}
		}
		
		if(n%3==0) {
			int op3=countToMin1(n/3);
			if(op3<minsteps) {
				minsteps=op3;
			}
		}
		
		return 1+minsteps;	
	}
	
	
	
	public static void main(String[] args) {
		
		System.out.println(countToMin1(4));
		

	}

}
