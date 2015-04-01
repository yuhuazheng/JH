package Algorithms;

public class RemoveDuplicatedFromSoredListII {

	public static void main(String[] args){
		ListNode head = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		head.next=n2;
		n2.next=n3;
		
		RemoveDuplicatedFromSoredListII inst = new RemoveDuplicatedFromSoredListII();
		inst.deleteDuplicates(head);
	}
	
	public ListNode deleteDuplicates(ListNode head) {
		
		if(head==null|| head.next==null){
			return head;
		}
		
		ListNode unique = null;
		ListNode pre=null;
		ListNode cur=head;
		ListNode next=head.next;
		int count=1;
		while(next!=null){
			if(next.val!=cur.val){
				if(count==1){
					if(pre==null){
						unique=cur;
					}
					else{
						pre.next=cur;
					}
					pre=cur;
				}
				count=1;
			}
			else{
				count++;
			}
			cur=next;
			next=cur.next;
		}
		if(count==1){
			if(pre==null){
				unique=cur;
				pre=cur;
			}
			else{
				pre.next=cur;
			}
		}
		else{
			if(pre!=null){
				pre.next=null;
			}
		}
		return unique;
	}
}
