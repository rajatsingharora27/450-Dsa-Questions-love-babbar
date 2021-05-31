package dynamicProgramming;

public class QUE_438 {

	public static int minJumps(int arr[]) {
		
		int jumps[]=new int[arr.length];
		
		for(int i=1;i<arr.length;i++) {
			jumps[i]=Integer.MAX_VALUE;
		}
		
		
		for(int i=1;i<arr.length;i++) {
			for(int j=0;j<i;j++) {
				if(arr[j]+j>=i) {
					jumps[i]=Math.min(jumps[j]+1, jumps[i]);
				}
			}
		}
		for(int i=0;i<jumps.length;i++) {
			System.out.print(jumps[i]+" ");
		}
		System.out.println();
		return jumps[arr.length-1];
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]={ 1, 3, 6, 1, 0, 9};
		System.out.println(minJumps(arr));

	}

}
