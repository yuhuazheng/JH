package Algorithms;

/**
 * Created by yuhua on 3/30/16.
 */
public class AdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        if(num==null||num.length()==0) return false;
        for(int i=1;i<num.length()-1;i++){
            String str1 = num.substring(0,i);
            if(str1.charAt(0)=='0'&&str1.length()>1) continue;
            long n1=0;
            try{
                n1=Long.parseLong(str1);
            }catch(NumberFormatException e){
                System.out.println("n1 beyond max integer, break");
                break;
            }
            for(int j=i+1;j<num.length();j++){
                String str2 = num.substring(i,j);
                if(str2.charAt(0)=='0'&&str2.length()>1) continue;
                long n2=0;
                try{
                    n2=Long.parseLong(str2);
                }catch(NumberFormatException e){
                    System.out.println("n2 beyond max integer, break");
                    break;
                }
                if(helper(n1,n2,j,num))
                    return true;
            }
        }
        return false;
    }

    private boolean helper(long n1, long n2, int start, String num){
        if(start==num.length()) return true;
        for(int k=start+1;k<=num.length();k++){
            String str3 = num.substring(start,k);
            if(str3.charAt(0)=='0'&&str3.length()>1) continue;
            long n3=0;
            try{
                n3=Long.parseLong(str3);
            }catch(NumberFormatException e){
                System.out.println("n3 beyond max integer, break");
                break;
            }
            if(n1+n2==n3 && helper(n2,n3,k,num))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        AdditiveNumber inst = new AdditiveNumber();
        String num = "121474836472147483648";
        System.out.println(inst.isAdditiveNumber(num));
    }
}
