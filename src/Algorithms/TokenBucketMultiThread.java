import java.util.concurrent.TimeUnit;

/**
 * Created by yuhuazh on 9/9/2016.
 */
public class TokenBucketMultiThread {
    private final int capacity;
    private final int tokensPerSeconds;
    private int tokens = 0;
    private long timestamp = System.currentTimeMillis();

    public TokenBucketMultiThread(int tokensPerSec) {
        capacity = tokensPerSeconds = tokensPerSec;
    }

    public TokenBucketMultiThread(int tokensPerUnit, TimeUnit unit) {
        capacity = tokensPerSeconds = (int) (tokensPerUnit / unit.toSeconds(1L));
    }

    public synchronized boolean take() throws Exception{
        try {
            long now = System.currentTimeMillis();
            tokens += (int) ((now - timestamp) * tokensPerSeconds / 1000);
            if (tokens > capacity) tokens = capacity;
            timestamp = now;
            if (tokens < 1) return false;
            tokens--;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }


    public static void main(String[] args) throws Exception {
        //TokenBucket bucket = new TokenBucket(250, TimeUnit.MINUTES);
        TokenBucketMultiThread bucket = new TokenBucketMultiThread(4);
        client c1 = new client(1);
        client c2 = new client(2);
        c1.start();
        c2.start();
        Thread.sleep(1000L);
        for (int i = 0; i < 5; i++) {
            int t = (int) (Math.random() * 10 + 1);
            if (t > 5)
                c1.run(bucket);
            else
                c2.run(bucket);
        }
    }
}

class client extends Thread{
    private int id;

    public client(int i){
        id=i;
    }

    public void run(TokenBucketMultiThread b)throws Exception{
        System.out.println("id "+id+" running ...");
        System.out.println(b.take());
    }
}