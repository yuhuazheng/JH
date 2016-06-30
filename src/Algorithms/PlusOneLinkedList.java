/**
 * Created by yuhua on 29/06/16.
 */
public class PlusOneLinkedList {
    public ListNode plusOne(ListNode head) {
        if(head==null){
            ListNode n = new ListNode(1);
            return n;
        }
        if(head.next==null){
            if(head.val==9){
                ListNode n = new ListNode(1);
                n.next=head;
                head.val=0;
                return n;
            }
            else{
                head.val+=1;
                return head;
            }
        }

        ListNode n = reverseList(head);
        int carry=1;
        ListNode cur = n;
        while(cur!=null){
            int temp = cur.val+carry;
            cur.val = temp%10;
            carry = temp/10;
            if(carry==0)
                break;
            cur=cur.next;
        }
        head = reverseList(n);
        if(carry>0){
            cur= new ListNode(1);
            cur.next=head;
            head=cur;
        }

        return head;
    }

    private ListNode reverseList(ListNode head){
        ListNode pre=null;
        ListNode cur=head;
        ListNode nt;
        while(cur!=null){
            nt=cur.next;
            cur.next=pre;
            pre=cur;
            cur=nt;
        }
        return pre;
    }
}
