package greedy;


import java.util.Arrays;
import java.util.Scanner;

public class QUE_424 {
	
	
	
	public static int FractionalKnapSack(Item arr[],int w,int n) {
		
		// getting all the v/w
		
		for(int i=0;i<arr.length;i++) {
			arr[i].value=arr[i].value/arr[i].weight;			
		}
		Arrays.sort(arr,(a,b)->b.value-a.value);
		int profit=0;
		
		
		for(int i =0;i<arr.length;i++) {
			System.out.println(arr[i].value+" "+arr[i].weight);
		}
		
		
		
		for(int i=0;i<arr.length && w>0;i++) {
		
			if(w-arr[i].weight>0) {
				profit+=arr[i].value*arr[i].weight;
			}
			else {
				
				double cost=arr[i].value*w;
				profit+=cost;
				w=0;
				
			}
	
		}
		
		
		return profit;
		
		
	}
	
	
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		Item arr[]=new Item[3];
		for(int i=0;i<arr.length;i++) {
			System.out.println("value , weight, "+i+": ");
			Item j=new Item(sc.nextInt(),sc.nextInt());
			arr[i]=j;
		}
		 
		
		System.out.println(FractionalKnapSack(arr, 50,arr.length));
		
	}
	
	

}
