package strings;
import java.util.*;
public class QUE_68 {

	//Using Greedy approach
	public static int WordWrap(int arr[],int k) {

		ArrayList<Integer>ans=new ArrayList<>();
		int i=0;
		while(i<arr.length) {

			if(i==arr.length-1) {
				ans.add(0);
				break;
			}

			int available_space=k;

			while(available_space>0) {

				int flag=0;

				if(available_space-arr[i]<=available_space  && available_space-arr[i]>=0) {

					flag=1;
					available_space=available_space-arr[i];
					i++;
				}
				if(flag==0) {
					ans.add(available_space+1);
					break;
				}
				if(available_space==0) {
					break;
				}
				else {
					available_space--;
				}
			}

		}
		int sum=0;
		for(Integer ele:ans) {
			sum+=ele;
		}

		return sum;
	}






	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {3,2,2};
		System.out.println(WordWrap(arr,4));

	}

}
