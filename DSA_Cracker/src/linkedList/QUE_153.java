package linkedList;

import java.util.Scanner;

public class QUE_153 {

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

	public static LinkedListNode<Integer> middle(LinkedListNode<Integer> head){
		LinkedListNode<Integer> fast=head;
		LinkedListNode<Integer> slow=head;


		if(fast==null ||fast.next==null){
			return fast;
		}


		if(fast.next.next==null){
			return fast.next;
		}

		while(fast!=null && fast.next!=null){

			fast=fast.next.next;
			slow=slow.next;
		}       
		return slow;
	}




	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListNode<Integer> head=BuildList();
		System.out.println(middle(head).data);

	}

}
