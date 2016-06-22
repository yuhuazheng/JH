import java.util.*;

/**
 * Created by yuhuazh on 6/21/2016.
 */
public class WordSearchII {
    public List<String> findWords(char[][] board, String[] words) {
        Trie dict = new Trie();
        for (String w : words) {
            dict.insert(w);
        }
        Set<String> res = new HashSet<>();
        if (board == null || board.length == 0 || board[0].length == 0) return new ArrayList<>(res);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean[][] used = new boolean[board.length][board[0].length];
                DFS(i, j, board, dict, used, new StringBuilder(), res);
            }
        }

        return new ArrayList<>(res);
    }

    private void DFS(int i, int j, char[][] board, Trie dict, boolean[][] used, StringBuilder sb, Set<String> res) {

        used[i][j] = true;
        char ch = board[i][j];
        sb.append(ch);
        String s = sb.toString();
        if (dict.search(s)) {
            res.add(s);
        }
        if (dict.startWith(s)) {
            if (i - 1 >= 0 && !used[i - 1][j])
                DFS(i - 1, j, board, dict, used, sb, res);
            if (i + 1 < board.length && !used[i + 1][j])
                DFS(i + 1, j, board, dict, used, sb, res);
            if (j - 1 >= 0 && !used[i][j - 1])
                DFS(i, j - 1, board, dict, used, sb, res);
            if (j + 1 < board[0].length && !used[i][j + 1])
                DFS(i, j + 1, board, dict, used, sb, res);
        }
        sb.deleteCharAt(sb.length() - 1);
        used[i][j] = false;
    }

    class TrieNode { //tried children=List, HashMap, still timeout in leetcode. array[26] works. so array is most fast and should be considered when low-case string
        public TrieNode[] children = new TrieNode[26];
        public String item = "";

        // Initialize your data structure here.
        public TrieNode() {
        }
    }

    class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // Inserts a word into the trie.
        public void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.item = word;
        }

        // Returns if the word is in the trie.
        public boolean search(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) return false;
                node = node.children[c - 'a'];
            }
            return node.item.equals(word);
        }

        // Returns if there is any word in the trie
        // that starts with the given prefix.
        public boolean startWith(String prefix) {
            TrieNode node = root;
            for (char c : prefix.toCharArray()) {
                if (node.children[c - 'a'] == null) return false;
                node = node.children[c - 'a'];
            }
            return true;
        }
    }
}
