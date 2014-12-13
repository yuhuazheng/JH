package myPractice;

public class InsertionSortList {

	public static void main(String[] args){
		
		int[] values = {3,1,2,5};
		//int[] values = {1,3,3,1,3,1,3,3,2,3,2,2,1,1,1,3,2,2,1,1,2,2,2,3,3,1,1,2,2,2,1,2,1,1,2,3,3,2,2,3,2,3,2,2,2,1,1,3,2,3,3,1,1,1,2,2,1,2,2,2,2,3,1,3,1,1,1,2,1,2,2,2,1,3,2,2,2,3,3,2,3,3,1,1,2,2,1,2,1,3,2,1,3,3,1,2,1,1,1,1,1,2,1,2,2,2,2,3,3,3,1,1,3,2,1};
		ListNode list = new ListNode(values[0]);
		ListNode pre=list;
		for(int i=1; i<values.length;i++){
			ListNode cur=new ListNode(values[i]);
			pre.next=cur;
			pre = cur;
		}
		InsertionSortList sorter = new InsertionSortList();
		ListNode sorted = sorter.insertionSortList(list);
		ListNode front = sorted;
		
		while(front!=null){
			System.out.println(front.val);
			front=front.next;
		}
	}

	public ListNode insertionSortList(ListNode head) {        
		if(head==null || head.next==null){
			return head;
		}
		
		ListNode sorted = new ListNode(head.val);
		
		ListNode front = head.next;
		while(front!=null){
			sorted = insertToList(sorted,new ListNode(front.val));
			front=front.next;
		}
		return sorted;
		
	}
	
	public ListNode insertToList(ListNode sorted, ListNode data){
		if(sorted==null){
			return sorted;
		}
		
		ListNode pre = sorted;
		ListNode cur = sorted;
		int counter = 0;
		while(data.val>=cur.val){
			counter++;
			pre=cur;
			cur=cur.next;
			if(cur==null){
				break;
			}
		}
		if(counter==0){
			//insert to head
			data.next=sorted;
			sorted = data;
		}
		else{
			pre.next=data;
			data.next=cur;
		}
		return sorted;
	}
}