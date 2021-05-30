package dynamicProgramming;

public class QUE_437 {

	
	public static int maxSubstring(String str) {
		
		
		int arr[]=new int[str.length()];
		for(int i=0;i<arr.length;i++) {
			
			arr[i]=str.charAt(i)-'0';
			if(arr[i]==1) {
				arr[i]=-1;
			}
			else {
				arr[i]=1;
			}
		}
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		int initSum=arr[0];
		int max=arr[0];
		
		for(int i=0;i<arr.length;i++){
			
			if(arr[i]+initSum<arr[i]) {
				initSum=arr[i];
			}
			else {
				initSum+=arr[i];
			}
			
			if(max<initSum) {
				max=initSum;
			}
		}
		System.out.println();
		return max;
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println( maxSubstring("1111111"));
		
		

	}

}
