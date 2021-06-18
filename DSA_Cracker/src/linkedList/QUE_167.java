package linkedList;

import java.util.Scanner;

public class QUE_167 {

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



	public static LinkedListNode<Integer> sort(LinkedListNode<Integer> head){

		LinkedListNode<Integer> zero=new LinkedListNode<Integer>(-1);
		LinkedListNode<Integer> one=new LinkedListNode<Integer>(-1);
		LinkedListNode<Integer> two=new LinkedListNode<Integer>(-1);
		LinkedListNode<Integer> zeroD=null;
		LinkedListNode<Integer> oneD=null;
		LinkedListNode<Integer> twoD=null;
		LinkedListNode<Integer> cur=head;

		while(cur!=null) {

			if(cur.data==0) {

				if(zeroD==null){
					zeroD=cur;
				}
				zero.next=cur;	
				zero=cur;
			}

			else if(cur.data==1) {

				if(oneD==null){
					oneD=cur;
				}
				one.next=cur;	
				one=cur;
			}

			else {

				if(twoD==null){
					twoD=cur;
				}
				two.next=cur;
				two=cur;
			}
			cur=cur.next;
		}
		one.next=null;
		zero.next=null;
		two.next=null;

		
		//zero.next=(oneD!=null)?twoD:oneD;
		
		if(oneD==null) {
			zero.next=twoD;
			return zeroD;
		}
		zero.next=oneD;
		one.next=twoD;
		return zeroD;

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
		printlist(sort(head));

	}

}
