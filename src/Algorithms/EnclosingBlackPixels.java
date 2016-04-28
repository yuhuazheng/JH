package Algorithms;

import java.util.Arrays;
import java.util.List;

/**
 * Created by yuhuazh on 4/27/2016.
 */
public class EnclosingBlackPixels {
    public int minArea(char[][] image, int x, int y) {
        if(image==null||image.length==0||image[0].length==0) return 0;

        int row=image.length;
        int col=image[0].length;
        char[][] imageTran = new char[col][row];
        //clock-wise 90 degree
        for(int i=row-1;i>=0;i--){
            for(int j=0;j<col;j++){
                imageTran[j][row-1-i]=image[i][j];
            }
        }

        int minCol=searchRowMin(imageTran, y);
        int maxCol=searchRowMax(imageTran, y);
        int minRow=searchRowMin(image, x);
        int maxRow=searchRowMax(image, x);

        return (maxRow-minRow+1)*(maxCol-minCol+1);
    }

    private int searchRowMin(char[][] image, int x){
        int l=0;
        int r=x;
        while(l<=r){
            int m= (l+r)/2;
            char[] cur = image[m];
            boolean hasOne = false;
            for(char c : cur){
                if(c=='1') {
                    hasOne = true;
                    break;
                }
            }
            if(hasOne){
                r=m-1;
            }
            else{
                l=m+1;
            }
        }
        return r+1;
    }

    private int searchRowMax(char[][] image, int x){
        int l=x;
        int r=image.length-1;
        while(l<=r){
            int m= (l+r)/2;
            char[] cur = image[m];
            boolean hasOne = false;
            for(char c : cur){
                if(c=='1') {
                    hasOne = true;
                    break;
                }
            }
            if(hasOne){
                l=m+1;
            }
            else{
                r=m-1;
            }
        }
        return l-1;
    }

    public static void main(String[] args) {
        EnclosingBlackPixels inst = new EnclosingBlackPixels();
        char[][] image = {
                {'0','0','0'},
                {'0','1','0'},
                {'1','1','0'},
                        };
        System.out.println(inst.minArea(image,1,1));
    }
}
