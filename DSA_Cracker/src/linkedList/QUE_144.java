package linkedList;

import java.util.Scanner;


public class QUE_144 {

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
	
	public static LinkedListNode<Integer> remove(LinkedListNode<Integer> head){
		
		if(head==null ||  head.next==null) {
			return head;
		}
		
		LinkedListNode<Integer> cur= head;
		
		while(cur!=null) {
			
			LinkedListNode<Integer> temp=cur;
			
			while(temp!=null && temp.data==cur.data) {
				temp=temp.next;
			}
			cur.next=temp;
			cur=cur.next;	
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
		LinkedListNode<Integer> head=BuildList();
		printlist (remove(head));

	}

}
