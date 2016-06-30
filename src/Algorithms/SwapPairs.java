

public class SwapPairs {

	public ListNode swapPairs(ListNode head) {
		if(head==null||head.next==null){
			return head;
		}
		
		ListNode pre=null;
		ListNode cur1=head;
		ListNode cur2=head.next;
		ListNode next1=null;
		ListNode next2=null;
		do{
			if(cur1.next.next!=null){
				next1=cur1.next.next;
			}
			else{
				next1=null;
			}
			if(cur2.next!=null && cur2.next.next!=null){
				next2=cur2.next.next;
			}
			else{
				next2=null;
			}
			cur2.next=cur1;
			cur1.next=next1;
			if(pre==null){
				head=cur2;
			}
			else{
				pre.next=cur2;
			}
			pre=cur1;
			cur1=next1;
			cur2=next2;
		}while(cur1!=null && cur2!=null);

		return head;
	}
}
