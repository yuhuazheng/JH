

public class RemoveNthNodeBackwards {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(head==null|| n<0){
			return null;
		}
		ListNode runner = head;
		ListNode walker = head;
		ListNode pre = null;
		
		for(int i=0;i<n;i++){
			if(runner==null){
				return null;
			}
			runner=runner.next;
		}
		if(runner==null){
			return head.next;
		}
		while(runner!=null){
			runner=runner.next;
			pre=walker;
			walker=walker.next;
		}
		pre.next=walker.next;
		return head;
	}
}
