package arrays;

public class RemoveDuplicatesFromSortedArrayII {

	public static int RemoveDuplicate(int nums[]) {
		
		  
        int len=nums.length;
        if(len<=2){
            return len;
        }
        
        int i=2;
        int j=2;
        
       
        while(i<nums.length){
            
            if(nums[i]!=nums[j-2]){
            	nums[j++]=nums[i];
            }
            i++;
        
            
             
            
        }
        
        

     
        return j;
    }
		
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[]= {1,1,1,2,2,3};
		System.out.println(RemoveDuplicate(nums));

	}

}
