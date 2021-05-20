package arrays;

public class ContainerWithMostWater {

	public static int minWater(int arr[]) {
		
		int i=0,j=arr.length-1;
		
		int ans=Integer.MIN_VALUE;
		
		while(i<j) {
			
			int h=Math.min(arr[i], arr[j]);
			int c= Math.abs((i-j));
			int area=h*c;
			if(area>ans) {
				ans=area;
			}
			if(arr[i]<arr[j]) {
				i++;
			}
			else if(arr[i]>arr[j]) {
				j--;
			}
			else {
				i++;
				j--;
			}
		}
		return ans;		
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[]= {4,3,2,1,4};
		System.out.println(minWater(arr));

	}

}
