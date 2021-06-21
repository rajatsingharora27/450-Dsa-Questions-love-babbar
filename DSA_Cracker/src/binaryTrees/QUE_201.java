package binaryTrees;
import java.util.*;
public class QUE_201 {
	static int checkMirrorTree(int n, int e, int[] A, int[] B) {
		// code here
		ArrayList<Integer> u1=new ArrayList<Integer>();
		ArrayList<Integer> v1=new ArrayList<Integer>();

		for(int i=0;i<A.length;i++){
			if(i%2==0){
				u1.add(A[i]);
			}else{
				v1.add(A[i]);
			}
		}


		ArrayList<Integer> u2=new ArrayList<Integer>();
		ArrayList<Integer> v2=new ArrayList<Integer>();

		for(int i=0;i<B.length;i++){
			if(i%2==0){
				u2.add(B[i]);
			}else{
				v2.add(B[i]);
			}
		}


		HashMap<Integer,Stack<Integer>> map=new HashMap<>();

		// for list 1
		for(int i=0;i<u1.size();i++){
			if(map.containsKey(u1.get(i))){
				map.get(u1.get(i)).push(v1.get(i));

				//map.put(u1.get(i), );

			}
			else{
				Stack<Integer> s=new Stack<Integer>();
				s.push(v1.get(i));
				map.put(u1.get(i),s);
			}
		}
		
		
		for(int i=0;i<u2.size();i++) {
			if(map.get(u2.get(i)).peek()!=v2.get(i)) {
				return 0;
			}
			else {
				map.get(u2.get(i)).pop();
			}
		}
		return 1;
		
		
		
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		{ 1, 1, 1, 10, 10, 10 };
//		{ 10, 7, 3, 4, 5, 6 
		int n = 3, e = 2;
		int A[] = {1, 10,1,7,1,3,10,4,10,5,10,6};
		int B[] = {1,3,1,7,1,10,10,6,10,5,10,4};
		System.out.println(checkMirrorTree(n,e,A,B));

	}

}
