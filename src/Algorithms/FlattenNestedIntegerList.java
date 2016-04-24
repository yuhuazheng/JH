package Algorithms;

/**
 * Created by yuhuazh on 4/23/2016.
 */

import java.util.Iterator;
import java.util.Stack;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
/*public class NestedIterator implements Iterator<Integer> {

    Stack<NestedInteger> s = new Stack<>();;

    public NestedIterator(List<NestedInteger> nestedList) {
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            s.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        NestedInteger t = s.pop();
        return t.getInteger();
    }

    //key is a valid next has to be an integer, not a list.
    //so hasNext() should keep depth-first-search to find the first valid integer
    @Override
    public boolean hasNext() {
        while (!s.isEmpty()) {
            NestedInteger t = s.peek();
            if (t.isInteger()) return true;
            t=s.pop();
            for (int i = t.getList().size() - 1; i >= 0; --i) {
                s.push(t.getList().get(i));
            }
        }
        return false;
    }

}*/

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
