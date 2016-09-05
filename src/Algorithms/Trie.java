
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class TrieNode {
    // Initialize your data structure here.
    
        boolean isLeaf;
        char ch;
        LinkedList<TrieNode> children;
        
        //for root
        public TrieNode(){
            ch=' ';
            isLeaf=false;
            children = new LinkedList<TrieNode>();
        }
        
        public TrieNode(char c){
            ch=c;
            isLeaf=false;
            children = new LinkedList<TrieNode>();
        }
        
        public TrieNode findChild(char c){
            if(children!=null){
                for(TrieNode n:children){
                    if(n.ch==c) return n;
                }
            }
            return null;
        }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if(search(word)) return;
        TrieNode cur = root;
        for(int i=0;i<word.length();i++){
            TrieNode temp = cur.findChild(word.charAt(i));
            if(temp==null){
                cur.children.add(new TrieNode(word.charAt(i)));
                temp = cur.findChild(word.charAt(i));
            }
            cur=temp;
        }
        cur.isLeaf=true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode cur = root;
        for(int i=0;i<word.length();i++){
            TrieNode temp = cur.findChild(word.charAt(i));
            if(temp==null) return false;
            cur=temp;
        }
        return cur.isLeaf;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(int i=0;i<prefix.length();i++){
            TrieNode temp = cur.findChild(prefix.charAt(i));
            if(temp==null) return false;
            cur=temp;
        }
        //strictly exclude the word itself
        return cur.children!=null&&cur.children.size()>0;
        //or a word can be thought as its own prefix
        //return true;
    }

    public static void main(String[] args) {
        String[] strs = {"a","ab","dogcat","dog", "hello","he"};
        List<String> res = new ArrayList<>();
        Trie inst = new Trie();
        for(String s: strs)
            inst.insert(s);
        for(String s: strs){
            if(inst.startsWith(s))
                res.add(s);
        }
        for(String s: res)
            System.out.println(s);
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");