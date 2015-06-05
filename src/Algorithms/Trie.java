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
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");