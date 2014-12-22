package myPractice;

public class SortLinkList {

	public static void main(String[] args){
		//int[] values = {4,3,1,2,8,7,6,9,5};
		int[] values = {1,3,3,1,3,1,3,3,2,3,2,2,1,1,1,3,2,2,1,1,2,2,2,3,3,1,1,2,2,2,1,2,1,1,2,3,3,2,2,3,2,3,2,2,2,1,1,3,2,3,3,1,1,1,2,2,1,2,2,2,2,3,1,3,1,1,1,2,1,2,2,2,1,3,2,2,2,3,3,2,3,3,1,1,2,2,1,2,1,3,2,1,3,3,1,2,1,1,1,1,1,2,1,2,2,2,2,3,3,3,1,1,3,2,1};
		ListNode list = new ListNode(values[0]);
		ListNode pre=list;
		for(int i=1; i<values.length;i++){
			ListNode cur=new ListNode(values[i]);
			pre.next=cur;
			pre = cur;
		}
		SortLinkList sorter = new SortLinkList();
		ListNode sorted = sorter.sortList(list);
		ListNode front = sorted;
		while(front!=null){
			System.out.println(front.val);
			front=front.next;
		}
	}
	
	
	public ListNode sortList(ListNode head) {
		if(head==null || head.next==null){
			return head;
		}
		
		ListNode tail = head;
		while(tail.next!=null){
			tail=tail.next;
		}
		
		return binarySortList(head,tail).head;
	}
	
	public NodePair binarySortList(ListNode head, ListNode tail){
		//single item
		if(head==null || head.next ==null ){
			return new NodePair(head,head);
		}
		//two items
		if(head.next == tail){
			if(head.val>tail.val){
				int temp=head.val;
				head.val = tail.val;
				tail.val=temp;
			}
			return new NodePair(head,tail);
		}
		
		//multiple items
		ListNode lefthead = head;
		ListNode lefttail = head;
		ListNode righthead = head;
		ListNode righttail = head;
		int leftcounter =0;
		int rightcounter =0;
		
		ListNode pivot = head;
		int value = pivot.val;
		ListNode tailLink = tail.next;
		ListNode front = head.next;
		
		while(front!=null){
			if(front.val<=value){
				if(leftcounter <=0){
					lefthead=front;
					leftcounter=1;
					head.next = lefthead;
					front = front.next;
					lefttail=lefthead;
					lefttail.next=null;
				}
				else{
					lefttail.next = front;
					front = front.next;
					lefttail = lefttail.next;
					lefttail.next = null;
				}
			}
			else{
				if(rightcounter<=0){
					righthead=front;
					rightcounter=1;
					front = front.next;
					righttail=righthead;
					righttail.next=null;
				}
				else{
					righttail.next = front;
					front = front.next;
					righttail = righttail.next;
					righttail.next = null;
				}
			}
		}
		
		if(leftcounter>0){
			NodePair leftpair = binarySortList(lefthead,lefttail);
			head = leftpair.head;
			leftpair.tail.next=pivot;
		}
		pivot.next=tailLink;
		tail=pivot;
		
		if(rightcounter>0){
			NodePair rightpair = binarySortList(righthead,righttail);
			pivot.next= rightpair.head;
			tail = rightpair.tail;
			tail.next=tailLink;
		}
		return new NodePair(head,tail);
	}
		
}

class NodePair {
	ListNode head;
	ListNode tail;
	
	NodePair(ListNode nd1,ListNode nd2){
		head=nd1;
		tail=nd2;
	}
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}