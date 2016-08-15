/**
 * Created by yuhuazh on 8/12/2016.
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if(head==null||head.next==null) return head;
        ListNode small= new ListNode(0);
        ListNode big= new ListNode(0);
        ListNode pre1=small;
        ListNode pre2=big;
        ListNode cur=head;
        while(cur!=null){
            ListNode nt=cur.next;
            cur.next=null;
            if(cur.val<x){
                pre1.next=cur;
                pre1=pre1.next;
            }
            else{
                pre2.next=cur;
                pre2=pre2.next;
            }
            cur=nt;
        }
        pre1.next=big.next;
        big.next=null;
        return small.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        ListNode n2 = new ListNode(1);
        head.next=n2;

        PartitionList inst = new PartitionList();
        ListNode res = inst.partition(head,2);
        System.out.println(res.val);
    }
}
