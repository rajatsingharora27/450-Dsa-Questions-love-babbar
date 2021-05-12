package linkedList;

import java.util.Scanner;



public class QUE_151a {
	
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
	
	public static LinkedListNode<Integer> Sort(LinkedListNode<Integer> head1,LinkedListNode<Integer> head2) {
		
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
		System.out.println("Data for LL1");
		LinkedListNode<Integer>head1=BuildList();
		
		System.out.println("Data for LL2");
		LinkedListNode<Integer>head2=BuildList();
		
		LinkedListNode<Integer> new_head=Sort(head1, head2);
		
		printlist(new_head);

	}

}
