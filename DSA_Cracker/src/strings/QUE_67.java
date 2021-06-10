package strings;

public class QUE_67 {

	public static int maxSubStr(String str) {


		int max=-1;

		int count_0=0;
		int count_1=0;

		for(int i=0;i<str.length();i++) {

			if(str.charAt(i)=='0') {
				count_0++;
			}
			else {
				count_1++;
			}

			if(count_1==count_0) {
				if(max<count_0+count_1) {
					max=count_0+count_1;
				}
				//System.out.println(count_0);
				count_0=0;
				count_1=0;
			}
			
		}
		return max;	
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="001001011";
		System.out.println(maxSubStr(str));

	}

}
