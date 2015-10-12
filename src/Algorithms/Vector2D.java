package Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yuhuazh on 10/11/2015.
 */
public class Vector2D {
    int[] indics;
    List<List<Integer>> data;

    public Vector2D(List<List<Integer>> vec2d) {
        data=vec2d;
        indics = new int[2];
        indics[0]=-1;
        indics[1]=-1;
    }

    public int next() {
        return data.get(indics[0]).get(indics[1]);
    }

    public boolean hasNext() {
        int x=indics[0];
        int y=indics[1];
        if(x==-1&&y==-1){
            return findNext(data,0,0,indics);
        }
        return findNext(data, x, y + 1, indics);
    }

    private boolean findNext(List<List<Integer>> data, int x, int y, int[] indics){
        int r=data.size();
        if(x>=r) return false;
        List<Integer> curRow = data.get(x);
        int c=data.get(x).size();
        if(y<c){
            indics[0]=x;
            indics[1]=y;
            return true;
        }

        x++;
        y=0;
        if(x>=r) return false;
        curRow = data.get(x);
        while(x<r && curRow.size()==0){
            x++;
            if(x>=r) return false;
            curRow=data.get(x);
        }
        indics[0]=x;
        indics[1]=y;
        return true;
    }

    public static void main(String[] args){
        List<List<Integer>> vec2d = new ArrayList<>();
        List<Integer> v1= new ArrayList<>();
        v1.add(1);
        v1.add(2);
        vec2d.add(v1);
        List<Integer> v2= new ArrayList<>();
        v2.add(3);
        vec2d.add(v2);
        List<Integer> v3= new ArrayList<>();
        v3.add(4);
        v3.add(5);
        vec2d.add(v3);
        Vector2D inst = new Vector2D(vec2d);
        while (inst.hasNext()) System.out.println(inst.next());
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
