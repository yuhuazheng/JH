

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedList2 {

	public static void main(String[] args){
		List<ListNode> lists = new ArrayList<ListNode>();
		ListNode temp1 = new ListNode(0);
		ListNode temp2 = new ListNode(1);
		lists.add(temp1);
		lists.add(temp2);
		MergeKSortedList2 helper = new MergeKSortedList2();
		ListNode res=helper.mergeKLists(lists);
		while(res!=null){
			System.out.println(res.val);
			res=res.next;
		}
	}
	
	public ListNode mergeKLists(List<ListNode> lists) {
		PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(10,new NodeComparator());
    
		//get 1st of each list into heap
		for(int i=0;i<lists.size();i++)
		{
			ListNode node = lists.get(i); 
			if(node!=null)
			{
				heap.offer(node);
			}
		}
		
		ListNode head = null;
		ListNode pre = head;
		while(heap.size()>0)
		{
			//get minimum
			ListNode cur = heap.poll();
			if(head == null)
			{
				head = cur;
				pre = head;
			}
			else
			{
				pre.next = cur;
			}
			pre = cur;
			if(cur.next!=null){
				//add next element in this list
				heap.offer(cur.next);
			}
		}
		return head;
	}
	
	class NodeComparator implements Comparator<ListNode>{
		@Override
		public int compare(ListNode n1, ListNode n2){
			return n1.val-n2.val;
		}
	}
}
