package Algorithms;

/**
 * Created by yuhua on 5/14/16.
 */
public class NextRightPointerII {
    public void connect(TreeLinkNode root) {
        if(root==null||(root.left==null&&root.right==null)) return;
        TreeLinkNode lastHead = root;
        TreeLinkNode curHead = null;
        TreeLinkNode pre = null;
        while(lastHead!=null){
            TreeLinkNode lastCur = lastHead;
            while(lastCur!=null){
                if(lastCur.left!=null){
                    if(curHead==null){
                        curHead=lastCur.left;
                        pre=curHead;
                    }
                    else{
                        pre.next=lastCur.left;
                        pre=pre.next;
                    }
                }
                if(lastCur.right!=null){
                    if(curHead==null){
                        curHead=lastCur.right;
                        pre=curHead;
                    }
                    else{
                        pre.next=lastCur.right;
                        pre=pre.next;
                    }
                }
                lastCur=lastCur.next;
            }
            lastHead=curHead;
            curHead=null;
        }
    }

}
