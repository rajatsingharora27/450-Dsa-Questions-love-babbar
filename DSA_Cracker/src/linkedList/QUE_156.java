package linkedList;

import java.util.Scanner;

public class QUE_156 {
	
	
	public static LinkedListNode<Integer> mid(LinkedListNode<Integer> head){
	
		if(head==null) {
			return null;
		}
		if(head.next==null) {
			return head;
		}
		
		LinkedListNode<Integer> slow=head;
		LinkedListNode<Integer> fast=head;
		
	
		while(fast.next!=null) {
			if(fast.next.next==null) {
				return slow;
			}
			else {
				slow=slow.next;
				fast=fast.next.next;
			}
		}
		//System.out.println((slow.data));
		return slow;
		
		
		
		
		
	}
	
	
	public static boolean isPallendrome(LinkedListNode<Integer> head) {
		LinkedListNode<Integer> ptr=head;
		
		if(head==null || head.next==null) {
			return true;
		}
		
		LinkedListNode<Integer> cur=mid(head);
		
		while(cur!=null) {
			if(cur.data==ptr.data) {
				cur=cur.next;
				ptr=ptr.next;
			}
			else {
				return false;
			}
		}
		
		return true;
		
		
		
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListNode<Integer> head=BuildList();
		System.out.println(mid(head).data);
		//System.out.println(isPallendrome(head));

	}

}
