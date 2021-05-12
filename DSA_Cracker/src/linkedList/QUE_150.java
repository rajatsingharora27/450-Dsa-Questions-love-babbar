
// This is the right code


//package linkedList;
//
//public class QUE_150 {
//
//	public static int getLength(Node head){
//        Node cur=head;
//        int count=0;
//        while(cur!=null){
//            count++;
//            cur=cur.next;
//        }
//        return count;
//    }
//    
//    public static Node newPos(Node head,int diff){
//        
//        Node cur=head;
//        int c=0;
//        while(c<diff){
//            cur=cur.next;
//            c++;
//        }
//        
//        return cur;
//    }
//    
//    
//	int intersectPoint(Node head1, Node head2)
//	{
//         // code here
//         
//         // finding length of both linked list
//         
//         Node cur1=head1;
//         Node cur2=head2;
//         
//         int len_of_LL1=getLength(head1);
//         int len_of_LL2=getLength(head2);
//         
//         int diff=0;
//         
//        if(len_of_LL1>len_of_LL2){
//            diff=len_of_LL1-len_of_LL2; 
//            cur1=newPos(cur1,diff);
//        }
//        else{
//            diff=len_of_LL2-len_of_LL1;
//            cur2=newPos(cur2,diff);
//        }
//         
//        while(cur1!=cur2){
//            cur1=cur1.next;
//            cur2=cur2.next;
//        }
//         
//         return cur1.data;
//	}
//	
//	
//	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
//
//}
