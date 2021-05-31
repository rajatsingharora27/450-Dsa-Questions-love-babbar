package dynamicProgramming;

public class QUE_445 {
	
	
	public static int minContigiousSum(int arr[]) {
		
		int minSofar=Integer.MAX_VALUE;
		int sumSofar=Integer.MAX_VALUE;
		
		for(int i=0;i<arr.length;i++) {
			
			
			if(sumSofar>0) {
				sumSofar=arr[i];
			}
			else {
				sumSofar+=arr[i];
			}
			
			if(minSofar>sumSofar) {
				minSofar=sumSofar;
			}
			
		}
		return minSofar;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {3, -4, 2, -3, -1, 7, -5};
		System.out.println(minContigiousSum(arr));

	}

}
