package arrays;

public class QUE_39 {
	public static int palinArray(int[] a, int n)
	{
		//add code here.
		for(int i=0;i<a.length;i++){
			boolean isPallen=isPallendrome(a[i]+"");
			if(!isPallen){
				return 0;
			}
		}
		return 1;
	}


	public static boolean isPallendrome(String num){


		int i=0,j=num.length()-1;
		while(i<j){
			if(num.charAt(i)!=num.charAt(j)){
				return false;
			}
			i++;j--;
		}

		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
