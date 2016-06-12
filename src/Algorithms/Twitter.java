import java.util.*;

/**
 * Created by yuhua on 11/06/16.
 */
public class Twitter {

    HashMap<Integer, List<tweet>> tweetMap;
    HashMap<Integer, HashSet<Integer>> followMap;
    int twIdx=0;

    /** Initialize your data structure here. */
    public Twitter() {
        tweetMap = new HashMap<>();
        followMap = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if(!tweetMap.containsKey(userId)){
            tweetMap.put(userId,new ArrayList<tweet>());
        }
        tweetMap.get(userId).add(0, new tweet(tweetId,twIdx++)); //newest at front
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<tweet> res = new PriorityQueue<>( new tweetComparator());
        if(tweetMap.containsKey(userId) && tweetMap.get(userId)!= null && tweetMap.get(userId).size()>0){ //get user own tweets
            for(tweet t : tweetMap.get(userId)){ //tweets are ordered with newest first
                if(res.size()<10)
                    res.offer(t);
            }
        }
        if(followMap.containsKey(userId) && followMap.get(userId)!=null && followMap.get(userId).size()>0){ //get followee's tweets
            for(int u : followMap.get(userId)){
                if(tweetMap.containsKey(u) && tweetMap.get(u)!= null && tweetMap.get(u).size()>0) {
                    for (tweet t : tweetMap.get(u)) { //tweets are ordered with newest first
                        if (res.size() < 10)
                            res.offer(t);
                        else {
                            if (t.idx < res.peek().idx) { //this user's other tweets are older than res, stop on this user
                                break;
                            } else {
                                res.poll();
                                res.offer(t);
                            }
                        }
                    }
                }
            }
        }
        List<Integer> op = new ArrayList<Integer>();
        while(!res.isEmpty()) {
            op.add(0, res.poll().val);
        }
        return op;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(followeeId==followerId) return;
        if(!followMap.containsKey(followerId)){
            followMap.put(followerId, new HashSet<Integer>());
        }
        followMap.get(followerId).add(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(followeeId==followerId) return;
        if(followMap.containsKey(followerId) && followMap.get(followerId)!=null && followMap.get(followerId).contains(followeeId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }

    public static void main(String[] args) {
        Twitter inst  = new Twitter();
        inst.postTweet(1, 5);
        inst.postTweet(1, 3);
        inst.postTweet(1, 101);
        inst.postTweet(1, 13);
        inst.postTweet(1, 10);
        inst.postTweet(1, 2);
        inst.postTweet(1, 94);
        inst.postTweet(1, 505);
        inst.postTweet(1, 333);
        inst.getNewsFeed(1);
    }
}

class tweet {
    int val;
    int idx;

    public tweet(int v, int i) {
        val = v;
        idx = i;
    }
}

class tweetComparator implements Comparator<tweet>{
    @Override
    public int compare(tweet o1, tweet o2) { //earlier tweet will be at front. so min heap.
        int r = o1.idx-o2.idx;
        return r;
    }
}
/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
