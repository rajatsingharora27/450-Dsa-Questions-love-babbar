package arrays;

public class QUE_12 {

	public static void rotate(long arr[],long n) {

		long temp=arr[0];

		for(long i=1;i<n;i++){
			long var_=arr[(int) i];
			arr[(int) i]=temp;
			temp=var_;
		}

		arr[0]=temp;


	}





	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
