

public class LinkedListCycle {

	public boolean hasCycle(ListNode head) {
		if(head==null || head.next==null){
			return false;
		}
		ListNode walker=head;
		ListNode runner=head;
		while(runner.next!=null && runner.next.next!=null){ //this condition is important: 
															//1) verify before you evaluate the expression, similar with Value_Max
															//2) next and next.next both need to evaluate, and in order
			runner=runner.next.next;
			walker=walker.next;
			if(walker==runner){
				return true;
			}
		}
		return false;
	}
}
