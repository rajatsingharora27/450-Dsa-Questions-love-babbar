package linkedList;

import java.util.PriorityQueue;
import java.util.Scanner;

public class QUE_161 {
	public static DoubleLLNode builtDoubleLL() {

		Scanner sc=new Scanner(System.in);

		System.out.println("Enter number of node");

		int nodes=sc.nextInt();

		System.out.println("Enter the data in head node");

		DoubleLLNode head=new DoubleLLNode(sc.nextInt());
		DoubleLLNode ptr=head;

		for(int i =0;i<nodes-1;i++) {

			System.out.println("Enter data");
			int d=sc.nextInt();

			DoubleLLNode newNode=new DoubleLLNode(d);
			ptr.right=newNode;
			newNode.left=ptr;
			ptr=ptr.right;		
		}

		return head;


	}


	public static void printList(DoubleLLNode head) {

		DoubleLLNode ptr=head;

		while(ptr!=null) {
			System.out.print (ptr.data+" ");
			ptr=ptr.right;
		}	
	}

	
	public static void Ksorted(DoubleLLNode head,int k) {
		
		
		PriorityQueue<Integer> heap=new PriorityQueue<>();
		
		DoubleLLNode ptr=head;
		
		for(int i=0;i<=k;i++) {
			if(ptr==null) {
				break;
			}
			heap.add(ptr.data);
			ptr=ptr.right;
		
		}
		
		while(ptr!=null) {
			System.out.print(heap.poll()+" ");
			heap.add(ptr.data);
			ptr=ptr.right;
		}
		
		while(heap.size()>0) {
			System.out.print(heap.poll()+" ");
		}
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoubleLLNode head= builtDoubleLL();
		Ksorted(head, 2);
		

	}

}
