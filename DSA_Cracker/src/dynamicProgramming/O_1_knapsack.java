package dynamicProgramming;

import java.util.*;

public class O_1_knapsack {

	public static int KS(int weight[],int values[],int W) {
		
		int ans = KSrec(weight,values,W,0);
		return ans;
	}
	
	
	private static int KSrec(int[] weight, int[] values, int w, int i) {
		
		if(w==0 || i==weight.length) {
			return 0;
		}
		
		if(weight[i]>w) {
			return KSrec(weight , values , w , i+1);
		}
		
		else {
			
			int op1=values[i]+KSrec(weight,values,w-weight[i],i+1);
			int op2=KSrec(weight,values,w,i+1);
			return Math.max(op1, op2);
		}	
	}


	// Using Dynamic Programming
	
	public static int KSDp(int[] weight, int[] value, int n, int maxWeight) {
		

        int r=n;
        int c=maxWeight;
        int storage[][]=new int [n+1][maxWeight+1];

        for(int i=0;i<=r;i++) {
            storage[i][0]=0;
        }

        for(int i=0;i<=c;i++) {
            storage[0][i]=0;
        }


        for(int i=1;i<=r;i++) {
            for(int j=1;j<=c;j++) {
                if(weight[i-1]>j) {
                    storage[i][j]=storage[i-1][j];
                }
                else {
                    int val1=value[i-1]+storage[i-1][j-weight[i-1]];
                    int val2=storage[i-1][j];
                    int ans=Math.max(val1, val2);
                    storage[i][j]=ans;
                }
            }
        }

        return storage[r][c];

		
		
		
		
		
		
	}
	
	
	
	
	
	


	public static void main(String[] args) {
		int weights[]={4,5,1};
		int values[]={1,2,3};
		
		System.out.println(KS(weights,values,3));
	}
	

}
