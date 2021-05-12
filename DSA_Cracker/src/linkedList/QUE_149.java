package linkedList;

import java.util.Scanner;

public class QUE_149 {
	
	
	public static LinkedListNode<Integer> intersection(LinkedListNode<Integer> head1,LinkedListNode<Integer> head2){
		
		
		LinkedListNode<Integer> cur1=head1;
		LinkedListNode<Integer> cur2=head2;
		LinkedListNode<Integer> ptr=null;
		LinkedListNode<Integer> head3=null;
		while(cur1!=null && cur2!=null) {
			
			if(cur1.data>cur2.data) {
				cur2=cur2.next;
			}
			else if(cur1.data<cur2.data) {
				cur1=cur1.next;
			}
			else {
				if(ptr==null) {
					head3=new LinkedListNode<Integer>(cur1.data);
					ptr=head3;
				}
				else {
					LinkedListNode<Integer> newNode=new LinkedListNode<Integer>(cur1.data);
					ptr.next=newNode;
					ptr=newNode;
				}
				
				cur1=cur1.next;
				cur2=cur2.next;
				
				
			}
		}
		
		return head3;		
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
		// TODO Auto-generated method stub
		LinkedListNode<Integer> head1=BuildList();
		LinkedListNode<Integer> head2=BuildList();
		printlist(intersection(head1, head2));

	}

}
