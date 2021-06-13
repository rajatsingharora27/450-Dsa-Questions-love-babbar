package arrays;

public class QUE_22 {
	
	// in this question we can buy and sell only one time only
	
	 public int maxProfit(int[] prices) {
	        
	        int minPrice = Integer.MAX_VALUE;
	        int MaxProfit = 0;
	        
	        for(int i=0;i<prices.length;i++){
	            
	            if(prices[i]<minPrice){
	                minPrice=prices[i];
	            }
	            else if(prices[i]-minPrice>MaxProfit){
	                MaxProfit=prices[i]-minPrice;      
	            }
	        }
	        
	        return MaxProfit;
	        
	    }
	
	
	
	
	
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
