package Algorithms;

import java.util.LinkedList;

public class WordDictionary {
	TrieNode root;
	
	public WordDictionary(){
		root = new TrieNode();
	}
	
	// Adds a word into the data structure.
    public void addWord(String word) {
        //if(search(word)) return;
        TrieNode cur = root;
        for(int i=0;i<word.length();i++){
        	char c = word.charAt(i);
        	TrieNode temp = cur.findChild(c);
        	if(temp==null){
        		cur.children.add(new TrieNode(c));
        		temp = cur.findChild(c);
        	}
        	cur = temp;
        }
        cur.isLeaf=true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
    	for(TrieNode n:root.children){
    		if(searchFromNode(n,word)) return true;
    	}
    	return false;
    }
    
    public boolean searchFromNode(TrieNode cur,String word) {
        if(word.length()==1){
        	if( (word.charAt(0)=='.'||cur.ch==word.charAt(0)) && cur.isLeaf ){
        		return true;
        	}
        	else{
        		return false;
        	}
        }
        char c=word.charAt(0);
        if(c=='.'||cur.ch==c){
        	for(TrieNode n:cur.children){
        		if(searchFromNode(n,word.substring(1))) return true;
        	}
        }
        return false;
    }
    
    class TrieNode {       
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
    
    public static void main(String[] args){
    	WordDictionary inst = new WordDictionary();
    	inst.addWord("ab");
    	System.out.println(inst.search("a."));
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");