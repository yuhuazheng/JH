import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
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

    public synchronized boolean take() {
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
        TokenBucketMultiThread bucket = new TokenBucketMultiThread(3);
        Thread.sleep(1000L);
        ExecutorService clientPool = Executors.newFixedThreadPool(5);
        for(int i=0;i<5;i++){
            client c = new client(i,bucket);
            clientPool.execute(c);
        }
        clientPool.shutdown();
    }
}

class client extends Thread{
    private int id;
    private TokenBucketMultiThread b;

    public client(int i,TokenBucketMultiThread tb){
        id=i;
        b=tb;
    }

    @Override
    public void run(){
        System.out.println("id "+id+" running ...");
        System.out.println(b.take());
    }
}