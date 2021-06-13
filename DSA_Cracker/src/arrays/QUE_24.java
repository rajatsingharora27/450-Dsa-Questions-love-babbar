package arrays;
import java.util.*;

public class QUE_24 {

	public static ArrayList<Integer> common3Element(int A[],int B[],int C[]) {


		HashMap<Integer,Integer>map=new HashMap<Integer,Integer>();

		//Iterating over A
		ArrayList<Integer> arr=new ArrayList<>();
		putInmap(A,map);
		putInmap(B,map);
		putInmap(C,map);

		// Iterating over the map
		Set<Integer> keys=map.keySet();
		for(Integer ele:keys) {
			if(map.get(ele)>=3) {
				arr.add(ele);
				//System.out.println(ele);
			}
		}
		
		if(arr!=null) {
			Collections.sort(arr);
		}
		return arr;



		//System.out.println(map);

	}

	private static void putInmap(int[] arr, HashMap<Integer, Integer> map) {

		for(int i=0;i<arr.length;i++) {
			if(!map.containsKey(arr[i])) {
				map.put(arr[i],1);
			}
			else {
				map.put(arr[i],map.get(arr[i])+1);
			}	
		}


	}

	public static void common3ElementTraverse(int A[],int B[],int C[]) {
		
		int i=0,k=0,j=0;
		
		while(i<A.length && j<B.length && k<C.length) {
			
			if(A[i]==B[j] && B[j]==C[k]) {
				System.out.print(A[i]+" ");
				i++;j++;k++;
			}
			else if(A[i]>B[j] && A[i]>C[k]) {
				j++;k++;
			}
			else if(B[j]>C[k] && B[j]>A[i]) {
				i++;k++;
			}
			else if(A[i]==B[j] && A[i]>C[k]) {
				k++;
			}
			else if(A[i]==C[k] && A[i]>B[j]) {
				j++;
			}
			else if(C[k]==B[j] && A[i]<C[k]) {
				i++;
			}
			
			
			else  {
				j++;i++;
			}	
		}
	
	}




	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = {1, 5, 5};
		int B[] = {3, 4, 5, 5, 10};
		int C[] = {5, 5, 10, 20};
		System.out.println(common3Element(A, B, C));
		common3ElementTraverse(A, B, C);

	}

}
