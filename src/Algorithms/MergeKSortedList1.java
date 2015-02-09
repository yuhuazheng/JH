package Algorithms;

import java.util.ArrayList;
import java.util.List;

public class MergeKSortedList1 {

	public static void main(String[] args){
		List<ListNode> lists = new ArrayList<ListNode>();
		ListNode temp1 = new ListNode(0);
		ListNode temp2 = new ListNode(1);
		lists.add(temp1);
		lists.add(temp2);
		MergeKSortedList1 helper = new MergeKSortedList1();
		ListNode res=helper.mergeKLists(lists);
		while(res!=null){
			System.out.println(res.val);
			res=res.next;
		}
	}
	
	public ListNode mergeKLists(List<ListNode> lists) {
		if(lists==null||lists.size()<1){
			return null;
		}
		return mergeRange(lists,0,lists.size()-1);
	}
		
	public ListNode mergeRange(List<ListNode> lists, int l, int r){
		if(l<r){
			int m=(l+r)/2;
			return merge2Lists(mergeRange(lists,l,m),mergeRange(lists,m+1,r));
		}
		return lists.get(l);
	}
	
	public ListNode merge2Lists(ListNode l1,ListNode l2){
		if(l1==null&&l2==null){
			return null;
		}
		
		ListNode head = new ListNode(0);
		head.next=l1; //this line actually guarantees when l2==null, function will gets started
		              //since cur=head, so if l2<l1, l2 will be inserted.
		ListNode cur = head;
		ListNode next = head;
		//insert l2 into l1
		while(l1!=null&&l2!=null){
			if(l1.val>l2.val){
				next=l2.next;
				cur.next=l2;
				cur=cur.next;
				cur.next=l1;
				l2=next;
			}
			else{
				cur.next=l1;
				l1=l1.next;
				cur=cur.next;
			}
		}
		if(l2!=null){
			cur.next=l2;
		}
		return head.next;
	}
}
