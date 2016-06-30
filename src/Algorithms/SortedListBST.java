
import java.util.ArrayList;

public class SortedListBST {

	public static void main(String[] args){
		ListNode head = new ListNode(1);
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(3);
		head.next=n1;
		n1.next=n2;
		SortedListBST helper = new SortedListBST();
		helper.sortedListToBST(head);
	}
	
	 public TreeNode sortedListToBST(ListNode head) {
		 if(head == null)
		        return null;
		    ListNode cur = head;
		    int count = 0;
		    while(cur!=null)
		    {
		        cur = cur.next;
		        count++;
		    }
		    ArrayList<ListNode> list = new ArrayList<ListNode>();
		    list.add(head);
		    return helper(list,0,count-1);
	}
	 
	private TreeNode helper(ArrayList<ListNode> list, int l, int r)
	{
		    if(l>r)
		        return null;
		    int m = (l+r)/2;
		    TreeNode left = helper(list,l,m-1);
		    TreeNode root = new TreeNode(list.get(0).val);
		    root.left = left;
		    //this a key step; to ensure if left is set, move forward along the list
		    list.set(0,list.get(0).next);
		    root.right = helper(list,m+1,r);
		    return root;
	}
}
