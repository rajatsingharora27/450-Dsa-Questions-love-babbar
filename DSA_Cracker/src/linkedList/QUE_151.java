package linkedList;

import java.util.Scanner;


public class QUE_151 {
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
	
	public static LinkedListNode<Integer> mid(LinkedListNode<Integer> head){
		
		if( head==null || head.next==null) {
			return head;
		}
		
		LinkedListNode<Integer>slow=head;
		LinkedListNode<Integer>fast=head;
		
		while(fast.next!=null) {
			if(fast.next.next==null) {
				//slow.next=null;
				return slow;
			}
			else {
			slow=slow.next;
			fast=fast.next.next;
		}
		}
		return slow;
	}

	public static LinkedListNode<Integer> mergesort(LinkedListNode<Integer> head){
		
		if(head==null || head.next==null) {
			return head;
		}
		
		LinkedListNode<Integer> middle=mid(head);
		LinkedListNode<Integer> next_to_middle=middle.next;
		middle.next=null;
		LinkedListNode<Integer> sort1=mergesort(head);
		LinkedListNode<Integer> sort2=mergesort(next_to_middle);
		
		return merge(sort1,sort2);
	}

	public static LinkedListNode<Integer> merge(LinkedListNode<Integer> head1,LinkedListNode<Integer> head2) {
		
		LinkedListNode<Integer> cur1=head1;
		LinkedListNode<Integer> cur2=head2;
		LinkedListNode<Integer> new_head=null;
		LinkedListNode<Integer> new_tail=null;
		
		if (cur1.data<cur2.data) {
			
			new_head=cur1;
			new_tail=cur1;
			cur1=cur1.next;
			
		}

		else {
			new_head=cur2;
			new_tail=cur2;
			cur2=cur2.next;
		}
		
		
		while(cur1!=null && cur2!=null) {
			
			if(cur2.data < cur1.data) {
				
				new_tail.next=cur2;
				new_tail=cur2;
				cur2=cur2.next;	
			}
			
			else {
				
				new_tail.next=cur1;
				new_tail=cur1;
				cur1=cur1.next;	
			}
		}
		
		if(cur2==null && cur1!=null) {
			new_tail.next=cur1;
		}
		else {
			new_tail.next=cur2;
		}
		
		return new_head;
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
		// TODO Auto-generated method stub
		LinkedListNode<Integer> head=BuildList();
		LinkedListNode<Integer> new_head=mergesort(head);
		printlist(new_head);

	}

}
