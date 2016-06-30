
public class AddTwoNumbers {

	public static void main(String[] args){
		ListNode l1= new ListNode(0);
		ListNode l2= new ListNode(0);
		AddTwoNumbers helper = new AddTwoNumbers();
		ListNode res = helper.addTwoNumbers(l1, l2);
		while(res!=null){
			System.out.println(res.val);
			res=res.next;
		}
	}
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(l1==null&&l2==null){
			return null;
		}
		ListNode res= new ListNode(0);
		ListNode head = res;
		if(l1==null){
			res=l2;
		}
		else if(l2==null){
			res=l1;
		}
		else{
			res.val = (l1.val+l2.val)%10;
			int carry= (l1.val+l2.val)/10;
			l1=l1.next;
			l2=l2.next;
			while(l1!=null&&l2!=null){
				int residual = l1.val+l2.val+carry;
				carry = residual/10;
				residual = residual%10;
				ListNode cur = new ListNode(residual);
				res.next=cur;
				res=res.next;
				l1=l1.next;
				l2=l2.next;
			}
			while(l1!=null){
				int residual = l1.val+carry;
				carry = residual/10;
				residual = residual%10;
				ListNode cur = new ListNode(residual);
				res.next=cur;
				res=res.next;
				l1=l1.next;
			}
			while(l2!=null){
				int residual = l2.val+carry;
				carry = residual/10;
				residual = residual%10;
				ListNode cur = new ListNode(residual);
				res.next=cur;
				res=res.next;
				l2=l2.next;
			}
			if(carry>0){
				ListNode cur = new ListNode(carry);
				res.next=cur;
				res=res.next;
			}
		}
		return head.next;
	}
}
