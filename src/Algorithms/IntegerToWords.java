import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuhua on 30/06/16.
 */
public class IntegerToWords {
    public String numberToWords(int num) {
        if(num==0) return "Zero";
        List<Integer> values = new ArrayList<>();
        while(num>0){
            int temp = num%1000;
            values.add(0,temp);
            num=num/1000;
        }
        String res="";

        String[] levels = {"Billion","Million","Thousand"};
        int n = values.size();
        int offset = 4-n;
        int i=0;
        while(i<n){
            int v = values.get(i++);
            if(v==0){
                offset++;
                continue;
            }

            String str = convertChunk(v);
            if(offset>=0&&offset<levels.length){
                str+=" ";
                str+=levels[offset++];
            }
            if(res.isEmpty()){
                res=str;
            }
            else{
                res+=" ";
                res+=str;
            }
        }
        return res;
    }

    private String convertChunk(int v){
        String str="";
        if(v==0) return str;
        int high=0;
        int mid=0;

        if(v>99){
            high = v/100;
            v=v%100;
            switch (high) {
                case 9:
                    str += "Nine";
                    break;
                case 8:
                    str += "Eight";
                    break;
                case 7:
                    str += "Seven";
                    break;
                case 6:
                    str += "Six";
                    break;
                case 5:
                    str += "Five";
                    break;
                case 4:
                    str += "Four";
                    break;
                case 3:
                    str += "Three";
                    break;
                case 2:
                    str += "Two";
                    break;
                case 1:
                    str += "One";
                    break;
            }
            str+=" ";
            str+="Hundred";
        }
        if(v>9){
            mid = v/10;
            v=v%10;
            if(str.length()>0)
                str+=" ";
            switch (mid) {
                case 9:
                    str += "Ninety";
                    break;
                case 8:
                    str += "Eighty";
                    break;
                case 7:
                    str += "Seventy";
                    break;
                case 6:
                    str += "Sixty";
                    break;
                case 5:
                    str += "Fifty";
                    break;
                case 4:
                    str += "Forty";
                    break;
                case 3:
                    str += "Thirty";
                    break;
                case 2:
                    str += "Twenty";
                    break;
                case 1:
                    mid=10;
                    break;
            }
        }
        if(mid==10){
            switch(v){
                case 9:
                    str += "Nineteen";
                    break;
                case 8:
                    str += "Eighteen";
                    break;
                case 7:
                    str += "Seventeen";
                    break;
                case 6:
                    str += "Sixteen";
                    break;
                case 5:
                    str += "Fifteen";
                    break;
                case 4:
                    str += "Fourteen";
                    break;
                case 3:
                    str += "Thirteen";
                    break;
                case 2:
                    str += "Twelve";
                    break;
                case 1:
                    str += "Eleven";
                    break;
                case 0:
                    str += "Ten";
                    break;
            }
        }
        else if(v>0){
            if(str.length()>0&& str.charAt(str.length()-1)!=' '){
                str+=" ";
            }
            switch(v) {
                case 9:
                    str += "Nine";
                    break;
                case 8:
                    str += "Eight";
                    break;
                case 7:
                    str += "Seven";
                    break;
                case 6:
                    str += "Six";
                    break;
                case 5:
                    str += "Five";
                    break;
                case 4:
                    str += "Four";
                    break;
                case 3:
                    str += "Three";
                    break;
                case 2:
                    str += "Two";
                    break;
                case 1:
                    str += "One";
                    break;
            }
        }

        return str;
    }

    public static void main(String[] args) {
        IntegerToWords inst = new IntegerToWords();
        System.out.println(inst.numberToWords(12345));
    }
}
