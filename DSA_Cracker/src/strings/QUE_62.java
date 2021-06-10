package strings;

public class QUE_62 {

	public static String countandSay(int n) {

		if(n==1) {
			return "1";
		}
		String dp[]=new String[n+1];
		dp[0]="1";
		dp[1]="1";
		dp[2]="11";

		for(int i=3;i<dp.length;i++) {

			String prev=dp[i-1];
			String str="";

			for(int j=0;j<prev.length();j++) {
				int count =1;
				while(j+1<prev.length() && prev.charAt(j)==prev.charAt(j+1)) {
					count++;
					++j;
				}
				
				str=str+String.valueOf(count)+prev.charAt(j);


			}
			dp[i]=str;
		}

		for(int i=0;i<dp.length;i++) {
			System.out.print(dp[i]+" ");
		}

		return dp[n];
	}




	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countandSay(4));

	}

}
