package Algorithms;

/**
 * Created by yuhua on 2/1/16.
 */
public class OddEvenLL {

    public ListNode oddEvenList(ListNode head) {
        if(head==null|| head.next==null || head.next.next==null) return head;

        ListNode ohead = new ListNode(0);
        ListNode ehead = new ListNode(0);
        ListNode ocur = ohead;
        ListNode onext = head;
        ListNode ecur = ehead;
        ListNode enext = head.next;
        while(onext!=null&&enext!=null){
            ocur.next=onext;
            onext=enext==null?null:enext.next;
            ocur=ocur.next;

            ecur.next=enext;
            enext=onext==null?null:onext.next;
            ecur=ecur.next;
        }
        if(onext!=null){
            ocur.next=onext;
            ocur=ocur.next;
        }
        ocur.next=ehead.next;
        if(enext!=null){
            ecur.next=enext;
            ecur=ecur.next;
        }
        ecur.next=null;
        return ohead.next;
    }
}
