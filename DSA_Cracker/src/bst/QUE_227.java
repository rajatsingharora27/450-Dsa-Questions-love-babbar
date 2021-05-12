package bst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class QUE_227 {

	public static BstNode<Integer> buildbst(){
		Scanner sc=new Scanner(System.in);
		Queue<BstNode<Integer>> q= new LinkedList<>();
		BstNode<Integer> root=null;
		System.out.println("Enter root data: ");
		int rootData=sc.nextInt();

		if(rootData!=-1) {
			root=new BstNode<>(rootData);
			q.add(root);
		}

		while(!q.isEmpty()) {

			BstNode<Integer> fv=q.poll();
			//System.out.println("Enter left child and right child: ");


			//System.out.println("left child press 1 ?" +fv.data+" ");
			System.out.println("Enter the left child of "+fv.data+" " );
			int leftdata=sc.nextInt();

			if(leftdata!=-1) {

				BstNode<Integer> leftChild=new BstNode<Integer>(leftdata);
				fv.left=leftChild;
				q.add(leftChild);
			}

			System.out.println("Enter the right child of "+fv.data+" " );
			int rightdata=sc.nextInt();

			if(rightdata!=-1){

				BstNode<Integer> rightChild=new BstNode<Integer>(rightdata);
				fv.right=rightChild;
				q.add(rightChild);
			}
		}	
		return root;	

	}
	
	public static int countPairs(BstNode<Integer> root1 , BstNode<Integer> root2 , int x) {
		
		ArrayList<Integer> arr1=new ArrayList<Integer>();
        ArrayList<Integer> arr2=new ArrayList<Integer>();
        
        inorder(root1,arr1);
        revinorder(root2,arr2);
        
        System.out.println(arr1);
        System.out.println(arr2);
        
        
        int i=0, j=0;
        int count=0;
        
        while(i<arr1.size() && j<arr2.size() ){
            
            if(arr1.get(i) + arr2.get(j) <x){
                i++;
            }
            
            else if(arr1.get(i) + arr2.get(j) >x){
                j++;
            }
            else{
                i++;
                j++;
                count++;
            }
        }
        
        System.out.println(count);
        return count;
		
		
		
		
	}
	
	
	private static void revinorder(BstNode<Integer> root2, ArrayList<Integer> arr2) {
		
		
		  if(root2==null){
	            return;
	        }
	        
	        revinorder(root2.right,arr2);
	        arr2.add(root2.data);
	        revinorder(root2.left,arr2);
		
		
		
	}

	private static void inorder(BstNode<Integer> root1, ArrayList<Integer> arr1) {
		
		 if(root1==null){
	            return;
	        }
	        
	        inorder(root1.left,arr1);
	        arr1.add(root1.data);
	        inorder(root1.right,arr1);

		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BstNode<Integer>root1 = buildbst();
		BstNode<Integer>root2 = buildbst();
			
		countPairs(root1,root2,16);
		
		
	}

}
