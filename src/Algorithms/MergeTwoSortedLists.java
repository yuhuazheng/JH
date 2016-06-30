
import java.util.List;

public class MergeTwoSortedLists {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
