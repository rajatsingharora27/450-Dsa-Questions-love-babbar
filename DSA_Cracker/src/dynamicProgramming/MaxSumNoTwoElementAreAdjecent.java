package dynamicProgramming;

public class MaxSumNoTwoElementAreAdjecent {

	
	public static int maxSumNoAdj(int arr[]) {
		int include=arr[0];
		int exclude=0;
		
		for(int i=1;i<arr.length;i++) {
			int prevInclude=include;
			include=exclude+arr[i];
			exclude=Math.max(exclude, prevInclude);
		}
		
		return Math.max(include, exclude);
		
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int arr[] = {5, 5, 10, 100, 10, 5};
		 System.out.println(maxSumNoAdj(arr));
	}

}
