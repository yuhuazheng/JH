package Algorithms;

public class InsertionSortList {

	public static void main(String[] args){
		
		int[] values = {1,1};
		//int[] values = {1,3,3,1,3,1,3,3,2,3,2,2,1,1,1,3,2,2,1,1,2,2,2,3,3,1,1,2,2,2,1,2,1,1,2,3,3,2,2,3,2,3,2,2,2,1,1,3,2,3,3,1,1,1,2,2,1,2,2,2,2,3,1,3,1,1,1,2,1,2,2,2,1,3,2,2,2,3,3,2,3,3,1,1,2,2,1,2,1,3,2,1,3,3,1,2,1,1,1,1,1,2,1,2,2,2,2,3,3,3,1,1,3,2,1};
		ListNode list = new ListNode(values[0]);
		ListNode pre=list;
		for(int i=1; i<values.length;i++){
			ListNode cur=new ListNode(values[i]);
			pre.next=cur;
			pre = cur;
		}
		InsertionSortList sorter = new InsertionSortList();
		ListNode front = sorter.insertionSortList(list);
		
		while(front!=null){
			System.out.println(front.val);
			front=front.next;
		}
	}

	public ListNode insertionSortList(ListNode head) {
		if(head==null || head.next==null){
			return head;
		}

		ListNode sHead = new ListNode(0);
		ListNode cur = head;

		while(cur!=null){
			ListNode nt = cur.next;
			insertToList(sHead,cur);
			cur=nt;
		}
		return sHead.next;

	}

	public void insertToList(ListNode sHead, ListNode cur){
		if(sHead.next==null){
			sHead.next=cur;
			cur.next=null;
			return;
		}

		ListNode sPre = sHead;
		ListNode sCur = sHead.next;
		while(sCur!=null && cur.val>sCur.val){
			sPre=sCur;
			sCur=sCur.next;
		}
		if(sCur==null){
			//insert to end
			sPre.next=cur;
			cur.next=null;
		}
		else{
			sPre.next=cur;
			cur.next=sCur;
		}
	}
}