

/**
 * this can't be empty
 * Created by yuhua on 8/17/15.
 */
public class PalindromeLinkedList {

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next=new ListNode(2);
        PalindromeLinkedList inst = new PalindromeLinkedList();
        System.out.println(inst.isPalindrome(head));
    }

    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) return true;

        ListNode walker=head;
        ListNode runner=head;
        while(runner!=null&&runner.next!=null){
            walker=walker.next;
            runner=runner.next.next;
        }
        //even number if runner=null; odd number otherwise
        if(runner!=null) {
            walker = walker.next;
        }

        //reverse 2nd half
        ListNode pre=null;
        ListNode cur=walker;
        while(cur!=null){
            ListNode nt=cur.next;
            cur.next=pre;
            pre=cur;
            cur=nt;
        }

        ListNode idx1=head;
        ListNode idx2=pre;
        while(idx2!=null){
            if(idx1.val!=idx2.val)
                return false;
            idx1=idx1.next;
            idx2=idx2.next;
        }
        return true;
    }
}
