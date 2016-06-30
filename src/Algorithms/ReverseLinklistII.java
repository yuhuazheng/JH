
public class ReverseLinklistII {

	public static void main(String[] args){
		ListNode head = new ListNode(1);
		ListNode n2 = new ListNode(2);
		//ListNode n3 = new ListNode(3);
		//ListNode n4 = new ListNode(4);
		//ListNode n5 = new ListNode(5);
		head.next=n2;
		//n2.next = n3;
		//n3.next = n4;
		//n4.next = n5;
		ReverseLinklistII helper = new ReverseLinklistII();
		head=helper.reverseBetween(head, 1, 2);
		while(head!=null){
			System.out.print(head.val);
			head=head.next;
		}
	}
	
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if(head==null || head.next==null){
			return head;
		}
		
		ListNode left=head;
		ListNode tail=head;
		ListNode pre=null;
		ListNode cur=head;
		ListNode nt=head.next;
		int count=1;
		
		while(count<m && nt!=null){
			count++;
			pre=cur;
			cur=nt;
			nt=nt.next;
		}
		
		left=pre;
		tail=cur;
		pre=null;
		while(count<n && cur!=null){
			cur.next=pre;
			pre=cur;
			cur=nt;
			nt=nt.next;
			count++;
		}
		cur.next=pre;
		
		if(left==null){
			head=cur;
		}
		else{
			left.next=cur;
		}
		tail.next=nt;
		return head;
	}
}
