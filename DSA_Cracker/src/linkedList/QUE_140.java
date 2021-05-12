package linkedList;

import java.util.Scanner;


public class QUE_140 {
	
public static LinkedListNode<Integer> kreverse(LinkedListNode<Integer> head , int k){
		
		if(head==null || head.next==null){
			return head;
		}		
		
		
		LinkedListNode<Integer>tempHead=head;
		LinkedListNode<Integer>next_tobetail=head;
		
		for(int i=1;i<k;i++) {
			if(tempHead.next==null) {
				//head=reverse(head);
				break;
			}
			tempHead=tempHead.next;
		}
		LinkedListNode<Integer>newHead=tempHead.next;
		tempHead.next=null;
		head=reverse(head);
		newHead=kreverse(newHead, k);
		next_tobetail.next=newHead;
		return head;	
	}

	private static LinkedListNode<Integer> reverse(LinkedListNode<Integer> head) {
		
		if(head==null || head.next==null) {
			return head;
		}
		
		
		LinkedListNode<Integer>cur=head;
		LinkedListNode<Integer>prev=null;
		LinkedListNode<Integer>next=null;
		
		while(next!=null) {
			
			next=cur.next;
			cur.next=prev;
			prev=cur;
			cur=next;
		}
		
		return prev;
	}

	public static LinkedListNode<Integer> BuildList(){
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter number of node is Linked list");
		int totalNodes= sc.nextInt();

		
			System.out.println("Enter the data in head node");

			int data= sc.nextInt();
			LinkedListNode<Integer> head = new LinkedListNode<Integer>(data);
			LinkedListNode<Integer> cur = head;
			for ( int i = 1; i<totalNodes ; i++) {
				
				System.out.println("Enter node data");
				int d= sc.nextInt();

				if(head.next==null) {
					head.next= new LinkedListNode<Integer>(d);
					cur=head.next;
				}

				else {
					cur.next= new LinkedListNode<Integer>(d);
					cur=cur.next;	
				}		
			}
		

		return head;

	}

	public static void printlist(LinkedListNode<Integer> head) {
		if(head == null) {
			return ;
		}
		
		LinkedListNode<Integer> cur=head;
		
		while(cur!=null) {
			
			System.out.print(cur.data+" ");
			cur=cur.next;
		}
	}

	
	
	
	
	
	public static void main(String[] args) {
		LinkedListNode<Integer> head=BuildList();
		LinkedListNode<Integer>new_head= kreverse(head, 2);
		printlist(new_head);

	}
	

}
