
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class LRUcache {

	class DLNode{
		int key;
		int val;
		DLNode pre,next;
		public DLNode(int k, int v){
			key=k;
			val=v;
		}
	}

	int capacity;
	int count;
	HashMap<Integer,DLNode> cacheMap;
	DLNode first,last;
	
    public LRUcache(int capacity) {
    
		this.capacity = capacity;
		count=0;
		cacheMap = new HashMap<Integer,DLNode>();
    	first=null;
    	last=null;
    }
    
    public int get(int key) {
        DLNode n = cacheMap.get(key);
		if(n==null)
        	return -1;
		else if(n!=last){ //should move n
			if(n==first)
				first=first.next;
			else
				n.pre.next=n.next;
			n.next.pre=n.pre;
			last.next=n;
			n.pre=last;
			n.next=null;
			last=n;
		}
		return n.val;
    }
    
    public void set(int key, int value) {
    	DLNode n = cacheMap.get(key);
		if(n!=null){
			n.val=value;
			if(n!=last){ //should move n
				if(n==first)
					first=first.next;
				else
					n.pre.next=n.next;
				n.next.pre=n.pre;
				last.next=n;
				n.pre=last;
				n.next=null;
				last=n;
			}
    	}
    	else{

			DLNode nn = new DLNode(key,value);

			if(count>=capacity){
				cacheMap.remove(first.key);
				first=first.next;
				if(first!=null)
					first.pre=null;
				else
					last=null;
				count--;
			}
			if(first==null || last==null)
				first = nn;
			else
				last.next=nn;
			nn.pre=last;
			last=nn;
			cacheMap.put(key,nn);
			count++;
        }
    }

}
