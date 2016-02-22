package Algorithms;

/**
 * Created by yuhua on 2/1/16.
 */
public class OddEvenLL {

    public ListNode oddEvenList(ListNode head) {
        if(head==null|| head.next==null || head.next.next==null) return head;

        ListNode ohead = head;
        ListNode ehead = head.next;
        ListNode ocur = ohead;
        ListNode ecur = ehead;

        while(ecur!=null&&ecur.next!=null){
            ocur.next=ecur.next;
            ocur=ocur.next;

            ecur.next=ocur.next;
            ecur=ecur.next;
        }
        ocur.next=ehead;
        return ohead;
    }
}
