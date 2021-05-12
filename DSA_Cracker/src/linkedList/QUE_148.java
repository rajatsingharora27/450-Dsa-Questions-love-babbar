package linkedList;

import java.util.Scanner;

public class QUE_148 {

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
	
	public static LinkedListNode<Integer> reverse(LinkedListNode<Integer> head){
		
		LinkedListNode<Integer> cur=head;
		LinkedListNode<Integer> next=null;
		LinkedListNode<Integer> prev=null;
		
		while(cur!=null) {
			
			next=cur.next;
			cur.next=prev;
			prev=cur;
			cur=next;	
		}
		
		return prev;
		
		
	}
	
	
	
	
	public static LinkedListNode<Integer> addNumbers(LinkedListNode<Integer> head1 , LinkedListNode<Integer> head2){
		
		
		LinkedListNode<Integer> cur1=head1;
		LinkedListNode<Integer> cur2= head2;
		LinkedListNode<Integer> head3=null;
		LinkedListNode<Integer> cur3= null;
		
		
		head1=reverse(head1);
		head2=reverse(head2);
		
		int c=0;
		
		while(cur1 !=null  && cur2!=null) {
			
			int sum=cur1.data+cur2.data +c;
			c=sum/10;
			int v=sum%10;
			
			if(head3 == null) {
				
				head3=new LinkedListNode<Integer>(v);
				cur3=head3;
				
			}
			
			else {
				
				LinkedListNode<Integer> newNode=new LinkedListNode<Integer>(v);
				cur3.next=newNode;
				cur3=newNode;
			}
			
			cur1=cur1.next;
			cur2=cur2.next;	
			
		}
		
		if(cur1==null && cur2!=null) {
			
			 cur3.next= joinrest(cur2,c);
		}		
		
		else {
			cur3.next= joinrest(cur1,c);
			
		}
		
		return reverse(head3);
		
	}
	
	
	
	private static LinkedListNode<Integer> joinrest(LinkedListNode<Integer> head, int c) {
		// TODO Auto-generated method stub
		
		LinkedListNode<Integer> ptr=null;
		LinkedListNode<Integer> cur=head;
		LinkedListNode<Integer> n=null;
		while(cur!=null) {
			
			int sum=cur.data+c;
			c=sum/10;
			int v=sum%10;
			
			if(ptr==null) {
				ptr=new LinkedListNode<Integer>(v);
				n=ptr;
				
			}
			
			else {
				
				LinkedListNode<Integer> newNode=new LinkedListNode<Integer>(v);
				n.next=newNode;
				n=n.next;
			}
			
			cur=cur.next;
		}
		
		return ptr;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedListNode<Integer> head1=BuildList();
		LinkedListNode<Integer> head2=BuildList();
		
		printlist(addNumbers(head1, head2));

	}

}
