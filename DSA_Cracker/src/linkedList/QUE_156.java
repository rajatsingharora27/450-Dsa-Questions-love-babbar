package linkedList;

import java.util.Scanner;

public class QUE_156 {


	public static boolean isPallen(LinkedListNode<Integer> head) {

		if(head==null) {
			return true;
		}
		if(head.next==null) {
			return true;
		}
		
		if(head.next.next==null) {
			if(head.data==head.next.data) {
				return true;
			}
			else {
				return false;
			}
		}
		
		
		
		
		

		LinkedListNode<Integer> slow=head;
		LinkedListNode<Integer> fast=head;


		while(fast!=null  && fast.next!=null ) {
			fast=fast.next.next;
			slow=slow.next;
		}
		LinkedListNode<Integer>head2=reverse(slow.next);


		slow.next=null;
		
//		printlist(head);
//		System.out.println();
//		printlist(head2);
//		


		while(head!=null && head2!=null) {

			if(head.data!=head2.data) {
				System.out.println(head.data);
				System.out.println(head2.data);
				return false;
			}
			head=head.next;
			head2=head2.next;		
		}	
		
		return true;

	}



	private static LinkedListNode<Integer> reverse(LinkedListNode<Integer> head) {

		LinkedListNode<Integer>cur=head;
		LinkedListNode<Integer>ptr=null;
		LinkedListNode<Integer>Next=null;

		while(cur!=null) {

			ptr=cur.next;
			cur.next=Next;
			Next=cur;
			cur=ptr;

		}
		return Next;


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
		System.out.println(isPallen(head));

	}

}
