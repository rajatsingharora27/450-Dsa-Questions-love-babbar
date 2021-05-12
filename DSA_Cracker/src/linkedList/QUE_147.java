package linkedList;

import java.util.Scanner;

public class QUE_147 {
	
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
			
			System.out.print(cur.data);
			cur=cur.next;
		}
	}

	
	public static LinkedListNode<Integer> reverse(LinkedListNode<Integer> head){
		
		LinkedListNode<Integer> prev = null;
		LinkedListNode<Integer> cur =  head;
		LinkedListNode<Integer> next = null;
		
		while(cur!=null) {
			
		next=cur.next;
		cur.next=prev;
		prev=cur;
		cur=next;
		}
		return prev;
	}
	
	public static LinkedListNode<Integer> addOne(LinkedListNode<Integer> head){
		
		
		head=reverse(head);
		LinkedListNode<Integer> prev=null;
		LinkedListNode<Integer> cur = head;
		int c=1;
		
		while(cur!=null) {
			int sum = cur.data+c;
			c=sum/10;
			int v=sum%10;
			cur.data=v;
			prev=cur;
			cur=cur.next;
		}
		if(c!=0) {
			LinkedListNode<Integer> newNode=new LinkedListNode<Integer>(c);
			prev.next=newNode;
		}
		return reverse(head);
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedListNode<Integer> head=BuildList();
		printlist(addOne(head));
		
		

	}

}
