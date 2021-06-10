package heap;

public class QUE_242 {

	public static int[] mergeTwoList(int a[],int b[]) {
		int n=a.length;
		int m=b.length;
		int merged[]=new int [n+m];

		for(int i=0;i<a.length;i++) {
			merged[i]=a[i];
		}
		int j=0;
		for(int i=a.length;i<merged.length;i++) {
			merged[i]=b[j];
			j++;
		}

		return merged;
	}

	public static void buildHead(int merged[]) {
		int n=merged.length;
		for(int i=n/2-1;i>=0;i--) {
			heapify(merged,i);
		}
	}





	private static void heapify(int[] merged, int i) {


		int l=2*i+1;
		int r=2*i+2;
		int max=0;
		if(l<=merged.length &&  merged[i]<merged[l]) {
			max=l;
		}
		else {
			max=i;
			if(r<=merged.length &&  merged[i]<merged[r]) {
				max=r;
			}
		}
		
		if(max!=i) {
			
			int temp=merged[i];
			merged[i]=merged[max];
			merged[max]=temp;
			heapify(merged, max);	
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
