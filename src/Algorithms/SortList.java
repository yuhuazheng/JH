

public class SortList {

	public ListNode sortList(ListNode head) {
		
		if(head==null || head.next==null){
			return head;
		}
		ListNode walker = head;
		ListNode runner = head;
		//runner is always faster than walker
		while(runner.next!=null && runner.next.next!=null){
			walker = walker.next;
			runner = runner.next.next;
		}
		ListNode head2 = walker.next;
		walker.next=null;
		ListNode head1 = head;
		head1=sortList(head1);
		head2=sortList(head2);
		return mergeTow(head1,head2);
	}
	
	private ListNode mergeTow(ListNode l1, ListNode l2) {
		if(l1==null && l2==null){
			return null;
		}
		if(l1==null){
			return l2;
		}
		if(l2==null){
			return l1;
		}
		ListNode helper = new ListNode(-1);
		helper.next=l1;
		ListNode pre=helper;
		while(l1!=null&&l2!=null){
			//insert l2 into l1
			if(l2.val<l1.val){
				ListNode next = l2.next;
				l2.next=pre.next;
				pre.next=l2;
				l2=next;
			}
			else{
				l1=l1.next;
			}
			pre=pre.next;
		}
		if(l2!=null){
			pre.next=l2;
		}
		return helper.next;
	}
}
