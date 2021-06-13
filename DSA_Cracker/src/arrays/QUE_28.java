package arrays;

public class QUE_28 {
	public static int maxProductSubarray(int arr[]) {

		if(arr.length==1) {
			return (arr[0]);
		}
		int maxEnding=arr[0];
		int minEnding=arr[0];
		int ele=arr[0];
		int max_=0;

		for(int i=1;i<arr.length;i++) {
			if(arr[i]==0) {
				maxEnding=1;
				minEnding=1;
			}

			else {
				maxEnding=Math.max(ele, Math.max(maxEnding*arr[i], minEnding*arr[i]));
				minEnding=Math.min(ele, Math.min(maxEnding*arr[i], minEnding*arr[i]));

				if(maxEnding>max_) {
					max_=maxEnding;
				}
			}
		}
		return max_;

	}

	public static void main(String[] args) {
		int arr[]= {-2,-3,4,5,6,0,50};
		System.out.println(maxProductSubarray(arr));

	}

}
