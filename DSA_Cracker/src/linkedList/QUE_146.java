package linkedList;

import java.util.Scanner;

public class QUE_146 {
	
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
	
	public static LinkedListNode<Integer> moveLast2first(LinkedListNode<Integer> head){
		
		LinkedListNode<Integer> cur=head;
		LinkedListNode<Integer> prev=null;
		while(cur.next!=null) {
			prev=cur;
			cur=cur.next;
		}
		cur.next=head;
		prev.next=null;
		return cur;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListNode<Integer>head=BuildList();
		printlist(moveLast2first(head));

	}

}
