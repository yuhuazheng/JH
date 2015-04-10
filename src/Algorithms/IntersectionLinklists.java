package Algorithms;

public class IntersectionLinklists {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA==null || headB==null){
			return null;
		}
		
		ListNode idxA=headA;
		ListNode idxB=headB;
		int count=4;
		while(idxA!=idxB&&count>0){
			idxA=idxA.next;
			idxB=idxB.next;
			if(idxA==null){
				idxA=headB;
				count--;
			}
			if(idxB==null){
				idxB=headA;
				count--;
			}
		}
		if(idxA==idxB){
			return idxA;
		}
		else{
			return null;
		}
		
	}
}
