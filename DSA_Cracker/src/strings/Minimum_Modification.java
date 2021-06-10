package strings;







public class Minimum_Modification {


	//Two persons A and B are fighting each other.
	//They attack each other equal number of times.
	//B respects A and never performs an extra attack before A 
	//i.e. at all times number of attacks by A are ≥ number of attacks by B.
	//You are given a string where each character denoted the attack by A or B. 
	//You have to make minimum modifications to this string to make sure that above mentioned 
	//constraints are satisfied.

	//	Input:
	//		S = "AABB"
	//		Output: 
	//		0
	//		Explanation:
	//		No modifications required. Both attack each 
	//		other equal number of times and at all times
	//		the number of attacks done by 'A' is greater 
	//		than or equal to the number of attacks done by 
	//		'B'.

	public static int minmod(String S) {



		int ans=0,x=0;
		for(int i=0;i<S.length();i++)
		{
			if(S.charAt(i)=='A')
				x++;
			else
			{
				if(x==0)
				{
					x++;
					ans++;
				}
				else
				{
					x--;
				}
			}
		}
		ans+=x/2;
		return ans;
	}




public static void main(String[] args) {
	// TODO Auto-generated method stub

}

}
