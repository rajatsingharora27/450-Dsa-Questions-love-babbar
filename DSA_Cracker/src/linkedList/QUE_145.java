package linkedList;

import java.util.HashSet;
import java.util.Scanner;



public class QUE_145 {
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
		
		HashSet<Integer> map=new HashSet<>();
		LinkedListNode<Integer>cur=head;
		LinkedListNode<Integer>prev=null;
		while(cur!=null) {
			
			if(!map.contains(cur.data)) {
				map.add(cur.data);
				prev=cur;
				cur=cur.next;
			}
			else {
				cur=cur.next;
				prev.next=cur;
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
		LinkedListNode<Integer> head=BuildList();
		 printlist(remove(head));


	}

}
