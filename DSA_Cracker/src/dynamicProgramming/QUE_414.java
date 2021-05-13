package dynamicProgramming;

public class QUE_414 {

	public static int catlan(int n) {
		
		int arr[]=new int[n+1];
		
		arr[0]=1;
		arr[1]=1;
		
		for(int i=2;i<=n;i++) {
		
			int k=i-1;
			int sum=0;
			for(int j=0;j<i;j++) {
				sum+=arr[j]*arr[k--];
			}
			arr[i]=sum;
		}	
		for( int i=0; i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		return arr[n];
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(catlan(9));

	}

}
