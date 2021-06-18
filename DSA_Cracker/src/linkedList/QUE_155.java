package linkedList;

import java.util.Scanner;

public class QUE_155 {
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

	public static void splitCircircularLL(LinkedListNode<Integer> head) {

		if( head ==null ) {
			return;
		}

		if(head.next==null || head.next.next==null) {
			return;
		}


		LinkedListNode<Integer> fast=head;
		LinkedListNode<Integer> slow=head;
		LinkedListNode<Integer> ptr=head;
		while(fast.next!=head && fast.next.next!=head) {
			fast=fast.next.next;
			slow=slow.next;
			ptr=slow.next;
		}

		//even list
		if(fast.next!=head){
			slow.next=head;
			fast.next.next=fast;
			
		}
		
		else {
			slow.next=head;
			fast.next=ptr;
		}

		














	}




	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
