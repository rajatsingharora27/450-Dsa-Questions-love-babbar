package strings;

public class QUE_66 {

	public  static void permute(String str, int l,int r) {
		
		if(l==r) {
			System.out.println(str);
		}
		
		for(int i=l;i<=r;i++) {
			
			str=swap(str,l,i);
			permute(str, l+1, r);
			str=swap(str,l,i);		
		}
		
		
		
	}
	
	
	
	private static String swap(String str,int i, int j) {
		
		char arr[]=str.toCharArray();
		char temp;
		temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
		return String.valueOf(arr);
		
		
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="ABC";
		permute(str, 0, str.length()-1);
		
	}

}
