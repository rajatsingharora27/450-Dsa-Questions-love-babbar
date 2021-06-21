package greedy;

import java.util.Arrays;

public class QUE_246 {

	
	public static int stockbuy(int price[],int k) {
		
		QuantPrice arr[]=new QuantPrice[price.length];
		
		for(int i=0;i<price.length;i++) {
			QuantPrice p=new QuantPrice(i+1,price[i]);
			arr[i]=p;	
		}
		
		//Arrays.sort(arr ,(a,b)->a.value-b.value);
		Arrays.sort(arr);
		
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i].quant+" "+arr[i].value);
		}
		
		
		int count=0;
		for(int i=0;i<arr.length;i++) {
				
			if((arr[i].quant*arr[i].value)<=k) {
				count+=arr[i].quant;
				k=k-(arr[i].quant*arr[i].value);
			}
			else {
				//System.out.println(arr[i].value+" "+k);
				int stockCanBuy=(int)(k/arr[i].value);
				count+=stockCanBuy;
				k-=stockCanBuy*arr[i].value;
			}
			System.out.println(k);
		}
		return count;
	
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {10,7,19};
		int k=45;
		System.out.println(stockbuy(arr, k));

	}

}
