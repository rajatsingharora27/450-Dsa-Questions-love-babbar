package arrays;

public class QUE_13 {

	public static void kadensAlgo(int arr[]) {
		
		if(arr.length==0) {
			return;
		}
		
		int currentBest=arr[0];
		int overallBest=arr[0];
		
		for(int i=1;i<arr.length;i++) {
			
			if(arr[i]+currentBest<arr[i]) {
				currentBest=arr[i];
			}
			else {
				currentBest+=arr[i];
			}
			
			if(overallBest<currentBest){
				overallBest=currentBest;
			}			
		}
		
		System.out.println(overallBest);
		
		
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {1,2,3,-2,5};
		kadensAlgo(arr);

	}

}
