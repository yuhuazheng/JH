import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yuhuazh on 6/9/2016.
 */
public class SnakeGame {

    Queue<sPoint> foodQ;
    Deque<sPoint> snake;
    int w;
    int h;

    /** Initialize your data structure here.
     @param width - screen width
     @param height - screen height
     @param food - A list of food positions
     E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {

        w=width;
        h=height;

        foodQ = new LinkedList<>();
        for(int i=0;i<food.length;i++){
            sPoint f = new sPoint(food[i][0],food[i][1]);
            foodQ.offer(f);
        }

        snake = new LinkedList<>();
        sPoint o = new sPoint(0,0);
        snake.offer(o);
    }

    /** Moves the snake.
     @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     @return The game's score after the move. Return -1 if game over.
     Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        if(snake.size()==0) return -1;
        sPoint head = snake.peek();
        sPoint d = new sPoint(head.r,head.c);
        if(direction.equals("U")){
            d.r--;
        }
        else if(direction.equals("D")){
            d.r++;
        }
        else if(direction.equals("L")){
            d.c--;
        }
        else if(direction.equals("R")){
            d.c++;
        }
        else{
            return -1;
        }

        if(d.r<0||d.r>=h||d.c<0||d.c>=w || alreadyHas(d.r,d.c) ) return -1;

        snake.addFirst(d);
        if(foodQ.size()>0 && d.r == foodQ.peek().r && d.c == foodQ.peek().c) {//eat food
                foodQ.poll();
        }
        else { //move one step
                snake.removeLast();
        }

        return snake.size()-1;
    }

    private boolean alreadyHas(int row, int col){//the last point won't be issue when whole snake move
        if(snake.size()==0) return false;
        sPoint l = snake.getLast();
        for(sPoint s : snake){
            if(s.r==row && s.c==col&& !(l.r==row && l.c==col))
                return true;
        }
        return false;
    }
}

class sPoint{
    int r;
    int c;
    public sPoint(int row,int col){
        r=row;
        c=col;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
