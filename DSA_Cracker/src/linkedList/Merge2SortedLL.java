package linkedList;

import java.util.Scanner;

public class Merge2SortedLL {

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

	public static LinkedListNode<Integer> merge(LinkedListNode<Integer> head1 ,LinkedListNode<Integer> head2) {

		LinkedListNode<Integer> ptr1=head1;
		LinkedListNode<Integer> ptr2=head2;
		LinkedListNode<Integer> cur=null;
		LinkedListNode<Integer> head3= new LinkedListNode<Integer>(-1);
		LinkedListNode<Integer> ptr3=head3;
		
		
		
		
		while(ptr1!=null &&  ptr2!=null) {
			
			if(ptr1.data<ptr2.data) {
				cur=ptr1.next;
				ptr1.next=null;
				ptr3.next=ptr1;
				ptr3=ptr3.next;
				ptr1=cur;
			}
			else {
				
				cur=ptr2.next;
				ptr2.next=null;
				ptr3.next=ptr2;
				ptr3=ptr3.next;
				ptr2=cur;
				
			}

		}
		if(ptr2==null && ptr1!=null) {
			ptr3.next=ptr1;
		}
		else if(ptr2!=null && ptr1==null)
		{
			ptr3.next=ptr2;
		}
		
		return head3.next;


	}






	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListNode<Integer> head1=BuildList();
		LinkedListNode<Integer> head2=BuildList();
		LinkedListNode<Integer> h=merge(head1, head2);
		printlist(h);

	}

}
