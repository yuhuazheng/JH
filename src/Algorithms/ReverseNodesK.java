package Algorithms;

public class ReverseNodesK {

	public static void main(String[] args){
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		
		ReverseNodesK inst = new ReverseNodesK();
		ListNode res = inst.reverseKGroup(n1, 2);
		while(res!=null){
			System.out.println(res.val);
			res=res.next;
		}
		
	}
	
	public ListNode reverseKGroup(ListNode head, int k) {
		if(head==null||head.next==null||k<2) return head;
		ListNode pre=null;
		ListNode nxt=null;
		ListNode start=head;
		ListNode end=null;
		ListNode cur=head;
		int count=0;
		while(cur!=null){
			count++;
			if(count==k){
				end=cur;
				nxt=cur.next;
				end.next=null; //cut off
				reverseHelper(start,end);
				if(pre==null&&end!=null){
					head=end;
				}
				else{
					pre.next=end;
				}
				start.next=nxt;
				pre=start;
				cur=nxt;
				start=cur;
				end=null;
				count=0;
			}
			else{
				cur=cur.next;
			}
		}
		return head;
	}
	
	private void reverseHelper(ListNode start, ListNode end){
		ListNode pre=start;
		ListNode cur=start.next;
		pre.next=null;
		while(cur!=null){
			ListNode temp=cur.next;
			cur.next=pre;
			pre=cur;
			cur=temp;
		}
	}
}
