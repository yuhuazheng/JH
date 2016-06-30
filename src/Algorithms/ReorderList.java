

public class ReorderList {

	public static void main(String[] args){
		ListNode head = new ListNode(1);
		ListNode n2 = new ListNode(2);
		head.next=n2;
		ReorderList helper = new ReorderList();
		helper.reorderList(head);
	}
	
	public void reorderList(ListNode head) {
		if(head==null || head.next==null){
			return;
		}
		
		ListNode walker = head;
		ListNode runner = head;
		while(runner.next!=null && runner.next.next!=null){
			walker = walker.next;
			runner = runner.next.next;
		}
		if(runner.next!=null){
			runner = runner.next; //the end of the second half
		}
		ListNode end1=walker; //the end of the new list
		walker = walker.next; //the head of the second half
		end1.next=null;
		
		//reverse the second half
		ListNode pre = null;
		while(walker.next!=null){
			ListNode temp = walker.next;
			walker.next=pre;
			pre=walker;
			walker=temp;
		}
		walker.next=pre;
		
		//insert to first half
		runner=head;
		while(runner!=null && walker !=null){
			ListNode toInsert = walker;
			walker = walker.next;
			ListNode next = runner.next;
			runner.next=toInsert;
			runner = runner.next;
			runner.next=next;
			runner = runner.next;
		}
	}
}
