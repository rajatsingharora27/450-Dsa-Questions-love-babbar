package arrays;

public class SubarrayWithSumK {

	//taking o(n) space
	public static void subarraySumk(int arr[],int sum) {

		int prefix[]=new int [arr.length];
		prefix[0]=arr[0];
		for(int i=1;i<arr.length;i++) {
			prefix[i]=arr[i]+prefix[i-1];
		}

		for(int i=0;i<prefix.length;i++) {

			if(prefix[i]<sum) {
				continue;
			}

			else {

				int j=0;
				while(j<i && prefix[i]-prefix[j]>=sum) {
					if(prefix[i]-prefix[j]==sum) {
						System.out.println(j+1+" "+i);
						return;
					}

					j++;
				}
			}

		}
		System.out.println("Not possible");

	}







	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {1, 4, 0, 0, 3, 10, 5};
		subarraySumk(arr, 19);

	}

}
