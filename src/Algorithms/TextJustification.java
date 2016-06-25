import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuhua on 23/06/16.
 */
public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        if(words==null||words.length==0) return res;

        List<String> cur = new ArrayList<>();
        int l=0;
        for(String w: words){
            if(w==null||w.length()==0) continue;
            int curWidth = cur.size()==0?0:l+cur.size()-1; //length of strings and minimal one space between any two words
            if(curWidth+1+w.length()<=maxWidth){
                cur.add(w);
                l+=w.length();
                continue;
            }
            String s = formatLine(cur,l,maxWidth);
            res.add(s);
            cur = new ArrayList<>();
            cur.add(w);
            l=w.length();
        }
        //lastLine
        String s = formatLastLine(cur,maxWidth);
        res.add(s);
        return res;
    }

    private String formatLine(List<String> cur, int l, int maxWidth){
        StringBuilder sb = new StringBuilder();
        if(cur.size()==0) return "";
        if(cur.size()==1){ //single word, all spaces go to right
            sb.append(cur.get(0));
            int count = cur.get(0).length();
            while(count<maxWidth) {
                sb.append(' ');
                count++;
            }
            return sb.toString();
        }





        int spaceCount = maxWidth-l;
        int spaceGroup = spaceCount/(cur.size()-1);
        int spaceResidual = spaceCount%(cur.size()-1);

        String spaceStr = "";
        for(int i=0;i<spaceGroup;i++)
            spaceStr+=" ";

        for(int i=0;i<cur.size()-1;i++){
            sb.append(cur.get(i));
            sb.append(spaceStr);
            if(spaceResidual>0){
                sb.append(" ");
                spaceResidual--;
            }
        }
        sb.append(cur.get(cur.size()-1));

        return sb.toString();
    }

    private String formatLastLine(List<String> cur, int maxWidth){
        StringBuilder sb = new StringBuilder();
        int l=0;
        for(String w: cur){
            sb.append(w);
            sb.append(' ');
            l+=w.length()+1;
        }
        if(sb.length()>0) {
            sb.deleteCharAt(sb.length() - 1);
            l--;
        }
        while(l<maxWidth) {
            sb.append(' ');
            l++;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        TextJustification inst = new TextJustification();
        String[] words ={"a"};
        int maxWidth = 2;
        List<String> res = inst.fullJustify(words,maxWidth);
        for(String s : res){
            System.out.println(s);
        }
    }
}
