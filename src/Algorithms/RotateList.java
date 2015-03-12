package Algorithms;

public class RotateList {

	public static void main(String[] args){
		ListNode l1= new ListNode(1);
		ListNode l2= new ListNode(2);
		//ListNode l3= new ListNode(3);
		//ListNode l4= new ListNode(4);
		//ListNode l5= new ListNode(5);
		l1.next=l2;
		l2.next=null;
		//l3.next=l4;
		//l4.next=l5;
		//l5.next=null;
		RotateList helper = new RotateList();
		ListNode res = helper.rotateRight(l1, 2);
		System.out.println(res.val);
	}
	
	public ListNode rotateRight(ListNode head, int n) {
		if(head==null || head.next==null || n<=0){
			return head;
		}
		ListNode front = head;
		ListNode behind = head;
		
		int diff=0;
		while(front!=null && diff<n){
			front=front.next;
			diff++;
		}
		if(front==null){//n is bigger than length of list, better take %, good for performance
			n %=diff;
			front=head;
			diff=0;
			while(front!=null && diff<n){
				front=front.next;
				diff++;
			}
		}
		
		//move front to last 
		while(front.next!=null){
			front=front.next;
			behind=behind.next;
		}
		
		//the order of these 3 steps could be tricky
		front.next=head; //since front and behind could be same; so if put this line at last, it will be impacted by null from third step.
		//these two are easy to understand.
		ListNode head2=behind.next; //first point to behind.next
		behind.next=null; //then revise it to null
		return head2;
	}
}
